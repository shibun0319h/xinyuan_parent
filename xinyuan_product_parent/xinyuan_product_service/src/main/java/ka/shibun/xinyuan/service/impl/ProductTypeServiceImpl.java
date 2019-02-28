package ka.shibun.xinyuan.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import ka.shibun.xinyuan.domain.ProductType;
import ka.shibun.xinyuan.mapper.ProductTypeMapper;
import ka.shibun.xinyuan.service.IProductTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
