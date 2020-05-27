package top.qingxing.baigeventweb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.dom.core.Element;
import top.qingxing.baigeventweb.annot.LoginOrRegLog;
import top.qingxing.baigeventweb.domain.entity.UserEntity;
import top.qingxing.baigeventweb.service.UserService;
import top.qingxing.baigeventweb.utils.JsonResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.controller
 * @ClassName: LoginOrRegController
 * @Author: Sober
 * @Description: 登录或注册
 * @Date: 2020/5/26 20:38
 * @Version: 0.0.1
 */

@RestController
@RequestMapping("${api.v1}")
public class LoginOrRegController {

    @Resource
    UserService userService;


    @LoginOrRegLog(value = "登录")
    @PostMapping("/login")
    public JsonResult login(String username, String pwd, HttpSession session){
        /**
         * @Method login
         * @Author Sober
         * @Version  1.0
         * @Description 登录接口
         * @param username
         * @param pwd
         * @param session
         * @Return top.qingxing.baigeventweb.utils.JsonResult
         * @Exception
         * @Date 2020/5/27 18:53
         */
        if (username != null && pwd != null){
            UserEntity userEntity = userService.login(username, pwd);
            if (userEntity != null){
                session.setAttribute("loginUser",userEntity);
                return new JsonResult(200,"登录成功");
            }
        }
        return new JsonResult(400,"登录失败,请检查账号密码");
    }

    @PostMapping("/logout")
    public JsonResult loginout(HttpSession session) {
        /**
         * @Method loginout
         * @Author Sober
         * @Version  1.0
         * @Description 登出接口
         * @param session
         * @Return top.qingxing.baigeventweb.utils.JsonResult
         * @Exception
         * @Date 2020/5/27 18:53
         */
        session.invalidate();
        return new JsonResult(200,"登出成功");
    }

    @LoginOrRegLog(value = "注册")
    @PostMapping("/reg")
    public JsonResult reg(UserEntity userEntity) throws NoSuchAlgorithmException {
        /**
         * @Method reg
         * @Author Sober
         * @Version  1.0
         * @Description 注册接口
         * @param userEntity
         * @Return top.qingxing.baigeventweb.utils.JsonResult
         * @Exception
         * @Date 2020/5/27 18:53
         */
        if (userService.reg(userEntity)){
            return new JsonResult(200,"注册成功");
        }
        return new JsonResult(400,"手机号或邮箱重复");
    }
}
