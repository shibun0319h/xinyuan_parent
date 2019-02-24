/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EmployeeController
 * Author:   shibun
 * Date:     2019/2/23 16:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.controller;

import ka.shibun.xinyuan.domain.Employee;
import ka.shibun.xinyuan.util.AjaxResult;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody Employee employee){

        //模拟登陆
        if("admain".equals(employee.getUsername())&&"admain".equals(employee.getPassword())){
            return AjaxResult.me().setSuccess(true).setMsg("登陆成功");
        }else {
            return AjaxResult.me().setSuccess(false).setMsg("登陆失败");
        }
    }
}