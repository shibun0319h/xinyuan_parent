package ka.shibun.xinyuan.service.impl;

import ka.shibun.xinyuan.domain.Brand;
import ka.shibun.xinyuan.domain.Product;
import ka.shibun.xinyuan.domain.ProductExt;
import ka.shibun.xinyuan.mapper.ProductExtMapper;
import ka.shibun.xinyuan.mapper.ProductMapper;
import ka.shibun.xinyuan.query.ProductQuery;
import ka.shibun.xinyuan.service.IProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ka.shibun.xinyuan.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author shibun
 * @since 2019-02-27
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductExtMapper productExtMapper;

    /**
     * 分别执行两次添加，添加到对应的表中
     * @param entity
     * @return
     */
    @Override
    public boolean insert(Product entity) {

        //添加到product表
        boolean insert = super.insert(entity);
        //获取product属性
        ProductExt productExt = entity.getProductExt();
        //设置对应的产品id
        if(productExt!=null){
            productExt.setProductId(entity.getId());
            productExtMapper.insert(productExt);
        }


        return insert;
    }

    @Override
    public PageList<Product> selectQuery(ProductQuery query) {
        //封装PageList
        PageList<Product> pageList = new PageList<>();
        long total = productMapper.queryPageCount(query);
        //如果查出有数据则存入数据
        if(total>0){
            pageList.setTotal(total);
            List<Product> products = productMapper.queryPage(query);
            pageList.setRows(products);
        }
        return pageList;
    }
}
