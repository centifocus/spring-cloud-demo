package com.wangliqiu.servicehi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8762/hi?name=wangliqiu
 */
@RestController
// RefreshRemoteApplicationEvent 会触发HiController新实例
@RefreshScope
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
