package com.kuro.taozen.entity;

import lombok.Data;

import java.util.List;

/**
 * 任务实体
 *
 * @author kuro
 * @create 2020-01-09
 **/
@Data
public class TaskEntity {

    private String id;
    private String tid;
    private String jobId;
    private String jobName;
    private List<String> hosts;
    private Long startTime;
    private Long finishTime;
    private String type;
    private String status;
}
