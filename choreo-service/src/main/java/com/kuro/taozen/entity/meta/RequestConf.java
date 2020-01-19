package com.kuro.taozen.entity.meta;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.kuro.taozen.consts.DBFieldConstants.*;

/**
 * 请求配置
 *
 * @author kuro
 * @create 2020-01-19
 **/
@Data
public class RequestConf {
    @Field(PATHS)
    private List<ArgsConf> paths;
    @Field(PARAMS)
    private List<ArgsConf> params;
    @Field(HEADERS)
    private List<ArgsConf> headers;
    @Field(BODIES)
    private List<ArgsConf> bodies;
}
