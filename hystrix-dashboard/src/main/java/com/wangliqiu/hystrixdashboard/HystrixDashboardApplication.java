package com.wangliqiu.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Dashboard功能由 HystrixDashboardConfiguration.ProxyStreamServlet 提供，
 * 该Servlet用来跨域访问event stream, 地址：localhost:9999/proxy.stream?origin=xxx:xxx/hystrix.stream
 * <p>
 * 注意：如果dashboard配置在服务节点，则监控自己节点就没反应，因为ProxyStreamServlet的跨域头？？？
 * */
@EnableHystrixDashboard
// 包含@EnableDiscoveryClient功能，从注册中心获取
@EnableTurbine
@SpringBootApplication
public class HystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}

}
