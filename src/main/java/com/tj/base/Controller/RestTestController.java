package com.tj.base.Controller;

import com.tj.base.domain.JsonData;
import com.tj.base.domain.User;
import com.tj.base.utils.JsonUtils;
import com.tj.base.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/redis/")
public class RestTestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("add")
    public Object add(){
        stringRedisTemplate.opsForValue().set("name","tarataotao");
        return JsonData.buildSuccess("ok");
    }
    @GetMapping("get")
    public Object get(){
        String value=stringRedisTemplate.opsForValue().get("name");
        return JsonData.buildSuccess(value);
    }

    @GetMapping(value="save_user")
    public Object saveUser(){
        User user=new User(1,"abc","11",11,new Date());
        String userStr= JsonUtils.obj2String(user);
        boolean flag=redisClient.set("base:user:1",userStr);
        return JsonData.buildSuccess(flag);
    }

    @GetMapping("find_user")
    public Object findUser(){
        String userStr=redisClient.get("base:user:1");
        User user=JsonUtils.string2Obj(userStr,User.class);
        return JsonData.buildSuccess(user);
    }
}
