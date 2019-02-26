/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MybatisPlusConfig
 * Author:   shibun
 * Date:     2019/2/26 19:36
 * Description: springboot方式分页插件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * springboot方式分页插件
 *
 * @author shibun
 * @create 2019/2/26
 * @since 1.0.0
 */
@EnableTransactionManagement
@Configuration
@MapperScan("ka.shibun.xinyuan.mapper")//mapper的路径
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}