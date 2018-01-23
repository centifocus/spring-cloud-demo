package com.wangliqiu.ribbon.controller;

import com.wangliqiu.ribbon.service.FeignService;
import com.wangliqiu.ribbon.service.RibbonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

	@Autowired
	RibbonServiceImpl helloService;


	/**
	 * 交替显示 port:8762 、 port:8763 ，说明已经做了负载均衡。
	 */
	@GetMapping("/hi-ribbon")
	public String hiRibbon(@RequestParam String name) {
		return helloService.hiService(name);
	}


	@Autowired
	@Qualifier("service-hi")
	private FeignService feignService;


	@GetMapping("/hi-feign")
	public String hiFeign(@RequestParam String name) {
		return feignService.hi(name);
	}


}