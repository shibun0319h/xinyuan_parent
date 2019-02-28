package ka.shibun.xinyuan.service.impl;

import ka.shibun.xinyuan.domain.Product;
import ka.shibun.xinyuan.mapper.ProductMapper;
import ka.shibun.xinyuan.service.IProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
