package com.QuartzDemo.config;
//
//import job.SampleJob;
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//public class QuartzConfig {
//
//    @Bean
//    public JobDetail sampleJobDetail() {
//        log.info("Creating job detail");
//        return JobBuilder.newJob(SampleJob.class) // create new job and link to expected job class
//                .withIdentity("sampleJob")  // give a name to job
//                .storeDurably()                   //  Keep the JobDetail in the scheduler even if no triggers are currently attached.
//                .build();
//    }
//
//    @Bean
//    public Trigger sampleJobTrigger() {
//        log.info("Creating job trigger");
//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
//                .cronSchedule("0/5 * * * * ?"); //  start at 0 and run the job every 5 seconds.
//
//        return TriggerBuilder.newTrigger() // create new trigger
//                .forJob(sampleJobDetail())            // Link it to the JobDetail bean named “sampleJobDetail”
//                .withIdentity("sampleTrigger") // Give this trigger its own name/id
//                .withSchedule(cronScheduleBuilder)   // Tell it to use the cron schedule we just defined
//                .build();
//    }
//}


import com.QuartzDemo.SchedulerJobFactory;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class QuartzConfig {

    /**
     * Scheduler factory bean.
     *
     * @return the scheduler factory bean
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource, ApplicationContext applicationContext, QuartzProperties quartzProperties) {
        final SchedulerJobFactory jobFactory = new SchedulerJobFactory();
        jobFactory.setApplicationContext(applicationContext);

        final Properties properties = new Properties();
        properties.putAll(quartzProperties.getProperties());

        final SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setOverwriteExistingJobs(true);
        factory.setDataSource(dataSource);
        factory.setQuartzProperties(properties);
        factory.setJobFactory(jobFactory);

        return factory;
    }
}