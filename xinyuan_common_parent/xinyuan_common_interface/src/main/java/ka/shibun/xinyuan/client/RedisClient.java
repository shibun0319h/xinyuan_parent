/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RedisClient
 * Author:   shibun
 * Date:     2019/3/1 19:21
 * Description: fegin接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.client;

import ka.shibun.xinyuan.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * fegin接口
 *
 * @author shibun
 * @create 2019/3/1
 * @since 1.0.0
 */
@FeignClient(value = "XINYUAN-COMMON",fallbackFactory = RedisClientFactory.class)
@RequestMapping("/common")
public interface RedisClient {

    @RequestMapping(value = "/redis",method = RequestMethod.POST)
    AjaxResult set(@RequestParam("key") String key, @RequestParam("value") String value);

    @RequestMapping(value = "/redis/{key}",method = RequestMethod.GET)
    String get(@PathVariable(value = "key") String key);
}