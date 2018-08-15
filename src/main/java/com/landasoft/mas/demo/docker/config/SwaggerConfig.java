package com.landasoft.mas.demo.docker.config;

import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.builders.RequestHandlerSelectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.Order;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import org.springframework.core.Ordered;
import java.util.*;
 
/**
 * swagger 配置
 * @author wulinyun
 * 2018年8月15日下午4:33:36
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
 
    @Bean
    public Docket globalApi() {
 
        List<Parameter> pars = new ArrayList<>();
        //pars.add(new ParameterBuilder().name("corp_key").description("当前企业标识").modelRef(new ModelRef("string")).parameterType("header").required(false).build());
        //pars.add(new ParameterBuilder().name("token").description("用户凭证").modelRef(new ModelRef("string")).parameterType("header").required(false).build());
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .securitySchemes(Collections.singletonList(new BasicAuth("basicAuth")))
                .securityContexts(Collections.singletonList(securityContext()))
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }
 
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(basicAuth())
                .forPaths(PathSelectors.any())
                .build();
    }
 
    private List<SecurityReference> basicAuth() {
        return Collections.singletonList(SecurityReference.builder()
                .reference("basicAuth")
                .scopes(new AuthorizationScope[0])
                .build());
    }
 
 
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("springboot-docker-demo微应用")
                .description("demo微应用")
                .version("v1")
                .build();
    }
 
    @Bean
    public TranslationOperationBuilderPlugin translationPlugin() {
        return new TranslationOperationBuilderPlugin();
    }
 
    @Order(Ordered.LOWEST_PRECEDENCE)
    public static class TranslationOperationBuilderPlugin implements OperationBuilderPlugin {
 
        @Autowired
        private MessageSource translator;
 
        @Override
        public boolean supports(DocumentationType delimiter) {
            return true;
        }
 
        @Override
        public void apply(OperationContext context) {
            Set<ResponseMessage> messages = context.operationBuilder().build().getResponseMessages();
            Set<ResponseMessage> translated = new HashSet<>();
            for (ResponseMessage untranslated : messages) {
                String translation = translator.getMessage(untranslated.getMessage(), null, untranslated.getMessage(), null);
                translated.add(new ResponseMessage(untranslated.getCode(),
                        translation,
                        untranslated.getResponseModel(),
                        untranslated.getHeaders(),
                        untranslated.getVendorExtensions()));
            }
            context.operationBuilder().responseMessages(translated);
        }
 
    }
}