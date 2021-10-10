package com.jose.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class RegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}

  @Configuration
  public class MyConfiguration {

    @Bean
    public FilterRegistrationBean corsFilter() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);
      config.addAllowedOrigin("http://localhost:4200");
      config.addAllowedHeader("*");
      config.addAllowedMethod("*");
      source.registerCorsConfiguration("/**", config);
      FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
      bean.setOrder(0);
      return bean;
    }
  }


//  @Bean
//  public CorsFilter corsFilter(){
//    CorsConfiguration corsConfiguration = new CorsConfiguration();
//    corsConfiguration.setAllowCredentials(true);
//    corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//    corsConfiguration.setAllowedOrigins(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//      "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
//      "Access-Control-Request-Method", "Access-Control-Request-Headers"));
//    corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization","Access-Control-Allow-Origin",
//      "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
//    corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT","DELETE", "OPTIONS"));
//    UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//    urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//    return new CorsFilter(urlBasedCorsConfigurationSource);
//
//
//  }

}
