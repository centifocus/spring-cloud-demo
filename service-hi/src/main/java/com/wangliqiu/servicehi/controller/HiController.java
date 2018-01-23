package com.wangliqiu.servicehi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8762/hi?name=wangliqiu
 */
@RestController
public class HiController {

	@Value("${server.port}")
	String port;


	@RequestMapping("/hi")
	public String hi(@RequestParam String name, /* 从配置中心获取 */ @Value("${foo}") String foo) {
		return "hi " + name + ": " + port + " -> " + foo;
	}

}
