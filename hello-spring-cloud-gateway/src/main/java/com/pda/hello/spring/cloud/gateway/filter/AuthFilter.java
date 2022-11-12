package com.pda.hello.spring.cloud.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @Date 2022/11/12 21:44
 * @Description 过滤器
 * @since version-1.0
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {
	/**
	 * @Date 2022/11/12 21:45
	 * @Description 全局过滤器
	 * @Param [exchange, chain]
	 * @return reactor.core.publisher.Mono<java.lang.Void>
	 * @since version-1.0
	 */
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// 得到第一个名字叫token的参数
		String token = exchange.getRequest().getQueryParams().getFirst("token");
		if (token == null || token.isEmpty()){
			ServerHttpResponse response = exchange.getResponse();
			// 封装错误信息
			Map<String,Object> responseData = Maps.newHashMap();
			// 设置401
			responseData.put("code",HttpStatus.UNAUTHORIZED);
			responseData.put("message","非法请求");
			responseData.put("cause","Token is empty");
			try {
				// 消息转换为JSON
				ObjectMapper objectMapper = new ObjectMapper();
				byte[] data = objectMapper.writeValueAsBytes(responseData);

				// 输出错误信息到页面
				DataBuffer buffer = response.bufferFactory().wrap(data);
				response.setStatusCode(HttpStatus.UNAUTHORIZED);
				response.getHeaders().add("Content-Type","application/json:charset=UTF-8");
				return response.writeWith(Mono.just(buffer));
			}catch (JsonProcessingException e){
				e.printStackTrace();
			}
		}
		// 传入下一个过滤器
		return chain.filter(exchange);
	}

	/**
	 * @Date 2022/11/12 21:45
	 * @Description 执行顺序,数字越小优先级越高
	 * @return int
	 * @since version-1.0
	 */
	@Override
	public int getOrder() {
		return 0;
	}
}
