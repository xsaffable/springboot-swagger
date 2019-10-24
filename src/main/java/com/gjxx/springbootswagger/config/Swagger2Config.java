package com.gjxx.springbootswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Sxs
 * @description Swagger配置类，只在开发环境启用
 * @date 2019/10/24 11:32
 */
@Configuration
@EnableSwagger2
@Profile({"dev"})
public class Swagger2Config {

    /**
     * 创建Docket对象，并交给springboot管理
     * @return Docket对象
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gjxx.springbootswagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 自定义信息
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("接口测试")
                // 联系人
                .contact(new Contact("Sxs", "http://www.xxx.com", "xxx@qq.xom"))
                // 版本号
                .version("1.0")
                // 描述
                .description("springboot集成swagger2测试")
                .build();

    }

}
