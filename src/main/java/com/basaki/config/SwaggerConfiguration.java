package com.basaki.config;

import com.google.common.base.Predicate;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * {@code SwaggerConfiguration} configures Swagger UI.
 * <p/>
 *
 * @author Indra Basak
 * @since 12/27/17
 */
@Configuration
@EnableSwagger2
@SuppressWarnings({"squid:CallToDeprecatedMethod"})
public class SwaggerConfiguration {

    /**
     * Creates the Swagger Docket (configuration) bean.
     *
     * @return docket bean
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("book")
                .select()
                .apis(exactPackage("com.basaki.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo("Book Sevice API",
                        "An example of using TLS with Spring Boot"));
    }

    /**
     * Creates an object containing API information including version name,
     * license, etc.
     *
     * @param title       API title
     * @param description API description
     * @return API information
     */
    private ApiInfo apiInfo(String title, String description) {
        Contact contact = new Contact("Indra Basak", "",
                "indra@basak.com");
        return new ApiInfo(title, description, "1.0.0",
                "terms of service url",
                contact, "license", "license url",
                new ArrayList<VendorExtension>());
    }

    private static Predicate<RequestHandler> exactPackage(final String pkg) {
        return input -> input.declaringClass().getPackage().getName().equals(
                pkg);
    }
}
