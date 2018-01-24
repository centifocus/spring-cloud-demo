package com.wangliqiu.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonServiceImpl {

	@Autowired
	RestTemplate restTemplate;


	@HystrixCommand(fallbackMethod = "fallback")
	public String hiService(String name) {
		// 直接用的应用名替代了具体的uri地址，在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名。
		return restTemplate.getForObject("http://service-hi/hi?name=" + name, String.class);
	}


	public String fallback(String name) {
		return "hi," + name + " fallback!";
	}

}