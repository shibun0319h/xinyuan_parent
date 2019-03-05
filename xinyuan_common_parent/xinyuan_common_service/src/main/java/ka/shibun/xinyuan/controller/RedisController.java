/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RedisController
 * Author:   shibun
 * Date:     2019/3/1 21:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.controller;

import ka.shibun.xinyuan.client.RedisClient;
import ka.shibun.xinyuan.util.AjaxResult;
import ka.shibun.xinyuan.utils.JedisUtil;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 *
 * @author shibun
 * @create 2019/3/1
 * @since 1.0.0
 */
@RestController
@RequestMapping("/common")
public class RedisController implements RedisClient {

    @Override
    @RequestMapping(value = "/redis",method = RequestMethod.POST)
    public AjaxResult set(@RequestParam String key, @RequestParam String value) {
        try {
            //设置值
            JedisUtil.set(key,value);
            return new AjaxResult().setMsg("操作成功").setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            return  new AjaxResult().setMsg("操作失败，请联系管理员").setSuccess(false);
        }
    }

    @Override
    @RequestMapping(value = "/redis/{key}",method = RequestMethod.GET)
    public String get(@PathVariable String key) {
        return JedisUtil.get(key);
    }
}