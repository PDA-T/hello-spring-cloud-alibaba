package com.pda.hello.spring.cloud.alibaba.nacos.consumer.feign.controller;

import com.pda.hello.spring.cloud.alibaba.nacos.consumer.feign.service.NacosProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/11/10 18:54
 * @Description 消费者Controller
 * @since version-1.0
 */
@RestController
public class NacosProviderController {
	// 消费者Service
	@Autowired
	private NacosProviderService nacosProviderService;

	/**
	 * @Date 2022/11/10 18:56
	 * @Description 发送消息
	 * @return java.lang.String
	 * @since version-1.0
	 */
	@GetMapping(value = "/echo")
	public String echo(){
		return nacosProviderService.echo("Hello Feign");
	}
}
