package com.edu.lingnan.fouradminmallboot.swagger;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 23:34 2020/7/13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    private static final String splitor = ";";

    @Bean
    public Docket docket(Environment environment){


        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev");

        //通过enviroment.acceptsProfiles,判断是否处在自己设定的环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .select()
                //RequestHandlerSelectors,配置要扫描接口的方式
                //basePackage,指定要扫描的包
                //any,扫描全部
                //none,不扫描
                //withClassAnnotation,扫描类上的注解
                //withMethodAnnotation，扫描方法上的注解
                .apis(basePackage("com.edu.lingnan.fouradminmallboot.oms.controller"
                        + splitor
                        + "com.edu.lingnan.fouradminmallboot.pms.controller"
                        + splitor
                        + "com.edu.lingnan.fouradminmallboot.ums.controller"
                ))
                .paths(PathSelectors.any())
                //.paths()过滤什么
                .build();
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("four-admin-mall","", "1244785737@qq.com");

        return new ApiInfo(
                "Four-Admin-Mall-Swagger文档",
                "Four-Admin-Mall后端接口文档描述",
                "v1.0",
                "",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }

}
