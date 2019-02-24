/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AjaxResult
 * Author:   shibun
 * Date:     2019/2/23 13:13
 * Description: 用于返回值
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.util;

/**
 *
 * 用于返回值
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
public class AjaxResult {

    private boolean success = true; //默认操作成功

    private String msg = "操作成功"; //返回文本字符信息

    private Object obj; //返回对象

    public static AjaxResult me(){
        return new AjaxResult();
    }

    public boolean isSuccess() {
        return success;
    }

    public AjaxResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public AjaxResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public AjaxResult setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}