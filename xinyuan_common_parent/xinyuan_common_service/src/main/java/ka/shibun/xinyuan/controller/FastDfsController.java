/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FastDfsController
 * Author:   shibun
 * Date:     2019/3/3 9:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.controller;

import ka.shibun.xinyuan.util.AjaxResult;
import ka.shibun.xinyuan.utils.FastDfsApiOpr;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 *
 *
 *
 * @author shibun
 * @create 2019/3/3
 * @since 1.0.0
 */
@RestController
@RequestMapping("/common")
public class FastDfsController {

    /**
     * 文件上传
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public AjaxResult upload(@RequestBody MultipartFile file){
        //获取后缀
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        try {
            //上传文件,返回的是文件路径
            String filePath = FastDfsApiOpr.upload(file.getBytes(), extension);
            return AjaxResult.me().setSuccess(true).setMsg("操作成功").setObj(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.me().setMsg("操作失败"+e.getMessage()).setSuccess(false);
        }
    }

    /**
     * 删除
     * @param filePath 删除文件信息
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public AjaxResult delete(@RequestParam("filePath") String filePath){
        try {
            filePath = filePath.substring(1);
            //获取组名
            String groupName = filePath.substring(0, filePath.indexOf("/"));
            //获取文件名
            String fileName = filePath.substring(filePath.indexOf("/")+1);
            int delete = FastDfsApiOpr.delete(groupName, fileName);
            if(delete==0){
                return AjaxResult.me().setSuccess(true).setMsg("删除成功");
            }else {
                return AjaxResult.me().setSuccess(false).setMsg("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMsg("删除失败"+e.getMessage()).setSuccess(false);
        }
    }

}