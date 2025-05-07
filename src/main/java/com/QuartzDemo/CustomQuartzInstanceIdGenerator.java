package com.QuartzDemo;

import org.quartz.SchedulerException;
import org.quartz.spi.InstanceIdGenerator;

import java.util.UUID;

public class CustomQuartzInstanceIdGenerator implements InstanceIdGenerator {
    @Override
    public String generateInstanceId() throws SchedulerException {
        return UUID.randomUUID().toString();
    }
}
