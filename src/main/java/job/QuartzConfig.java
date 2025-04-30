package job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Slf4j
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail sampleJobDetail() {
        log.info("Creating job detail");
        return JobBuilder.newJob(SampleJob.class) // create new job and link to expected job class
                .withIdentity("sampleJob")  // give a name to job
                .storeDurably()                   //  Keep the JobDetail in the scheduler even if no triggers are currently attached.
                .build();
    }

    @Bean
    public Trigger sampleJobTrigger() {
        log.info("Creating job trigger");
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
                .cronSchedule("0/5 * * * * ?"); //  start at 0 and run the job every 5 seconds.

        return TriggerBuilder.newTrigger() // create new trigger
                .forJob(sampleJobDetail())            // Link it to the JobDetail bean named “sampleJobDetail”
                .withIdentity("sampleTrigger") // Give this trigger its own name/id
                .withSchedule(cronScheduleBuilder)   // Tell it to use the cron schedule we just defined
                .build();
    }

//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(Trigger sampleJobTrigger, JobDetail sampleJobDetail) {
//        SchedulerFactoryBean factory = new SchedulerFactoryBean();
//        factory.setJobDetails(sampleJobDetail);
//        factory.setTriggers(sampleJobTrigger);
//        return factory;
//    }
//
//    @Bean
//    @DependsOn({"sampleJobDetail", "sampleJobTrigger"})
//    public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean, Trigger sampleJobTrigger, JobDetail sampleJobDetail) throws SchedulerException {
//        Scheduler scheduler = schedulerFactoryBean.getScheduler();
//        if (!scheduler.checkExists(sampleJobDetail.getKey())) {
//            scheduler.scheduleJob(sampleJobDetail, sampleJobTrigger);
//        }
//        scheduler.start();  // Start the scheduler
//        return scheduler;
//    }
}
