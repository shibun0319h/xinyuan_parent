/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PageStaticClient
 * Author:   shibun
 * Date:     2019/3/1 23:48
 * Description: 生成模板的接口服务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.client;

import ka.shibun.xinyuan.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 *
 * 生成模板的接口服务
 *
 * @author shibun
 * @create 2019/3/1
 * @since 1.0.0
 */
@FeignClient(value = "XINYUAN-COMMON",fallbackFactory = PageStaticClientFactory.class)
@RequestMapping("/common")
public interface PageStaticClient {

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    AjaxResult getPageStatic(@RequestBody Map<String,Object> map);
}