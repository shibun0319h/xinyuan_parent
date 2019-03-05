/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ProductApplication
 * Author:   shibun
 * Date:     2019/2/27 19:42
 * Description: 启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan;

import ka.shibun.xinyuan.domain.Product;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * 启动类
 *
 * @author shibun
 * @create 2019/2/27
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "ka.shibun.xinyuan.client")
@MapperScan("ka.shibun.xinyuan.mapper")
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class);
    }
}