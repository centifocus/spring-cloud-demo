package com.wangliqiu.servicehi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8762/hi?name=wangliqiu
 */
@RestController
// RefreshRemoteApplicationEvent 会触发HiController新实例
//@RefreshScope  // todo 报错了？？？
public class HiController {

	@Value("${server.port}")
	String port;

	// todo 报错了？？？
	/* 从配置中心获取 */
//	@Value("${foo}")
//	String foo;


	@RequestMapping("/hi")
	public String hi(@RequestParam String name, @Value("${foo}") String foo) {
		return "hi " + name + ": " + port + " -> " + foo;
	}

}
