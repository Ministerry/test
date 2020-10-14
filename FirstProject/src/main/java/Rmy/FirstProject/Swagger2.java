package Rmy.FirstProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)//Docket不懂
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("Rmy.FirstProject.Controller"))//扫描?
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")//title
                .description("不会请百度http://www.baidu.com")//title下的描述
                .termsOfServiceUrl("http://www.taobao.com")//Terms of service超链接
                .contact("任明宇")//?
                .version("1.0").build();
    }

}
