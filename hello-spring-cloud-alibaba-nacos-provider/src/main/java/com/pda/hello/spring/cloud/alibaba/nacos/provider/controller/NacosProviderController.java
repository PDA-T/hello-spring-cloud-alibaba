package com.pda.hello.spring.cloud.alibaba.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
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

	// 端口
	@Value(value = "${server.port}")
	private String port;

	// 配置中心上下文
	@Autowired
	private ConfigurableApplicationContext applicationContext;

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
		return "hello" + message + " port:" + port;
	}

	/**
	 * @Date 2022/11/12 22:29
	 * @Description 获取配置中心新增的动态配置
	 * @return java.lang.String
	 * @since version-1.0
	 */
	@GetMapping(value = "/hi")
	public String hi(){
		return applicationContext.getEnvironment().getProperty("user.name");
	}
}
