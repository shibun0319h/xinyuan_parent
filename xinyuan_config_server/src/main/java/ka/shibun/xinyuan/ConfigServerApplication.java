/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ConfigServerApplication
 * Author:   shibun
 * Date:     2019/2/24 21:02
 * Description: 启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *
 * 启动类
 *
 * @author shibun
 * @create 2019/2/24
 * @since 1.0.0
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class);
    }
}