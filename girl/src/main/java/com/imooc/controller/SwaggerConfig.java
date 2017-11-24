package com.imooc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	 /**
     * SpringBoot默认已经将classpath:/META-INF/resources/和classpath:/META-INF/resources/webjars/映射
     * 所以该方法不需要重写，如果在SpringMVC中，可能需要重写定义（我没有尝试）
     * 重写该方法需要 extends WebMvcConfigurerAdapter
     *
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
   
    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了
     * （访问页面就可以看到效果了）
     *
     */
   
    @SuppressWarnings("unchecked")
    @Bean
    public Docket testApi(){
       Docket docket = new Docket(DocumentationType.SWAGGER_2)
              .groupName("test")
              .genericModelSubstitutes(DeferredResult.class)
              .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(Predicates.or(PathSelectors.regex("/hello/.*")))//过滤的接口
                .build()
                .apiInfo(testApiInfo());
              ;
       return docket;
    }
   
    @SuppressWarnings("unchecked")
    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
                .genericModelSubstitutes(DeferredResult.class)
//              .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .paths(Predicates.or(PathSelectors.regex("/demo/.*")))//过滤的接口
                .build()
                .apiInfo(demoApiInfo());
    }
    
    
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("tudou")
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.imooc.controller"))//要扫描的API(Controller)基础包
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo buildApiInf() {
          return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2 UI构建API文档")
                .contact("土豆")
                .version("1.0")
                .build();
    }
   
     private ApiInfo testApiInfo() {
            ApiInfo apiInfo = new ApiInfo("Test相关接口",//大标题
                    "Test相关接口，主要用于测试.",//小标题
                    "1.0",//版本
                    "http://412887952-qq-com.iteye.com/",
                    "Angel",//作者
                    "北京知远信息科技有限公司",//链接显示文字
                    "http://www.kfit.com.cn/"//网站链接
            );
 
            return apiInfo;
        }
 
        private ApiInfo demoApiInfo() {
            ApiInfo apiInfo = new ApiInfo("Demo相关接口",//大标题
                    "Demo相关接口，获取个数，获取列表，注意：",//小标题
                    "1.0",//版本
                    "http://412887952-qq-com.iteye.com/",
                    "Angel",//作者
                    "北京知远信息科技有限公司",//链接显示文字
                    "http://www.kfit.com.cn/"//网站链接
            );
 
            return apiInfo;
        }
}
