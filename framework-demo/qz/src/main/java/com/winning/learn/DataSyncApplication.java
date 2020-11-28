package com.winning.learn;

import com.winning.learn.demo.DemoJob01;
import com.winning.learn.demo.DemoScheduler;
import com.winning.learn.demo.SpringUtil;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataSyncApplication {

    public static void main(String[] args) throws SchedulerException {
        SpringApplication.run(DataSyncApplication.class, args);
        DemoScheduler scheduler = SpringUtil.getBean(DemoScheduler.class);
        scheduler.exec();
    }

}
