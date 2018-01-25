package com.wangliqiu.serviceoh.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:9949/oh?name=wangliqiu
 */
@RestController
public class OhController {

	@Value("${server.port}")
	String port;


	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping("/oh")
	public String oh(@RequestParam String name) {
		return "oh " + name + ", port:" + port;
	}


	public String fallback() {
		return "service-hi:" + port + " fallback!";
	}

}
