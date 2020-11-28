package com.winning.learn.demo;

import cn.hutool.core.util.StrUtil;

import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String, String> map = SqlUtil.buildSelectSql("select.sql", "2020-10-11", "2020-10-12");
        map.forEach((k, v) -> {
            System.out.println(v);
        });
    }
}
