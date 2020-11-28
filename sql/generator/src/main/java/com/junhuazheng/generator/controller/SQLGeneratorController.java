package com.junhuazheng.generator.controller;

import com.junhuazheng.generator.pojo.SQLPo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@RequestMapping("/sql")
public class SQLGeneratorController {

    @PostMapping
    public String get(@RequestBody SQLPo sqlPo) {
        StringBuilder s = new StringBuilder("SELECT ")
                .append(sqlPo.getSelectList().stream().collect(Collectors.joining(",")))
                .append(" FROM ")
                .append(sqlPo.getFromList().stream().collect(Collectors.joining(",")));
        if (null == sqlPo.getCondition())
            return s.append(";").toString();
        return s.append(" WHERE ").append(sqlPo.getCondition().stream().collect(Collectors.joining(",")))
                .append(";").toString();
    }

    public static void main(String[] args) throws HappyException {
        throw new HappyException();
    }

    static class HappyException extends Throwable {

    }

}
