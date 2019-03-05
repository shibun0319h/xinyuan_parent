/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CommonApplication
 * Author:   shibun
 * Date:     2019/3/1 18:36
 * Description: 启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * 启动类
 *
 * @author shibun
 * @create 2019/3/1
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class);

    }
}