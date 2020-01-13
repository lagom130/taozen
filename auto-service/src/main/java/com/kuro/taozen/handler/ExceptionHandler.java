package com.kuro.taozen.handler;

import com.kuro.taozen.exception.CheckException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * TODO:异常处理器
 *
 * @author kuro
 * @create 2020-01-10
 **/
@Slf4j
@Component
@Order(-10)
public class ExceptionHandler implements WebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        ServerHttpResponse response = serverWebExchange.getResponse();
        // 设置响应头400
        response.setStatusCode(HttpStatus.BAD_REQUEST);
        // 设置返回类型
        response.getHeaders().setContentType(MediaType.TEXT_PLAIN);
        // 异常信息
        String errorMsg = toStr(throwable);
        log.error(errorMsg);
        return response.writeWith(Mono.just(response.bufferFactory().wrap(errorMsg.getBytes())));
    }

    private String toStr(Throwable ex) {
        if(ex instanceof CheckException) {
            CheckException e = (CheckException)ex;
            return e.getFieldName() + ": invalid value "+ e.getFieldValue();
        } else {
            ex.printStackTrace();
            return ex.toString();
        }
    }
}
