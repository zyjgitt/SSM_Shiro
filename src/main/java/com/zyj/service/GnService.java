package com.zyj.service;

import com.zyj.pojo.Gn;

import java.util.List;

public interface GnService {
    public List<Gn> selAllGn();
    public List<String> selAllPersByUserId(int userid);
}
