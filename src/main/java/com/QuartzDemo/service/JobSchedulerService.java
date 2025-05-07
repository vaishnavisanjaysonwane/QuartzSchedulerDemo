package com.QuartzDemo.service;

import org.quartz.JobDetail;
import org.springframework.stereotype.Service;


public interface JobSchedulerService {

    public static final String JOB_CLASS = "com.QuartzDemo.job.SampleJob";
    public static final String JOB_GROUP = "schedulercronjob";

    String scheduleJob(String name, String cronExpression);
}
