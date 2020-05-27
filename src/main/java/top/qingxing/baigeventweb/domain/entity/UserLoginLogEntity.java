package top.qingxing.baigeventweb.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.domain.entity
 * @ClassName: UserLoginLogEntity
 * @Author: Sober
 * @Description: 登陆日志实体
 * @Date: 2020/5/26 21:44
 * @Version: 0.0.1
 */
@Entity(name = "bl_userlogin_log")
@Data
public class UserLoginLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ul_userid",nullable = false)
    private Integer ulUid;

    @Column(name = "ul_login_ip",nullable = false)
    private String ulLoginIp;

    @Column(name = "ul_login_msg",nullable = false)
    private String ulLoginMsg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "ul_login_time",nullable = false)
    private LocalDateTime creTime = LocalDateTime.now();
}
