package com.zyj.service;

import com.zyj.pojo.User;

public interface UserService {
    public void saveUser(User user);
    public User selUserByUsercode(String usercode);
}
