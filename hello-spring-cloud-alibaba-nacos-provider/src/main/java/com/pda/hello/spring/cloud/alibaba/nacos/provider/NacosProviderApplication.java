package com.pda.hello.spring.cloud.alibaba.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author PDA
 * @Date 2022/11/4 20:57
 * @Description Nacos注册中心
 * @since version-1.0
 */
@SpringBootApplication
@EnableDiscoveryClient// 注册进Nacos
public class NacosProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(NacosProviderApplication.class,args);
	}
}
