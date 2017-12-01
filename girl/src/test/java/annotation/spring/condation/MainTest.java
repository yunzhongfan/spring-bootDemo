package annotation.spring.condation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import annotation.spring.condation.bean.ListService;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/12/7.
 * Time: 下午 7:57.
 * Explain:运行类
 */
public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name")
            +"系统下的列表命令为："
                +listService.showListCmd()
        );
    }
}