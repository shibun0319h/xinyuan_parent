/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ProductTypeServiceImplTest
 * Author:   shibun
 * Date:     2019/2/28 14:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.service.impl;

import ka.shibun.xinyuan.domain.ProductType;
import ka.shibun.xinyuan.service.IProductTypeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 *
 *
 * @author shibun
 * @create 2019/2/28
 * @since 1.0.0
 */
public class ProductTypeServiceImplTest extends BaseImplTest {

    @Autowired
    private IProductTypeService productTypeService;

    //测试
    @Test
    public void testTree() throws Exception{
        List<ProductType> productTypes = productTypeService.treeData();
    }

}