package com.zyj.mapper;

import com.zyj.pojo.Gn;

import java.util.List;

public interface GnMapper {
    //查询出所有的功能
    public List<Gn> selAllGn();
    //根据用户id查询用户的权限功能
    public List<String> selAllPersByUserId(int userid);


}
