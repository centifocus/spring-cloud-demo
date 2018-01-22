package com.wangliqiu.ribbon.service;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallback implements FeignService {

	public String hi(String name) {
		return "hi " + name + " fallback!";
	}

}