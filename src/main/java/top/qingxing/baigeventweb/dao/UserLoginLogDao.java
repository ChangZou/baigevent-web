package top.qingxing.baigeventweb.dao;

import org.springframework.stereotype.Repository;
import top.qingxing.baigeventweb.domain.entity.UserLoginLogEntity;

import java.util.List;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.dao
 * @ClassName: UserLoginLog
 * @Author: Sober
 * @Description: 日志表接口
 * @Date: 2020/5/26 22:02
 * @Version: 0.0.1
 */
@Repository
public interface UserLoginLogDao extends BaseDao<UserLoginLogEntity,Integer> {

    List<UserLoginLogEntity> findAllByulUid(Integer uid);
}
