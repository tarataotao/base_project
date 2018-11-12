package com.tj.base.Controller;

import com.tj.base.domain.JsonData;
import com.tj.base.domain.User;
import com.tj.base.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user/")
public class UserController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public Object add(String msg){
        User user=new User();
        user.setAge(11);
        user.setCreateTime(new Date());
        user.setName("taojie");
        user.setPhone("11111");
        int id=userService.add(user);
        return JsonData.buildSuccess(id);
    }

    @RequestMapping("findAll")
    public Object findAdd(){
        return JsonData.buildSuccess(userService.getAll());
    }

    @RequestMapping("findById")
    public Object findById(long id){
        return JsonData.buildSuccess(userService.findById(id));
    }

    @RequestMapping("deldById")
    public Object deldById(long id){
        userService.deldById(id);
        return JsonData.buildSuccess();
    }


    @GetMapping("update")
    public Object update(User user){
        userService.update(user);
        return JsonData.buildSuccess();
    }


    @GetMapping("add_account")
    public Object transac(){
        int id=userService.addAccount();
        return JsonData.buildSuccess(id);
    }
}
