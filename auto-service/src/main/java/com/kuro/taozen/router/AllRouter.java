package com.kuro.taozen.router;

import com.kuro.taozen.handler.JobHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 路由器
 *
 * @author kuro
 * @create 2020-01-10
 **/
@Configuration
public class AllRouter {

    // 作业路由
    @Bean
    RouterFunction<ServerResponse> jobRouter(JobHandler handler) {
        return nest(
                // 相当于类上的@RequestMapping("/jobs")
                path("/jobs"),
                // 相当于方法中的@RequestMapping
                // 获得单个作业
                route(GET("/{id}"), handler::findOne)
                        // 新增一个作业
                        .andRoute(POST("").and(accept(APPLICATION_JSON)), handler::addOne)
                        // 编辑一个作业
                        .andRoute(PUT("/{id}").and(accept(APPLICATION_JSON)), handler::updateOne)
                        // 删除一个作业
                        .andRoute(DELETE("/{id}"), handler::deleteOne)
                        // 作业列表
                        .andRoute(POST("/get").and(accept(APPLICATION_JSON)), handler::list)
        );
    }
}
