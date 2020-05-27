package top.qingxing.baigeventweb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.qingxing.baigeventweb.annot.LoginOrRegLog;
import top.qingxing.baigeventweb.dao.UserDao;
import top.qingxing.baigeventweb.dao.UserLoginLogDao;
import top.qingxing.baigeventweb.domain.entity.UserEntity;
import top.qingxing.baigeventweb.domain.entity.UserLoginLogEntity;
import top.qingxing.baigeventweb.service.UserLoginLogService;
import top.qingxing.baigeventweb.service.UserService;
import top.qingxing.baigeventweb.service.impl.UserServiceImpl;
import top.qingxing.baigeventweb.utils.JsonResult;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.aop
 * @ClassName: LoginLogAop
 * @Author: Sober
 * @Description:
 * @Date: 2020/5/27 3:36
 * @Version: 0.0.1
 */
@Aspect
@Component
public class LoginLogAop {

    @Resource
    UserDao userDao;

    @Resource
    UserLoginLogService userLoginLogService;

    @AfterReturning(returning="rvt", pointcut="@annotation(loginOrRegLog)")
    public Object AfterExec(JoinPoint joinPoint,JsonResult rvt,LoginOrRegLog loginOrRegLog){
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        System.out.println("============打印日志开始============");
        System.out.println("类型:" + loginOrRegLog.value());
        System.out.println("IP:" + request.getRemoteAddr());
        System.out.println("AfterReturning增强：获取目标方法的返回值：" + rvt.getMsg());
        System.out.println("URL: " + request.getRequestURL().toString());
        System.out.println("============打印日志结束============");
        UserLoginLogEntity userLoginLogEntity = new UserLoginLogEntity();
        userLoginLogEntity.setUlLoginIp(request.getRemoteAddr());
        userLoginLogEntity.setUlLoginMsg("类型:"+loginOrRegLog.value()+"\t操作消息:"+rvt.getMsg());
        if (loginOrRegLog.value().equals("登录")){
            if (rvt.getCode().equals(200)){
                // 登录成功则通过session获取id
                UserEntity userEntity = (UserEntity)request.getSession().getAttribute("loginUser");
                userLoginLogEntity.setUlUid(userEntity.getId());
                userLoginLogService.savelog(userLoginLogEntity);
            }else {
                // 失败通过查询得到用户id
                UserEntity userEntity = userDao.findByUsCellPhone((String) args[0]);
                UserEntity userEntity1 = userEntity == null ? userDao.findByUsEmail((String) args[0]):userEntity;
                if (userEntity1 != null){
                    userLoginLogEntity.setUlUid(userEntity1.getId());
                    userLoginLogService.savelog(userLoginLogEntity);
                }
            }
        }
        if (rvt.getCode().equals(200) && loginOrRegLog.value().equals("注册")){
            // 注册成功的才记录
            UserEntity userEntity = (UserEntity)args[0];
            userLoginLogEntity.setUlUid(userEntity.getId());
            userLoginLogService.savelog(userLoginLogEntity);
        }
        return rvt;
    }
}
