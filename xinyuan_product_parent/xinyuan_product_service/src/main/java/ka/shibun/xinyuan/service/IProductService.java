package ka.shibun.xinyuan.service;

import ka.shibun.xinyuan.domain.Product;
import com.baomidou.mybatisplus.service.IService;
import ka.shibun.xinyuan.query.ProductQuery;
import ka.shibun.xinyuan.util.PageList;

/**
 * <p>
 * 商品 服务类
 * </p>
 *
 * @author shibun
 * @since 2019-02-27
 */
public interface IProductService extends IService<Product> {

    PageList<Product> selectQuery(ProductQuery query);
}
