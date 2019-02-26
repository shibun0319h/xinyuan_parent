/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: InterfaceApplication
 * Author:   shibun
 * Date:     2019/2/26 22:33
 * Description: 启动类，主要用于测试连接
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * 启动类，主要用于测试连接
 *
 * @author shibun
 * @create 2019/2/26
 * @since 1.0.0
 */
@SpringBootApplication
@MapperScan("ka.shibun.xinyuan.mapper")
public class InterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterfaceApplication.class);
    }
}