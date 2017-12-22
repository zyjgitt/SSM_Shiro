package com.zyj.mapper;

import com.zyj.pojo.User;

public interface UserMapper {
    public void saveUser(User user);
    public User selUserByUsercode(String usercode);
}
