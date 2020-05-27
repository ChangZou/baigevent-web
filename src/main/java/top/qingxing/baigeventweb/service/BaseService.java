package top.qingxing.baigeventweb.service;

import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.service.impl
 * @ClassName: BaseService
 * @Author: Sober
 * @Description: 基础服务接口
 * @Date: 2020/5/26 22:09
 * @Version: 0.0.1
 */
public interface BaseService<T>{
    // 查询全部
    List<T> list();

    // 根据id查询
    Optional<T> getbyid(Integer id);

}
