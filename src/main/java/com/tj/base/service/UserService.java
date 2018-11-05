package com.tj.base.service;

import com.tj.base.domain.User;

public interface UserService {

    public int add(User user);

    Object getAll();

    Object findById(long id);

    void deldById(long id);

    void update(User user);


    public int addAccount();
}
