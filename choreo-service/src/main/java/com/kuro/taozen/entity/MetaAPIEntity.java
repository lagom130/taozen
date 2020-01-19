package com.kuro.taozen.entity;

import com.kuro.taozen.entity.meta.RequestConf;
import com.kuro.taozen.entity.meta.ResponseConf;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.kuro.taozen.consts.DBCollectionConstants.META_API;
import static com.kuro.taozen.consts.DBFieldConstants.*;

/**
 * 元接口实体
 *
 * @author kuro
 * @create 2020-01-19
 **/
@Data
@Document(collation = META_API)
public class MetaAPIEntity {
    /**
     * ID
     */
    @Id
    private String id;
    /**
     * 唯一编号
     */
    @Field(UID)
    private String uid;
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
     * 标签
     */
    @Field(LABELS)
    private List<String> labels;
    /**
     * 接口路径
     */
    @Field(URL)
    private String url;
    /**
     * 请求方式
     */
    @Field(METHOD)
    private String method;
    /**
     * 更新时间
     */
    @Field(REQUEST_CONF)
    private RequestConf requestConf;
    /**
     * 更新时间
     */
    @Field(RESPONSE_CONF)
    private ResponseConf responseConf;
    /**
     * 更新时间
     */
    @Field(UPDATE_TIME)
    private Long updateTime;
    /**
     * 更新人
     */
    @Field(UPDATE_USER)
    private String updateUser;
    /**
     * 创建时间
     */
    @Field(CREATED_TIME)
    private Long createdTime;
    /**
     * 创建人
     */
    @Field(CREATED_USER)
    private String createdUser;
}
