package top.qingxing.baigeventweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.dao
 * @ClassName: BaseDao
 * @Author: Sober
 * @Description:
 * @Date: 2020/5/26 23:13
 * @Version: 0.0.1
 */
@NoRepositoryBean
public interface BaseDao<T,ID> extends JpaRepository<T,ID> {
}
