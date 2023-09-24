package com.example.spring_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@ServletComponentScan
@SpringBootApplication
public class SpringDemoApplication  {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringDemoApplication.class, args);
		String[] beanDefinitionNames = run.getBeanDefinitionNames();
//		for (String beanDefinitionName : beanDefinitionNames) {
//			System.out.println(beanDefinitionName);
//		}

	}


}
