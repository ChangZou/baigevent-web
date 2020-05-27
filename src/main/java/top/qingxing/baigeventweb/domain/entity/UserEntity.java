package top.qingxing.baigeventweb.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.domain.entity
 * @ClassName: UserEntity
 * @Author: Sober
 * @Description: 用户实体
 * @Date: 2020/5/26 21:26
 * @Version: 0.0.1
 */
@Entity(name = "bl_user")
@Data
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "us_name",nullable = false)
    private String usName;

    @Column(name = "us_email",unique = true, nullable = false)
    private String usEmail;

    @Column(name = "us_cellphone",unique = true, nullable = false)
    private String usCellPhone;

    @Column(name = "us_password",nullable = false)
    private String usPassword;

    @Column(name = "us_salt",nullable = false)
    private String usSalt;

    @Column(name = "us_state",nullable = false)
    private Integer usState;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time",nullable = false)
    private LocalDateTime creTime = LocalDateTime.now();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updata_time",nullable = false)
    private LocalDateTime upTime;
}
