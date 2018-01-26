package com.wangliqiu.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * http://localhost:8769/hi/hi-ribbon?name=forezp&token=22
 */
@Component
@Slf4j
public class AuthFilter extends ZuulFilter {

	/**
	 * "pre" for pre-routing filtering, "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
	 * also support a "static" type for static responses see  StaticResponseFilter.
	 */
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}


	public int filterOrder() {
		return 0;
	}


	public boolean shouldFilter() {
		return true;
	}


	// 可以很复杂，包括查sql，存储等
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));

		Object accessToken = request.getParameter("token");
		if (accessToken == null) {
			log.warn("token is empty");

			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			}
			catch (Exception ignored) {
			}

			return null;
		}

		log.info("token ok");
		return null;
	}

}