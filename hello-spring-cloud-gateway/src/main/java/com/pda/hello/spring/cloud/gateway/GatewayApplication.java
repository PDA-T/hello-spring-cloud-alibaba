package com.pda.hello.spring.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Date 2022/11/12 21:15
 * @Description API网关
 * @since version-1.0
 */
@SpringBootApplication
@EnableDiscoveryClient// 注册进nacos
@EnableFeignClients// 启用Feign客户端
public class GatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class,args);
	}
}
