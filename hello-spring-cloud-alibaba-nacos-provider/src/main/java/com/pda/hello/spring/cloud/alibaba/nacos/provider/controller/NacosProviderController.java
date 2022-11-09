package com.pda.hello.spring.cloud.alibaba.nacos.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PDA
 * @Date 2022/11/4 21:31
 * @Description Nacos控制器
 * @since version-1.0
 */
@RestController
public class NacosProviderController {
	/**
	 * @author PDA
	 * @Date 2022/11/4 21:33
	 * @Description 发送消息
	 * @Param [message]
	 * @return java.lang.String
	 * @since version-1.0
	 */
	@GetMapping(value = "/echo/{message}")
	public String echo(@PathVariable(value = "message") String message){
		return "hello" + message;
	}
}
