/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PlatServiceApplication
 * Author:   shibun
 * Date:     2019/2/23 16:45
 * Description: 入口类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * 入口类
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("ka.shibun.xinyuan.mapper")
public class PlatServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatServiceApplication.class);
    }
}