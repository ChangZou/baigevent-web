package top.qingxing.baigeventweb.dao;

import org.springframework.stereotype.Repository;
import top.qingxing.baigeventweb.domain.entity.UserEntity;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.dao
 * @ClassName: UserDao
 * @Author: Sober
 * @Description: 用户表接口
 * @Date: 2020/5/26 21:55
 * @Version: 0.0.1
 */
@Repository
public interface UserDao extends BaseDao<UserEntity,Integer> {

    UserEntity findByUsCellPhone(String username);

    UserEntity findByUsEmail(String username);
}
