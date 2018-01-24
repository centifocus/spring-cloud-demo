package com.wangliqiu.servicehi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8762/hi?name=wangliqiu
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


	@RequestMapping("/hi")
	public String hi(@RequestParam String name) {
		return "hi " + name + ": " + port + " -> " + foo;
	}

}
