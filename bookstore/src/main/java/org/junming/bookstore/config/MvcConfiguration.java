package org.junming.bookstore.config;

import org.junming.bookstore.util.BookPermissionDAO;
import org.junming.bookstore.util.BookPermissionDAOIml;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="org.junming.bookstore")
@EnableWebMvc
@ImportResource("classpath:spring/spring-dao.xml")
//@Import(org.junming.bookstore.config.SecurityConfig.class)
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public BookPermissionDAO getBookPermissionDAO(){
		return new BookPermissionDAOIml();
	}

}
