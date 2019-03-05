/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FastDfsApiOpr
 * Author:   shibun
 * Date:     2019/3/3 9:22
 * Description: fastdfs上传下载文件的方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.utils;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

/**
 *
 * fastdfs上传下载文件的方法
 *
 * @author shibun
 * @create 2019/3/3
 * @since 1.0.0
 */
public class FastDfsApiOpr {

    public static String CONF_FILENAME  = FastDfsApiOpr.class.getResource("/tracker_server.conf").getFile();

    /**
     * 上传文件
     * @param file 上传的文件
     * @param extName 后缀名
     * @return
     */
    public static  String upload(byte[] file,String extName) {

        try {
            ClientGlobal.init(CONF_FILENAME);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            NameValuePair nvp [] = new NameValuePair[]{
                    new NameValuePair("age", "18"),
                    new NameValuePair("sex", "male")
            };
            String fileIds[] = storageClient.upload_file(file,extName,nvp);

            System.out.println("组名：" + fileIds[0]);
            System.out.println("路径: " + fileIds[1]);
            return  "/"+fileIds[0]+"/"+fileIds[1];

        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    /**
     * 下载文件
     * @param groupName
     * @param fileName
     * @return
     */
    public static byte[] download(String groupName,String fileName) {
        try {

            ClientGlobal.init(CONF_FILENAME);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            byte[] b = storageClient.download_file(groupName, fileName);
            return  b;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }



    /**
     * 删除文件
     * @param groupName
     * @param fileName
     */
    public static int delete(String groupName,String fileName){
        try {
            ClientGlobal.init(CONF_FILENAME);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            int i = storageClient.delete_file(groupName,fileName);
            System.out.println( i==0 ? "删除成功" : "删除失败:"+i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("删除异常,"+e.getMessage());
        }
    }
}