package com.pda.hello.spring.cloud.alibaba.nacos.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Date 2022/11/10 18:49
 * @Description 消费者Service
 * @since version-1.0
 */
@FeignClient(value = "nacos-provider")// 连接nacos-provider服务
public interface NacosProviderService {
	/**
	 * @Date 2022/11/10 18:52
	 * @Description 发送消息
	 * @Param [message]
	 * @return java.lang.String
	 * @since version-1.0
	 */
	@GetMapping(value = "/echo/{message}")
	public String echo(@PathVariable(value = "message") String message);
}
