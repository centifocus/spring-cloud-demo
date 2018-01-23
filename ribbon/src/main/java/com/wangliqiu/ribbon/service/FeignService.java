package com.wangliqiu.ribbon.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// declaring a REST client with this interface should be created (e.g. for autowiring into controller)
@FeignClient(
		qualifier = "service-hi",
		value = "service-hi",
		// The fallback class must implement the interface annotated by this annotation and be a valid spring bean.
		fallback = FeignServiceFallback.class
)
public interface FeignService {

	@GetMapping("/hi")
	String hi(@RequestParam("name") String name);

}