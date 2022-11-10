package com.pda.hello.spring.cloud.alibaba.nacos.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Date 2022/11/10 18:46
 * @Description Feign客户端
 * @since version-1.0
 */
@SpringBootApplication
@EnableDiscoveryClient// 注册进nacos
@EnableFeignClients// 启用Feign客户端
public class NacosConsumerFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(NacosConsumerFeignApplication.class,args);
	}
}
