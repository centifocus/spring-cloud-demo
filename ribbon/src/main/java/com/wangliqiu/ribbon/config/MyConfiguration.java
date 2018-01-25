package com.wangliqiu.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalancedBackOffPolicyFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryListenerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;

@Configuration
public class MyConfiguration {

	// ribbon retry 策略，采用指数增长间隔时间
	@Bean
	LoadBalancedBackOffPolicyFactory backOffPolicyFactory() {
		return service -> new ExponentialBackOffPolicy();
	}


	@Bean
	LoadBalancedRetryListenerFactory retryListenerFactory() {
		return service -> new RetryListener[]{
				// 注意RetryContext是贯穿整个retry过程的
				new RetryListener() {

					// Called before the first attempt in a retry.
					public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
						//TODO Do you business...
						return true;
					}


					// Called after the final attempt (successful or not). 比如可以关闭资源
					public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
						//TODO Do you business...
					}


					// Called after every unsuccessful attempt at a retry.
					public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
						//TODO Do you business...
					}
				}
		};
	}

}