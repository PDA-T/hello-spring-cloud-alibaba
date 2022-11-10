package com.pda.hello.spring.cloud.alibaba.nacos.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Date 2022/11/10 18:19
 * @Description 消费者
 * @since version-1.0
 */
@SpringBootApplication
@EnableDiscoveryClient// 注册进nacos
public class NacosConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(NacosConsumerApplication.class,args);
	}
}
