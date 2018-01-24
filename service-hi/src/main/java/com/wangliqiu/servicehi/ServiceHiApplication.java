package com.wangliqiu.servicehi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

/**
 * Actuator Endpoint: /service-registry/instance-status via a GET will return the status of the Registration
 */

// When a client registers with Eureka, it provides meta-data about itself such as host and port, health indicator URL, home page etc.
// If the heartbeat fails over a configurable timetable, the instance is normally removed from the registry.
// By default, EurekaClient uses Jersey for HTTP communication. If you don't want Jersey, you can exclude it from your dependencies
// EurekaClient have an in-memory cache of eureka registrations，这样不用每次请求都走注册中心拉信息。
@EnableEurekaClient
/* it is no longer required. It is enough to just have a DiscoveryClient implementation on the classpath to
 cause the Spring Boot application to register with the service discovery server. */
/* This looks for implementations of the DiscoveryClient interface via META-INF/spring.factories. Implementations of Discovery Client
will add a configuration class to spring.factories under the org.springframework.cloud.client.discovery.EnableDiscoveryClient key. */
// @EnableDiscoveryClient
@SpringBootApplication
public class ServiceHiApplication {

	public static void main(String[] args) {
//		new SpringApplicationBuilder()
//				.main(ServiceHiApplication.class)
//				.sources()
//				.run(args);

		SpringApplication.run(ServiceHiApplication.class, args);

	}


	// 采样器，这里用总是采样
	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}

}
