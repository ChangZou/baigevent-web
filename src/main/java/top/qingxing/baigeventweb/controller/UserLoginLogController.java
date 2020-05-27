package top.qingxing.baigeventweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qingxing.baigeventweb.domain.entity.UserEntity;
import top.qingxing.baigeventweb.service.UserLoginLogService;
import top.qingxing.baigeventweb.utils.JsonResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.controller
 * @ClassName: UserLoginLogController
 * @Author: Sober
 * @Description:
 * @Date: 2020/5/27 3:18
 * @Version: 0.0.1
 */
@RestController
@RequestMapping("${api.v1}")
public class UserLoginLogController {

    @Resource
    UserLoginLogService userLoginLogService;

    @GetMapping("/log")
    public JsonResult userloginlog(HttpServletRequest request){
        UserEntity user=(UserEntity)request.getSession().getAttribute("loginUser");
        return new JsonResult(200,userLoginLogService.getbyuid(user.getId()));
    }
}
