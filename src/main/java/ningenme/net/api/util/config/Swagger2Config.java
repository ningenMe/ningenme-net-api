package ningenme.net.api.util.config;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer {

  @Value("${ningenme.net.hostname}")
  private String hostName;

  @Value("${ningenme.net.protocol}")
  private String protocol;

  @Bean
  public Docket swaggerSpringMvcPlugin() {
    return new Docket(DocumentationType.SWAGGER_2)
            .groupName("ningenme.net.api")
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.regex("/v1/.*"))
            .build()
            .host(hostName)
            .useDefaultResponseMessages(false)
            .protocols(Sets.newHashSet(protocol))
            .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("ningenMe net api")
            .description("趣味開発API一覧")
            .version("1.0.1")
            .build();
  }

  @Bean
  public UiConfiguration uiConfig() {
    return UiConfigurationBuilder.builder()
            .deepLinking(true)
            .displayRequestDuration(true)
            .defaultModelsExpandDepth(-1)
            .docExpansion(DocExpansion.LIST)
            .validatorUrl("")
            .filter(true)
            .build();
  }

  /**
   * application.yamlで静的リソースへのアクセスを禁止している。ただしswaggerだけは見れるようにする必要がある、
   * そのための設定。
   * @param resourceHandlerRegistry
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
    resourceHandlerRegistry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
    resourceHandlerRegistry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
