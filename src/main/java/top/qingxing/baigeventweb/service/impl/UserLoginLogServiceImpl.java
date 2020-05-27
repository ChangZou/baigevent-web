package top.qingxing.baigeventweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qingxing.baigeventweb.dao.UserLoginLogDao;
import top.qingxing.baigeventweb.domain.entity.UserLoginLogEntity;
import top.qingxing.baigeventweb.service.UserLoginLogService;

import java.util.List;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.service.impl
 * @ClassName: UserLoginLogServiceImpl
 * @Author: Sober
 * @Description:
 * @Date: 2020/5/26 22:56
 * @Version: 0.0.1
 */
@Service
public class UserLoginLogServiceImpl extends BaseServiceImpl<UserLoginLogEntity> implements UserLoginLogService {
    @Autowired
    UserLoginLogDao userLoginLogDao;

    @Override
    public List<UserLoginLogEntity> getbyuid(Integer uid) {
        return userLoginLogDao.findAllByulUid(uid);
    }

    @Override
    public boolean savelog(UserLoginLogEntity userLoginLogEntity) {
        if (userLoginLogDao.save(userLoginLogEntity) != null){
            return true;
        }
        return false;
    }
}
