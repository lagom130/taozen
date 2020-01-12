package com.kuro.taozen.handler;

import com.kuro.taozen.dto.JobDto;
import com.kuro.taozen.entity.JobEntity;
import com.kuro.taozen.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * 作业处理器
 *
 * @author kuro
 * @create 2020-01-09
 **/
@Slf4j
@Component
public class JobHandler {
    @Resource
    private JobRepository jobRepository;

    /**
     * 新增一个作业
     * @param request
     * @return
     */
    public Mono<ServerResponse> addOne(ServerRequest request) {
        String operatorUser = "";
        Mono<JobEntity> job = request.bodyToMono(JobDto.class)
                // TODO:名称重复校验
                //Dto转换为实体
                .map(inputDto -> {
                    JobEntity jobEntity = new JobEntity();
                    BeanUtils.copyProperties(inputDto, jobEntity);
                    jobEntity.setUpdateTime(System.currentTimeMillis());
                    jobEntity.setUpdateUser(operatorUser);
                    jobEntity.setUpdateTime(jobEntity.getCreatedTime());
                    jobEntity.setUpdateUser(jobEntity.getUpdateUser());
                    return jobEntity;
                });
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(jobRepository.insert(job), JobEntity.class);
    }

    /**
     * TODO:编辑一个作业
     * @param request
     * @return
     */
    public Mono<ServerResponse> updateOne(ServerRequest request) {
        String operatorUser = "";
        return ServerResponse.ok().build();
    }

    /**
     * TODO:查询一个作业
     * @param request
     * @return
     */
    public Mono<ServerResponse> findOne(ServerRequest request) {
        String operatorUser = "";
        return ServerResponse.ok().build();
    }

    /**
     * 删除一个作业
     * @param request
     * @return
     */
    public Mono<ServerResponse> deleteOne(ServerRequest request) {
        String operatorUser = "";
        return jobRepository.findById(request.pathVariable("id"))
                .flatMap(jobEntity -> jobRepository.delete(jobEntity))
                .then(ServerResponse.ok().build())
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    /**
     * TODO:查询作业列表
     * @param request
     * @return
     */
    public Mono<ServerResponse> list(ServerRequest request) {
        String operatorUser = "";
        return ServerResponse.ok().build();
    }
}
