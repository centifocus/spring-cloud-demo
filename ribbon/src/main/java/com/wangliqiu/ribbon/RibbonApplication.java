package com.wangliqiu.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 消费端：RestTemplate + Ribbon 或 Feign (Feign具有可插拔的注解特性（Feign注解和JAX-RS注解）。默认集成了Ribbon)
 */
// 向服务中心获取服务信息
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}

	@Bean
	// 表明这个RestTemplate会采用Ribbon
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
