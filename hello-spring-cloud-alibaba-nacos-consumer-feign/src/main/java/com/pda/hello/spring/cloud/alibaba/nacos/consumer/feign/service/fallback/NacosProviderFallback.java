package com.pda.hello.spring.cloud.alibaba.nacos.consumer.feign.service.fallback;

import com.pda.hello.spring.cloud.alibaba.nacos.consumer.feign.service.NacosProviderService;
import org.springframework.stereotype.Component;

/**
 * @Date 2022/11/10 19:21
 * @Description 熔断器
 * @since version-1.0
 */
@Component
public class NacosProviderFallback implements NacosProviderService {
	/**
	 * @Date 2022/11/10 19:22
	 * @Description echo熔断
	 * @Param [message]
	 * @return java.lang.String
	 * @since version-1.0
	 */
	@Override
	public String echo(String message) {
		return "error";
	}
}
