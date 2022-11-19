package com.pda.hello.spring.cloud.alibaba.rocketmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @Date 2022/11/19 20:03
 * @Description 消息消费者
 * @since version-1.0
 */
@SpringBootApplication
@EnableBinding({Sink.class})// 启用消息订阅者
public class RocketMQConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(RocketMQConsumerApplication.class,args);
	}

	/**
	 * @Date 2022/11/19 20:09
	 * @Description 消息消费者
	 * @Param [receiveMsg]
	 * @since version-1.0
	 */
	@StreamListener("input")// 获取配置内bindings为input的值
	public void receiveInput(String receiveMsg){
		System.out.println("input:" + receiveMsg);
	}
}
