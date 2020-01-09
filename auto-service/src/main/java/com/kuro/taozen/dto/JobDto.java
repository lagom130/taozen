package com.kuro.taozen.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.kuro.taozen.consts.DBFieldConstants.*;
import static com.kuro.taozen.consts.DBFieldConstants.ARGS;

/**
 * 作业DTO
 *
 * @author kuro
 * @create 2020-01-09
 **/
@Data
public class JobDto {
    /**
     * 名称
     */
    private String name;
    /**
     * 说明
     */
    private String desc;
    /**
     * 分类
     */
    private List<String> category;
    /**
     * 类型
     */
    private String type;
    /**
     * 内容
     */
    private String content;
    /**
     * 参数
     */
    private String args;
}
