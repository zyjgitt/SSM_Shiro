package com.zyj.serviceImpl;

import com.zyj.mapper.UserMapper;
import com.zyj.pojo.User;
import com.zyj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    public User selUserByUsercode(String usercode) {

        return  userMapper.selUserByUsercode(usercode);
    }
}
