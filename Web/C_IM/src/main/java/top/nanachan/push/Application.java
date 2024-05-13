package top.nanachan.push;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import top.nanachan.push.service.AccountService;

import java.util.logging.Logger;

/**
 * @author leon_ccc
 * @date 2024/5/4 20:18
 */
public class Application extends ResourceConfig {
    public Application() {
        // 注册逻辑处理的包名
        // 逻辑处理全部放到service下
//        同packages("top.nanachan.push.service"); 但是更加灵活
        packages(AccountService.class.getPackage().getName());

        // 注册json转换器
        register((JacksonJsonProvider.class));

        // 注册日志打印输出
        register((Logger.class));
    }
}
