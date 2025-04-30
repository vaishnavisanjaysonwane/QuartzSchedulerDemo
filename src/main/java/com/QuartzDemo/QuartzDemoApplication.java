package com.QuartzDemo;

import job.SampleJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"com","job"})
public class QuartzDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartzDemoApplication.class, args);
	}
}

//@Slf4j
//@Configuration
//class QuartzConfig {
//
//	@Bean
//	public JobDetail sampleJobDetail() {
//		log.info("Creating job detail");
//		return JobBuilder.newJob(SampleJob.class) // create new job and link to expected job class
//				.withIdentity("sampleJob")  // give a name to job
//				.storeDurably()                   //  Keep the JobDetail in the scheduler even if no triggers are currently attached.
//				.build();
//	}
//
//	@Bean
//	public Trigger sampleJobTrigger() {
//		log.info("Creating job trigger");
//		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
//				.cronSchedule("0/5 * * * * ?"); //  start at 0 and run the job every 5 seconds.
//
//		return TriggerBuilder.newTrigger() // create new trigger
//				.forJob(sampleJobDetail())            // Link it to the JobDetail bean named “sampleJobDetail”
//				.withIdentity("sampleTrigger") // Give this trigger its own name/id
//				.withSchedule(cronScheduleBuilder)   // Tell it to use the cron schedule we just defined
//				.build();
//	}
//}
