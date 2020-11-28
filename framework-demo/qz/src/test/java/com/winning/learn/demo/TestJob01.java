package com.winning.learn.demo;

import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestJob01 {

    @Test
    public void test01() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.getContext().put("skey", "svalue");

        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3)
                        .repeatForever()).build();

        JobDetail job = JobBuilder.newJob(DemoJob01.class).build();

        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }

}
