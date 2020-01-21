package com.kuro.taozen.execute.util;

import lombok.Data;

/**
 * @author: lujc
 * @create: 2020年 01月 21日
 **/
@Data
public class KeyValue {
    private String key;
    private String value;

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
