package ka.shibun.xinyuan.mapper;

import ka.shibun.xinyuan.domain.Brand;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import ka.shibun.xinyuan.query.BaseQuery;
import ka.shibun.xinyuan.query.BrandQuery;
import ka.shibun.xinyuan.util.PageList;

import java.util.List;

/**
 * <p>
 * 品牌信息 Mapper 接口
 * </p>
 *
 * @author shibun
 * @since 2019-02-27
 */
public interface BrandMapper extends BaseMapper<Brand> {

    //由于关联查询,因此单独查询条件查询的数据
    List<Brand> queryPage(BrandQuery query);

    //由于关联查询，因此单独查询对应分页的数据
    long queryPageCount(BrandQuery query);

}
