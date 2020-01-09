package com.kuro.taozen.repository;

import com.kuro.taozen.entity.JobEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * 作业数据访问层
 *
 * @author kuro
 * @create 2020-01-09
 **/
@Repository
public interface JobRepository extends ReactiveMongoRepository<JobEntity, String> {
	
}
