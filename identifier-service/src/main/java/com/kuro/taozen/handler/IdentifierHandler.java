package com.kuro.taozen.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * 发号器处理器
 *
 * @author kuro
 * @create 2020-01-15
 **/
@Slf4j
@Component
public class IdentifierHandler {

    @Resource
    private ReactiveRedisTemplate reactiveRedisTemplate;

    /**
     * 根据类型获取编号
     * @param request 请求体
     * @return
     */
    public Mono<ServerResponse> getByType(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(reactiveRedisTemplate.opsForValue().increment(request.queryParam("type")
                        .orElse("undefined"), 1L).defaultIfEmpty(0L), Long.class);
    }
}
