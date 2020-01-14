package com.kuro.taozen.router;

import com.kuro.taozen.handler.IdentifierHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 路由器
 *
 * @author kuro
 * @create 2020-01-15
 **/
@Configuration
public class AllRouter {
    /**
     * 编号路由
     * @param handler 编号处理器
     * @return
     */
    @Bean
    RouterFunction<ServerResponse> identifierRoute(IdentifierHandler handler) {
        return nest(
                path(""),
                // 根据类型获取一个编号
                route(GET("/{type}"), handler::getByType)
        );
    }
}
