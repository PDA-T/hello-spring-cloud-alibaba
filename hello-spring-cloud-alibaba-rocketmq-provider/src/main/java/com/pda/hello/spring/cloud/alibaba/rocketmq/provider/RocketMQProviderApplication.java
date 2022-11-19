package com.pda.hello.spring.cloud.alibaba.rocketmq.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @Date 2022/11/19 19:24
 * @Description 消息生产者
 * @since version-1.0
 */
@SpringBootApplication
@EnableBinding({Source.class})// 启用消息提供者
public class RocketMQProviderApplication implements CommandLineRunner {
	// 获取配置bindings为output的binding值
	@Autowired
	private MessageChannel output;

	public static void main(String[] args) {
		SpringApplication.run(RocketMQProviderApplication.class,args);
	}

	/**
	 * @Date 2022/11/19 19:38
	 * @Description 测试消息
	 * @Param [args]
	 * @since version-1.0
	 */
	@Override
	public void run(String... args) throws Exception {
		// 发送消息
		output.send(MessageBuilder.withPayload("RocketMQ").build());
	}
}
