package top.qingxing.baigeventweb.annot;

import java.lang.annotation.*;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.annot
 * @ClassName: LoginOrRegLog
 * @Author: Sober
 * @Description:
 * @Date: 2020/5/27 3:37
 * @Version: 0.0.1
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginOrRegLog {
    String value() default "";
}
