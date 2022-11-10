package com.pda.hello.spring.cloud.alibaba.nacos.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Date 2022/11/10 18:22
 * @Description 配置
 * @since version-1.0
 */
@Configuration
public class NacosConsumerConfiguration {

	/**
	 * @Date 2022/11/10 18:24
	 * @Description Http请求工具
	 * @return org.springframework.web.client.RestTemplate
	 * @since version-1.0
	 */
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
