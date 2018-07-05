package com.simba.web.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorConfig {

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return new EmbeddedServletContainerCustomizer() {

			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/myforbid");
				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/mynopage");
				ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/myerror");
				container.addErrorPages(error401Page, error404Page, error500Page);
			}

		};
	}
}
