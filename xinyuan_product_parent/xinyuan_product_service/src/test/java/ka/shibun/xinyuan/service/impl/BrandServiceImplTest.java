package ka.shibun.xinyuan.service.impl;

import ka.shibun.xinyuan.ProductApplication;
import ka.shibun.xinyuan.domain.Brand;
import ka.shibun.xinyuan.query.BrandQuery;
import ka.shibun.xinyuan.service.IBrandService;
import ka.shibun.xinyuan.util.PageList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


public class BrandServiceImplTest extends BaseImplTest{

    @Autowired
    private IBrandService brandService;
    @Test
    public void queryPage() {
        BrandQuery brandQuery = new BrandQuery();
        PageList<Brand> pageList = brandService.queryPage(brandQuery);
    }
}