package com.QuartzDemo.service;

import com.QuartzDemo.JobScheduleCreator;
import com.QuartzDemo.service.JobSchedulerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class JobSchedulerServiceImpl implements JobSchedulerService {

    private static final Logger log = LogManager.getLogger(JobSchedulerServiceImpl.class);

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private JobScheduleCreator jobScheduleCreator;

    @Override
    public String scheduleJob(String name,String cronExpression) {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();

            JobDetail jobDetail = JobBuilder.newJob((Class<? extends QuartzJobBean>) Class.forName(JOB_CLASS))
                    .withIdentity(name, JOB_GROUP).build();

            if (!scheduler.checkExists(jobDetail.getKey())) {

                jobDetail = jobScheduleCreator.createJob(
                        (Class<? extends QuartzJobBean>) Class.forName(JOB_CLASS),
                        false, context, name, JOB_GROUP);

                Trigger trigger = jobScheduleCreator.createCronTrigger(name, new Date(), cronExpression, SimpleTrigger.REPEAT_INDEFINITELY);
                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                log.info("Job already exists");
                return "Job already exists";
            }
        } catch (ClassNotFoundException | SchedulerException ex) {
            throw new RuntimeException(ex);
        }
        return "Success: Job schedule";
    }
}
