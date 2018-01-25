package com.wangliqiu.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Dashboard功能由 HystrixDashboardConfiguration.ProxyStreamServlet 提供，
 * 该Servlet用来跨域访问event stream, 地址：localhost:9999/proxy.stream?origin=xxx:xxx/hystrix.stream
 * <p>
 * 注意：如果dashboard配置在服务节点，则监控自己节点就没反应，因为ProxyStreamServlet的跨域头？？？
 * 注意：服务节点的hystrix不被调用就不发送消息？所以一开始不调用服务节点，dashboard就卡住。
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}

}
