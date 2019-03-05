package ka.shibun.xinyuan.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import ka.shibun.xinyuan.client.PageStaticClient;
import ka.shibun.xinyuan.client.RedisClient;
import ka.shibun.xinyuan.constants.GlobalConstants;
import ka.shibun.xinyuan.domain.ProductType;
import ka.shibun.xinyuan.mapper.ProductTypeMapper;
import ka.shibun.xinyuan.service.IProductTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ka.shibun.xinyuan.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author shibun
 * @since 2019-02-27
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private PageStaticClient pageStaticClient;

    /**
     * 查询菜单，自关联多次查询
     * 方案1：递归查询,但是效率太低了
     * @return
     */
    @Override
    public List<ProductType> treeData() {
        //传入顶层父类，然后一直执行查询直到查完
        return treeDataRecursion(0L);
    }

    /**
     * 方案2：一次查询完后使用循环
     * @return
     */
    @Override
    public List<ProductType> treeLoop() {
        //调用公共服务，如果redis中有就从缓存中拿
        String jsonArrStr = redisClient.get(GlobalConstants.REDIS_PRODUCTTYPE_KEY);
        //如果没有数据则从数据库查询并存入redis
        if(StringUtils.isEmpty(jsonArrStr)){
            System.out.println("数据库");
            List<ProductType> treeLoop = getTreeLoop();
            jsonArrStr = JSONArray.toJSONString(treeLoop);
            //这里的返回AJaxResult前台没用上，暂时先这样
            AjaxResult set = redisClient.set(GlobalConstants.REDIS_PRODUCTTYPE_KEY, jsonArrStr);
            return treeLoop;
        }else{
            System.out.println("缓存");

            return JSONArray.parseArray(jsonArrStr,ProductType.class);
        }


    }

    //将循环查询的方法提取出来
    public List<ProductType> getTreeLoop() {
        //先获取所有数据
        List<ProductType> productTypes = productTypeMapper.selectList(null);
        //使用map存入他们之间的关系
        Map<Long,ProductType> map = new HashMap<>();
        for (ProductType productType : productTypes) {
            map.put(productType.getId(),productType);
        }
        //返回结果的集合
        List<ProductType> list = new ArrayList<>();

        //再遍历一次判断是否有pid
        for (ProductType productType : productTypes) {
            Long pid = productType.getPid();
            if (pid==0){
                //list中添加顶级父目录
                list.add(productType);
            }else {
                //如果有pid则在map中查出其对应的值查出的为父类
                ProductType parent = map.get(pid);
                //然后在父类中添加这个子类
                parent.getChildren().add(productType);
            }
        }
        return list;
    }


    //递归逻辑
    private List<ProductType> treeDataRecursion(Long pid) {
        //执行查询
        List<ProductType> children = getAllChildren(pid);
        //如果已经是最底层的子类了查询结束
        if(children==null||children.size()==0){
            return children;
        }else {
            //如果还有子类则继续查询
            for (ProductType child : children) {
                List<ProductType> productTypes = treeDataRecursion(child.getId());
                //存入关系
                child.setChildren(productTypes);
            }
        }
        return children;
    }

    //执行查询对应的子类
    private List<ProductType> getAllChildren(Long pid) {
        Wrapper<ProductType> wrapper= new EntityWrapper<>();
        wrapper.eq("pid",pid);
        return productTypeMapper.selectList(wrapper);
    }


    /**
     * 修改数据后对页面模板进行修改
     */
    @Override
    public boolean updateById(ProductType entity) {
        Map<String,Object> mapProductType = new HashMap<>();
        //重新从数据库查询
        List<ProductType> list = getTreeLoop();
        //生成修改tree的productType模板
        mapProductType.put(GlobalConstants.PAGE_MODE,list);
        mapProductType.put(GlobalConstants.PAGE_TEMPLATE,"D:\\IdeaWorkSpace\\xinyuan_parent\\xinyuan_common_parent\\xinyuan_common_interface\\src\\main\\resources\\template\\product.type.vm");
        mapProductType.put(GlobalConstants.PAGE_TEMPLATE_HTML,"D:\\IdeaWorkSpace\\xinyuan_parent\\xinyuan_common_parent\\xinyuan_common_interface\\src\\main\\resources\\template\\product.type.vm.html");
        pageStaticClient.getPageStatic(mapProductType);

        //生成home的模板
        Map<String ,Object> mapHome = new HashMap<>();
        //数据
        Map<String,String> staticRootMap=new HashMap<>();
        staticRootMap.put("staticRoot","D:\\IdeaWorkSpace\\xinyuan_parent\\xinyuan_common_parent\\xinyuan_common_interface\\src\\main\\resources");
        mapHome.put(GlobalConstants.PAGE_MODE, staticRootMap);//这里页面需要的是目录的根路径
        mapHome.put(GlobalConstants.PAGE_MODE,"D:\\IdeaWorkSpace\\xinyuan_parent\\xinyuan_common_parent\\xinyuan_common_interface\\src\\main\\resources\\template\\home.vm");
        //根据模板生成的页面的地址:
        mapHome.put(GlobalConstants.PAGE_TEMPLATE_HTML,"D:\\IdeaWorkSpace\\xinyuan_parent\\xinyuan_common_parent\\xinyuan_common_interface\\src\\main\\resources\\template\\home.html");
        pageStaticClient.getPageStatic(mapHome);

        return super.updateById(entity);
    }
}
