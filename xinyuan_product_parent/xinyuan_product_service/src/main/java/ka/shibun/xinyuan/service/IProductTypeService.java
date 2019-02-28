package ka.shibun.xinyuan.service;

import ka.shibun.xinyuan.domain.ProductType;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 商品目录 服务类
 * </p>
 *
 * @author shibun
 * @since 2019-02-27
 */
public interface IProductTypeService extends IService<ProductType> {

    //使用递归完成业务
    List<ProductType> treeData();
    //使用for循环
    List<ProductType> treeLoop();
}
