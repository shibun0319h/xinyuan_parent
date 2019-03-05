/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RedisClientFactory
 * Author:   shibun
 * Date:     2019/3/1 19:31
 * Description: 自定义托底，发生异常会调用该方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.client;

import feign.hystrix.FallbackFactory;
import ka.shibun.xinyuan.util.AjaxResult;
import org.springframework.stereotype.Component;

/**
 *
 * 自定义托底，发生异常会调用该方法
 *
 * @author shibun
 * @create 2019/3/1
 * @since 1.0.0
 */
@Component
public class RedisClientFactory implements FallbackFactory<RedisClient> {

    @Override
    public RedisClient create(Throwable throwable) {
        return new RedisClient() {
            @Override
            public AjaxResult set(String key, String value) {
                return new AjaxResult().setSuccess(false).setMsg("请联系管理员");
            }

            @Override
            public String get(String key) {
                return "异常";
            }
        };
    }
}