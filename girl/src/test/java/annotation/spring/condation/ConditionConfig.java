package annotation.spring.condation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import annotation.spring.condation.bean.LinuxListService;
import annotation.spring.condation.bean.ListService;
import annotation.spring.condation.bean.WindowsListService;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/12/7.
 * Time: 下午 7:48.
 * Explain:配置类
 */
@Configuration
public class ConditionConfig {
    //matches方法返回true的，就运行哪个方法
    @Bean
    @Conditional(WindowsCondition.class)//通过@Condition注解，符合Windows条件则实例化windowsListService
    public ListService windowsListService(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)//通过@Condition注解,符合Linux条件则实例化linuxListService
    public ListService linuxListService(){
        return new LinuxListService();
    }
}