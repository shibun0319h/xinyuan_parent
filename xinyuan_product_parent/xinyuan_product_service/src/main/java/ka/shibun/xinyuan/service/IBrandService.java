package ka.shibun.xinyuan.service;

import ka.shibun.xinyuan.domain.Brand;
import com.baomidou.mybatisplus.service.IService;
import ka.shibun.xinyuan.query.BrandQuery;
import ka.shibun.xinyuan.util.PageList;

import java.util.ArrayList;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author shibun
 * @since 2019-02-27
 */
public interface IBrandService extends IService<Brand> {

    PageList<Brand> queryPage(BrandQuery query);

    void deleteList(ArrayList list);
}
