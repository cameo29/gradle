package com.example.myapp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.example.myapp.controller"})
public class WebConfig extends WebMvcConfigurerAdapter{

		/*CSS 설정*/
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry){
			registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		}
		

		@Bean
	    public LocaleResolver localeResolver() {
	 
	        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
	        cookieLocaleResolver.setDefaultLocale(StringUtils.parseLocaleString("en"));
	        return cookieLocaleResolver;
	    }

		@Bean
	    public ViewResolver viewResolver() {
	 
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	 
	        return viewResolver;
	    }
	 
	    


}
