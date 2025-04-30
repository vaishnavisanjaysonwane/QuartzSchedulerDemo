package job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class SampleJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("Sample Job Executed at {}", LocalDateTime.now());
//
//        System.out.println("=== SampleJob Execution Started ===");
//
//        // Get Scheduler
//        Scheduler scheduler = context.getScheduler();
//        try {
//            System.out.println("Scheduler Name: " + scheduler.getSchedulerName());
//        } catch (SchedulerException e) {
//            throw new RuntimeException(e);
//        }
//
//        // Get Job Detail
//        JobDetail jobDetail = context.getJobDetail();
//        System.out.println("Job Name: " + jobDetail.getKey().getName());
//        System.out.println("Job Group: " + jobDetail.getKey().getGroup());
//        System.out.println("Job Description: " + jobDetail.getDescription());
//
//        // Get Trigger that fired the job
//        Trigger trigger = context.getTrigger();
//        System.out.println("Trigger Name: " + trigger.getKey().getName());
//        System.out.println("Trigger Group: " + trigger.getKey().getGroup());
//        System.out.println("Trigger Description: " + trigger.getDescription());
//
//        // Get Fire Time (current execution time)
//        System.out.println("Job Fired At: " + context.getFireTime());
//
//        // Get Next Fire Time
//        System.out.println("Next Scheduled Fire Time: " + context.getNextFireTime());
//
//        // Get Previous Fire Time
//        System.out.println("Previous Fire Time: " + context.getPreviousFireTime());
//
//        // Get Scheduled Fire Time
//        System.out.println("Scheduled Fire Time: " + context.getScheduledFireTime());
//
//        // Check if the job was recovering (e.g., after a failover)
//        System.out.println("Is Recovering Job: " + context.isRecovering());
//
//        // Access JobDataMap (parameters passed to the job)
//        JobDataMap dataMap = context.getMergedJobDataMap();
//        if (dataMap != null && !dataMap.isEmpty()) {
//            System.out.println("Job Data Map:");
//            dataMap.forEach((key, value) -> System.out.println(key + ": " + value));
//        } else {
//            System.out.println("No Job Data Provided.");
//        }
//
//        // Runtime data
//        System.out.println("Refire Count (number of times re-executed): " + context.getRefireCount());
//
//        System.out.println("=== SampleJob Execution Finished ===");
    }
}
