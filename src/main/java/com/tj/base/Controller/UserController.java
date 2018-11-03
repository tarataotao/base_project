package com.tj.base.Controller;

import com.tj.base.domain.JsonData;
import com.tj.base.domain.User;
import com.tj.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user/")
public class UserController {

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
}
