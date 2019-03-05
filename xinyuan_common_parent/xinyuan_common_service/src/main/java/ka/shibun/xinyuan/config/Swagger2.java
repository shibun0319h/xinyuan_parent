/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Swagger2
 * Author:   shibun
 * Date:     2019/2/23 19:12
 * Description: swagger接口文档
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * swagger接口文档
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ka.shibun.xinyuan.controller"))
                //包：就是自己接口的包路径
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("新源商品系统api")//名字
                .description("商品系统接口文档说明")//额外描述
                .contact(new Contact("shibun", "", "shibun0319@gmail.com"))
                .version("1.0")// 版本
                .build();
    }

}