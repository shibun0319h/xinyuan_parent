package ka.shibun.xinyuan.service.impl;

import ka.shibun.xinyuan.domain.Brand;
import ka.shibun.xinyuan.mapper.BrandMapper;
import ka.shibun.xinyuan.query.BrandQuery;
import ka.shibun.xinyuan.service.IBrandService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ka.shibun.xinyuan.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author shibun
 * @since 2019-02-27
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;
    @Override
    public PageList<Brand> queryPage(BrandQuery query) {
        //封装PageList
        PageList<Brand> pageList = new PageList<>();
        long total = brandMapper.queryPageCount(query);
        //如果查出有数据则存入数据
        if(total>0){
            pageList.setTotal(total);
            List<Brand> brands = brandMapper.queryPage(query);
            pageList.setRows(brands);
        }
        return pageList;
    }

    @Override
    public void deleteList(ArrayList list) {
        brandMapper.deleteBatchIds(list);
    }
}
