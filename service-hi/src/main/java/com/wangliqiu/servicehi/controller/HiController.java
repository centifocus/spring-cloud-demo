package com.wangliqiu.servicehi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:9941/hi?name=wangliqiu
 */
@RestController
// RefreshRemoteApplicationEvent 会触发RefreshScope的refreshAll()和refresh(String)，从而HiController新实例
// Refresh scope beans are lazy proxies that initialize when they are used
@RefreshScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HiController {

	@Value("${server.port}")
	String port;

	/* 从配置中心获取 */
	@Value("${foo}")
	String foo;


	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping("/hi")
	public String hi(@RequestParam String name) {
		return "hi " + name + ": " + port + " -> " + foo;
	}


	public String fallback(String name) {
		return "service-hi:" + port + "  " + name + " fallback!";
	}

}
