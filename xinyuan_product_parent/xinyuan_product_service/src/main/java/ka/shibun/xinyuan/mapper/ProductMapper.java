package ka.shibun.xinyuan.mapper;

import ka.shibun.xinyuan.domain.Product;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import ka.shibun.xinyuan.query.ProductQuery;

import java.util.List;

/**
 * <p>
 * 商品 Mapper 接口
 * </p>
 *
 * @author shibun
 * @since 2019-02-27
 */
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> queryPage(ProductQuery query);

    long queryPageCount(ProductQuery query);
}
