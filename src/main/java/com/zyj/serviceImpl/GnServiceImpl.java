package com.zyj.serviceImpl;

import com.zyj.mapper.GnMapper;
import com.zyj.pojo.Gn;
import com.zyj.service.GnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("gnService")
public class GnServiceImpl implements GnService {
    @Resource
    private GnMapper gnMapper;

    public List<Gn> selAllGn() {
        return gnMapper.selAllGn();
    }

    public List<String> selAllPersByUserId(int userid) {

        return gnMapper.selAllPersByUserId(userid);
    }
}
