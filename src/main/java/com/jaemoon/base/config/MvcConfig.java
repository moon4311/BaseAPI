package com.jaemoon.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;

import com.jaemoon.base.interceptor.WebInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


	private final long MAX_AGE_SECS = 3600;
	
	@Value("${url.allowedOrigins}")
	private String allowedOrigins;
	
    @Bean
    public WebInterceptor webInterceptor() {
        return new WebInterceptor();
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webInterceptor())
//                .addPathPatterns("/**/*")
//                .addPathPatterns("/loginProcess") //app jwt 확인
                .excludePathPatterns("/open/*"); 
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**")
		        .allowedOrigins(allowedOrigins.split(","))
		        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
		        .allowedHeaders("*")
		        .allowCredentials(true)
		        .maxAge(MAX_AGE_SECS);
    }
    
    @Bean
    public BeanNameViewResolver resolver() {
        BeanNameViewResolver resolver = new BeanNameViewResolver();
        resolver.setOrder(0);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(31556926);
    }

}
