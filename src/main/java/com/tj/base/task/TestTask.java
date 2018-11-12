package com.tj.base.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 功能描述：定时任务业务类
 */
@Component
public class TestTask {

//    @Scheduled(fixedRate = 2000)
//    @Scheduled(fixedDelay = 2000)
//    @Scheduled(cron = "*/1 * * * * *") //每秒启动一次
   // @Scheduled(cron = "*/2 * * * * *") //每秒启动一次
@Scheduled(fixedDelayString = "2000")
    public void sum(){
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前时间："+new Date());
    }
}
