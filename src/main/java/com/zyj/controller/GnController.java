package com.zyj.controller;

import com.zyj.pojo.Gn;
import com.zyj.pojo.User;
import com.zyj.service.GnService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GnController {
    @Resource
    private GnService gnService;

    @RequestMapping("/selallgn")
    public ModelAndView selGn() throws Exception{
        ModelAndView mav = new ModelAndView();

        List<Gn> list = gnService.selAllGn();
        mav.getModel().put("list",list);
        mav.setViewName("/WEB-INF/jsp/main.jsp");

        return mav;
    }
    //--设置当前方法的访问权限
    @RequiresPermissions("admin:query")
    @RequestMapping("/user_query")
    public ModelAndView userQuery(){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/WEB-INF/jsp/success.jsp");
        mav.getModel().put("message","用户管理");
        return mav;
    }
    @RequiresPermissions("user:query")
    @RequestMapping("/good_query")
    public ModelAndView goodQuery(){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/WEB-INF/jsp/success.jsp");
        mav.getModel().put("message","商品管理");
        return mav;
    }
}
