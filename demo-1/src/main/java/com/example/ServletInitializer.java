package com.example;

import javax.servlet.Filter;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.example.myapp.config.WebConfig;

/*web.xml, root-context.xml, servlet-context.xml 대신 설정*/

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	  protected Class<?>[] getRootConfigClasses() {
	      return null;
	  }
	 
	  @Override
	  protected Class<?>[] getServletConfigClasses() {
	      return new Class<?>[] { WebConfig.class };
	  }
	 
	  @Override
	  protected String[] getServletMappings() {
	      return new String[] { "/" };
	  }
	 
	  @Override
	  protected Filter[] getServletFilters() {
	 
	      CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	      characterEncodingFilter.setEncoding("UTF-8");
	       
	      return new Filter[] { characterEncodingFilter};
	       
	  }


}
