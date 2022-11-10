package com.pda.hello.spring.cloud.alibaba.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Date 2022/11/10 18:25
 * @Description 控制器
 * @since version-1.0
 */
@RestController
public class NacosConsumerController {

	// 负载均衡客户端
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	// http模板
	@Autowired
	private RestTemplate restTemplate;

	// 服务名称
	@Value("${spring.application.name}")
	private String appName;

	/**
	 * @Date 2022/11/10 18:31
	 * @Description 调用服务提供者echo
	 * @return java.lang.String
	 * @since version-1.0
	 */
	@GetMapping(value = "/echo/app/name")
	public String echo(){
		// 获取nacos-provider服务
		ServiceInstance instance = loadBalancerClient.choose("nacos-provider");
		// 获取nacos-provider服务ip和端口组成url
		String url = String.format("http://%s:%s/echo/%s",instance.getHost(),instance.getPort(),appName);
		// 发送请求
		return restTemplate.getForObject(url,String.class);
	}
}
