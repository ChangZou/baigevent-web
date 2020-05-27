package top.qingxing.baigeventweb.service;

import top.qingxing.baigeventweb.domain.entity.UserEntity;

import java.security.NoSuchAlgorithmException;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.service.impl
 * @ClassName: UserService
 * @Author: Sober
 * @Description: 用户服务接口
 * @Date: 2020/5/26 22:06
 * @Version: 0.0.1
 */
public interface UserService extends BaseService<UserEntity> {

    UserEntity login(String username, String pwd);

    boolean reg(UserEntity userEntity) throws NoSuchAlgorithmException;
}
