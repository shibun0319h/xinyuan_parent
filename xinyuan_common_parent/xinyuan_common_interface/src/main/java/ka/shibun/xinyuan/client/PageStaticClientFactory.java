/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PageStaticClientFactory
 * Author:   shibun
 * Date:     2019/3/1 23:50
 * Description: 自定义的托底，发生异常时会调用该方法返回
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.client;

import feign.hystrix.FallbackFactory;
import ka.shibun.xinyuan.util.AjaxResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 *
 * 自定义的托底，发生异常时会调用该方法返回
 *
 * @author shibun
 * @create 2019/3/1
 * @since 1.0.0
 */
@Component
public class PageStaticClientFactory implements FallbackFactory<PageStaticClient> {

    @Override
    public PageStaticClient create(Throwable throwable) {
        return new PageStaticClient() {
            @Override
            public AjaxResult getPageStatic(Map<String, Object> map) {
                return new AjaxResult().setSuccess(true).setMsg("请联系管理员");
            }
        };
    }
}