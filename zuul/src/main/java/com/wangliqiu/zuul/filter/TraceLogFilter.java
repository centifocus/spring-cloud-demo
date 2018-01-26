package com.wangliqiu.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

/**
 * todo traceId 是怎么生成的？
 *
 * @implNote TraceFilter是一个spring内部bean，如果用户自己写的bean为TraceFilter会被覆盖的，妈的
 */
@Component
public class TraceLogFilter extends ZuulFilter {

	// TraceAutoConfiguration生成
	@Autowired
	Tracer tracer;


	public String filterType() {
		return FilterConstants.POST_TYPE;
	}


	public int filterOrder() {
		return 900;
	}


	public boolean shouldFilter() {
		return true;
	}


	public Object run() {
		tracer.addTag("filter", "TraceFilter");
		System.out.print("traceId: " + tracer.getCurrentSpan().traceIdString());

		return null;
	}

}