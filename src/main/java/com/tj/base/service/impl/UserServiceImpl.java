package com.tj.base.service.impl;

import com.tj.base.domain.User;
import com.tj.base.mapper.UserMapper;
import com.tj.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        userMapper.insert(user);
        int id=user.getId();
        return id;
    }

    @Override
    public Object getAll() {
        return userMapper.getAll();
    }

    @Override
    public Object findById(long id) {
        return userMapper.findById(id);
    }

    @Override
    public void deldById(long id) {
         userMapper.delete(id);
    }

    @Override
    public void update(User user) {
          userMapper.update(user);;
    }
}
