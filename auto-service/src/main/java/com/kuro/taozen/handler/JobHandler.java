package com.kuro.taozen.handler;

import com.kuro.taozen.consts.DBFieldConstants;
import com.kuro.taozen.dto.JobDto;
import com.kuro.taozen.entity.JobEntity;
import com.kuro.taozen.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
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
    @Resource
    private ReactiveMongoTemplate mongoTemplate;

    /**
     * 新增一个作业
     * @param inputDto
     * @return
     */
    public Mono<JobEntity> addOne(JobDto inputDto) {
        Query query = new Query();
        query.addCriteria(Criteria.where(DBFieldConstants.NAME).is(inputDto.getName()));
        mongoTemplate.count(query, JobEntity.class);
        String operatorUser = "";
        JobEntity jobEntity = new JobEntity();
        BeanUtils.copyProperties(inputDto, jobEntity);
        jobEntity.setUpdateTime(System.currentTimeMillis());
        jobEntity.setUpdateUser(operatorUser);
        jobEntity.setUpdateTime(jobEntity.getCreatedTime());
        jobEntity.setUpdateUser(jobEntity.getUpdateUser());
        return jobRepository.insert(jobEntity);
    }

    /**
     * 编辑一个作业
     * @param inputDto
     * @return
     */
    public Mono<JobEntity> updateOne(String id, JobDto inputDto) {
        String operatorUser = "";
        JobEntity jobEntity = jobRepository.findById(id).blockOptional().orElseThrow();
        BeanUtils.copyProperties(inputDto, jobEntity);
        jobEntity.setUpdateTime(System.currentTimeMillis());
        jobEntity.setUpdateUser(operatorUser);
        jobEntity.setUpdateTime(jobEntity.getCreatedTime());
        jobEntity.setUpdateUser(jobEntity.getUpdateUser());
        return jobRepository.save(jobEntity);
    }
}
