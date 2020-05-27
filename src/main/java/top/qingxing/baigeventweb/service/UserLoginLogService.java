package top.qingxing.baigeventweb.service;

import top.qingxing.baigeventweb.domain.entity.UserLoginLogEntity;

import java.util.List;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.service.impl
 * @ClassName: UserLoginLogService
 * @Author: Sober
 * @Description: 日志服务接口
 * @Date: 2020/5/26 22:17
 * @Version: 0.0.1
 */
public interface UserLoginLogService extends BaseService<UserLoginLogEntity> {
    List<UserLoginLogEntity> getbyuid(Integer uid);

    boolean savelog(UserLoginLogEntity userLoginLogEntity);
}
