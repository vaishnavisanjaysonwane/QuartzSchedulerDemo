package job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

@Slf4j
@Component
public class SampleJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("Sample Job Executed at {}", LocalDateTime.now());

//        // Get Scheduler
//        Scheduler scheduler = context.getScheduler();
//        try {
//            System.out.println("Scheduler Name: " + scheduler.getSchedulerName());
//        } catch (SchedulerException e) {
//            throw new RuntimeException(e);
//        }

    }
}
