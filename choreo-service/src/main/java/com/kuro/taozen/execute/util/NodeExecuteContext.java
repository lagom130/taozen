package com.kuro.taozen.execute.util;

import com.kuro.taozen.entity.meta.ArgsConf;
import com.kuro.taozen.manage.entity.NodeConf;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 节点执行工具
 *
 * @author: lujc
 * @create: 2020年 01月 21日
 **/
public class NodeExecuteContext {
    @Resource
    private WebClient.Builder webClientBuilder;

    public void execute(NodeConf nodeConf, Map<String, Map<String, String>> args) {
        String url = "";
        WebClient.RequestBodySpec requestBodySpec = webClientBuilder.build()
                .method(HttpMethod.PUT)
                .uri(nodeConf.getUrl(),
                    nodeConf.getRequestConf().getPaths().stream()
                            .map(path -> new KeyValue(path.getName(),
                                    path.isFixed() ?
                                            path.getDefaultValue() : args.get("path").get(path.getDefaultValue())))
                            .collect(Collectors.toMap(KeyValue::getKey, KeyValue::getValue)));
        this.addHeaders(requestBodySpec, nodeConf.getRequestConf().getHeaders(), args.get("header"));
    }

    private void addHeaders(WebClient.RequestBodySpec requestBodySpec, List<ArgsConf> headers,
                           Map<String, String> args) {
        headers.stream()
                .map(header -> new KeyValue(header.getName(),
                        header.isFixed() ? header.getDefaultValue() : args.get(header.getDefaultValue())))
                .filter(header -> StringUtils.isNotBlank(header.getValue()))
                .forEach(header -> requestBodySpec.header(header.getKey(), header.getValue()));
    }
}
