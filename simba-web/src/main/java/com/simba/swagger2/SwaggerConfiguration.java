package com.simba.swagger2;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simba.common.EnvironmentUtil;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 * 
 * @author caozhejun
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	private static final Log logger = LogFactory.getLog(SwaggerConfiguration.class);

	@Autowired
	private EnvironmentUtil environmentUtil;

	@Bean
	public Docket createRestApi() {
		String packagePath = StringUtils.defaultString(environmentUtil.get("swagger.package"));
		boolean enable = "true".equals(environmentUtil.get("swagger.enable"));
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage(packagePath))
				.paths(enable ? PathSelectors.any() : PathSelectors.none()).build();
		logger.info("*****************初始化swagger2完成*************************");
		return docket;
	}

	private ApiInfo apiInfo() {
		String author = StringUtils.defaultString(environmentUtil.get("swagger.author"), "曹哲军");
		String title = StringUtils.defaultString(environmentUtil.get("swagger.title"), "Sima框架");
		String description = StringUtils.defaultString(environmentUtil.get("swagger.description"), "一个基于Spring Boot的敏捷开发框架");
		String url = StringUtils.defaultString(environmentUtil.get("swagger.url"));
		String email = StringUtils.defaultString(environmentUtil.get("swagger.email"));
		String version = StringUtils.defaultString(environmentUtil.get("swagger.version"), "1.0.0");
		Contact contact = new Contact(author, url, email);
		return new ApiInfoBuilder().title(title).description(description).contact(contact).version(version).build();
	}

}
