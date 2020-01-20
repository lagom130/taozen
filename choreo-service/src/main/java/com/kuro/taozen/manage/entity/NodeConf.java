package com.kuro.taozen.manage.entity;

import com.kuro.taozen.entity.meta.RequestConf;
import com.kuro.taozen.entity.meta.ResponseConf;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.kuro.taozen.consts.DBFieldConstants.*;

/**
 * 节点配置
 *
 * @author kuro
 * @create 2020-01-20
 **/
@Data
public class NodeConf {
    /**
     * 节点键
     */
    @Field(KEY)
    private String key;
    /**
     * 节点名称
     */
    @Field(NAME)
    private String name;
    /**
     * 节点说明
     */
    @Field(DESC)
    private String desc;
    /**
     * 请求方式
     */
    @Field(METHOD)
    private String method;
    /**
     * 路径
     */
    @Field(URL)
    private String url;
    /**
     * 请求配置
     */
    @Field(REQUEST_CONF)
    private RequestConf requestConf;
    /**
     * 响应配置
     */
    @Field(RESPONSE_CONF)
    private ResponseConf responseConf;
    /**
     * 父节点列表
     */
    @Field(PARENT_NODES)
    private List<String> parentNodes;
    /**
     * 子节点列表
     */
    @Field(CHILD_NODES)
    private List<String> childNodes;
}
