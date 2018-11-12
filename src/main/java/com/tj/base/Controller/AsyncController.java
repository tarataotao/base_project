package com.tj.base.Controller;

import com.tj.base.domain.JsonData;
import com.tj.base.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api/v1/async")
public class AsyncController {

    @Autowired
    private AsyncTask task;

    @GetMapping("async_task")
   public JsonData exeTask() throws InterruptedException {

        long begin =System.currentTimeMillis();

        //异步任务
//        task.task1();
//        task.task2();
//        task.task3();

        //获取异步任务的结果
        Future<String> task4=task.task4();
        Future<String> task5=task.task5();
        Future<String> task6=task.task6();
       for(;;){
           if(task4.isDone() && task5.isDone() && task6.isDone()){
               try {
                   System.out.println(task4.get());
                   System.out.println(task5.get());
                   System.out.println(task6.get());
               } catch (ExecutionException e) {
                   e.printStackTrace();
               }
               break;
           }
       }
        long end=System.currentTimeMillis();

       long total=end-begin;
        System.out.println("执行总耗时="+(total));
       return JsonData.buildSuccess(total);
   }
}
