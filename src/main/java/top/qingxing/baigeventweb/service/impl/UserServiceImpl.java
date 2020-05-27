package top.qingxing.baigeventweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qingxing.baigeventweb.dao.UserDao;
import top.qingxing.baigeventweb.domain.entity.UserEntity;
import top.qingxing.baigeventweb.service.UserService;
import top.qingxing.baigeventweb.utils.Md5Utils;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.service.impl
 * @ClassName: UserServiceImpl
 * @Author: Sober
 * @Description:
 * @Date: 2020/5/26 22:53
 * @Version: 0.0.1
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity> implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserEntity login(String username, String pwd) {
        UserEntity userEntity = userDao.findByUsCellPhone(username);
        UserEntity userEntity1 = userEntity == null ? userDao.findByUsEmail(username):userEntity;
        // 判断是否存在用户
        if (userEntity1 != null){
            Md5Utils md5Utils = new Md5Utils();
            // 验证密码
            if (md5Utils.verify(pwd,userEntity1.getUsSalt(),userEntity1.getUsPassword())){
                return userEntity1;
            }
        }
        return null;
    }

    @Override
    public boolean reg(UserEntity userEntity) throws NoSuchAlgorithmException {
        // 判断是否存在重复手机或邮箱
        if (userDao.findByUsCellPhone(userEntity.getUsCellPhone()) == null && userDao.findByUsEmail(userEntity.getUsEmail()) == null){
            Md5Utils md5Utils = new Md5Utils();
            userEntity.setUpTime(LocalDateTime.now());
            userEntity.setUsSalt(md5Utils.getSalt(12));
            userEntity.setUsState(1);
            userEntity.setUsPassword(md5Utils.getEncryot(userEntity.getUsPassword(),userEntity.getUsSalt()));
            userDao.save(userEntity);
            return true;
        }
        return false;
    }
}
