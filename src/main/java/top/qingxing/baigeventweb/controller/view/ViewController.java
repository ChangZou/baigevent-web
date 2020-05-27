package top.qingxing.baigeventweb.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import top.qingxing.baigeventweb.annot.LoginOrRegLog;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.controller.view
 * @ClassName: ViewController
 * @Author: Sober
 * @Description: 视图
 * @Date: 2020/5/26 20:46
 * @Version: 0.0.1
 */
@Controller
public class ViewController {


    @GetMapping("/login")
    public String loginview(){
        return "login";
    }

    @GetMapping("/reg")
    public String regview(){
        return "reg";
    }

    @GetMapping("/")
    public String indexview(){
        return "index";
    }
}
