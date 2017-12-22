package com.zyj.realm;

import com.zyj.pojo.User;
import com.zyj.service.GnService;
import com.zyj.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

public class CustomRealm extends AuthorizingRealm{
    @Resource
    private UserService userService;
    @Resource
    private GnService gnService;
    //我试验了一下不需要也行
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    /**
     * 授权
     * 查询出当前用户，对应的权限
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
       //--获得当前的身份
    /* User user = (User) principal.getPrimaryPrincipal();
        List<String> pers = userService.selAllPersByUserId(user.getId());

     SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
       info.addStringPermissions(pers);

       return info;*/
        //获得当前身份
       User user  = (User) principal.getPrimaryPrincipal();
       List<String> pers =  gnService.selAllPersByUserId(user.getId());
       SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
       info.addStringPermissions(pers);

       return info;
    }
    /**
     * 认证
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("--认证--");
        //--获得用户身份（用户名）
        String usercode = token.getPrincipal().toString();
        System.out.println("usercode---"+usercode);
        //--根据用户名从数据库查询，有没有此数据
        User  user = userService.selUserByUsercode(usercode);
        if(user==null){
            return null;
        }
        System.out.println("user::"+user);
        /**
         * 返回认证的信息
         * SimpleAuthenticationInfo(1,2,3,4) 构造方法参数解读：
         *  第一个参数：身份（用户名或用户对象）
         *  第二个参数：密文（密码）
         *  第三个参数：盐 （需要的类型：ByteSource）
         *  第四个参数：当前realm的名称
         */
      System.out.println(this.getName());
       /*   com.zyj.realm.CustomRealm_0*/
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
      /*  System.out.println(info);
        User{id=9, username='zs', password='cdd33354a93eede7a69afbf5fb538053', salt='pknlpz'}*/
        return info;
    }
}
