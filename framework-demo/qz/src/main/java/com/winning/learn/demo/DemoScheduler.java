package com.winning.learn.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoScheduler {

    public void exec() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.getContext().put("key1", "value1");

        SimpleTrigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder
                .simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

        JobDetail job = JobBuilder.newJob(DemoJob01.class).build();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }

}
