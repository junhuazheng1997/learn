package com.winning.learn.demo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <p>
 * </P>
 * Copyright (C) 2020 Kingstar Winning Inc. All rights reserved.
 *
 * @author Zheng.JH Create on 2020/11/25 18:48
 * @version 1.0
 **/
@Component
public class TestPostConstruct {

    private String name;

    public String getName() {
        return name;
    }

    @PostConstruct
    private void initName() {
        this.name = "王尼玛";
    }

}
