package com.zyj.controller;

import com.zyj.pojo.User;
import com.zyj.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/reg")
    public ModelAndView reg(User user) throws Exception{
        ModelAndView mav = new ModelAndView();
        System.out.println("oldUser:::" + user);
        /**
         * 使用shiro密码加密，对密码的明文进行加密
         * 新密码 = 加密（旧密码+盐） 加密方式：MD5
         */
        /**
         * 第一步：获得盐
         *  一般使用随机数生成：6位字母
         *
         */
         StringBuffer sb = new StringBuffer();
         //math.random()会随机出0~1之间的数math.random()*26会随机出0~26之间的数
        // int i= (int)(math.random()*26+97)会随机出97~122之间的数
        for(int i=0;i<6;i++){
            char c=(char)(Math.random()*26+97);
            sb.append(c);
        }
        String salt = sb.toString();
        /**
         * 第二步：将密码的明文与盐，进行加密
         *
         * SimpleHash(1,2,3,4) 构造方法参数的解读：
         *  第一个：加密方式
         *  第二个：密码明文
         *  第三个：盐
         *  第四个：加密次数
         *
         */
        SimpleHash sh = new SimpleHash("MD5",user.getPassword(),salt,3);
        /**
         * 第三步：获得密文
         */
        String password  = sh.toString();
        user.setPassword(password);
        user.setSalt(salt);
        System.out.println("newUser:::"+user);
        userService.saveUser(user);
        mav.getModel().put("user",user);
        mav.setViewName("/WEB-INF/jsp/success.jsp");

        return mav;
    }
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response)throws Exception{
        System.out.println("--login--");

        //--登录失败之后才执行的
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
