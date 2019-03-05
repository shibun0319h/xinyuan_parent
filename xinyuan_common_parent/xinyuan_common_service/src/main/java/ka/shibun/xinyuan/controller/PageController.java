/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PageController
 * Author:   shibun
 * Date:     2019/3/1 23:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.controller;

import ka.shibun.xinyuan.client.PageStaticClient;
import ka.shibun.xinyuan.constants.GlobalConstants;
import ka.shibun.xinyuan.util.AjaxResult;
import ka.shibun.xinyuan.utils.VelocityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
public class PageController implements PageStaticClient {

    @Override
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public AjaxResult getPageStatic(@RequestBody Map<String, Object> map) {
        Object model = map.get(GlobalConstants.PAGE_MODE);
        String templateFilePathAndName = (String)map.get(GlobalConstants.PAGE_TEMPLATE);
        String targetFilePathAndName = (String)map.get(GlobalConstants.PAGE_TEMPLATE_HTML);
        VelocityUtils.staticByTemplate(model,templateFilePathAndName,targetFilePathAndName);
        return new AjaxResult().setSuccess(true).setMsg("操作成功");
    }
}