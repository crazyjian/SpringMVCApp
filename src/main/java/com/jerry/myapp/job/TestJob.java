package com.jerry.myapp.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestJob extends QuartzJobBean {
    
    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println(System.currentTimeMillis());
    }
}
