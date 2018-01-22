package com.wangliqiu.servicehi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 当EurekaClient向EurekaServer注册时，它会提供一些元数据，例如主机和端口，URL，主页等。Eureka server 从每个client实例接收心跳消息。
 * 如果心跳超时，则通常将该实例从注册server中删除。
 */
@EnableEurekaClient
@SpringBootApplication
public class ServiceHiApplication {

	public static void main(String[] args) {
//		new SpringApplicationBuilder()
//				.main(ServiceHiApplication.class)
//				.sources()
//				.run(args);

		SpringApplication.run(ServiceHiApplication.class, args);

	}

}
