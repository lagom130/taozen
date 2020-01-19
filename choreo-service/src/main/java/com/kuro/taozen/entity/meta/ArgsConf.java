package com.kuro.taozen.entity.meta;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.kuro.taozen.consts.DBFieldConstants.*;

/**
 * 参数配置
 *
 * @author kuro
 * @create 2020-01-19
 **/
@Data
public class ArgsConf {
    /**
     * 名称
     */
    @Field(NAME)
    private String name;
    /**
     * 说明
     */
    @Field(DESC)
    private String desc;
    /**
     * 值
     */
    @Field(DEFAULT_VALUE)
    private String defaultValue;
    /**
     * 说明
     */
    @Field(FIXED)
    private boolean fixed;
    /**
     * 说明
     */
    @Field(REQUIRED)
    private boolean required;
}
