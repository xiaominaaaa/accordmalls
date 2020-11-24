package cn.accordmall.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Value("${swagger.enable}")
    boolean enable;

    @Bean
    public Docket docket(){
        Docket docket = new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) //扫描方法上 ApiOperation 注解
                .paths(PathSelectors.any()) //扫描全部路径
                .build()
                .enable(enable); //是否开启
        return docket;
    }

    private ApiInfo apiInfo(){
        return new ApiInfo("雅阁商城的文档",
                "雅阁商城，有个商城",
                    "1.0",
            "urn:tos",
                         new Contact("laosi","wdwdwd","邮箱暂无"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
