package top.qingxing.baigeventweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qingxing.baigeventweb.dao.BaseDao;
import top.qingxing.baigeventweb.service.BaseService;

import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: baigevent-web
 * @Package: qingxing.top.baigeventweb.service.impl
 * @ClassName: BaseServiceImpl
 * @Author: Sober
 * @Description: 基础impl
 * @Date: 2020/5/26 22:20
 * @Version: 0.0.1
 */
@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    BaseDao<T,Integer> baseDao;

    @Override
    public List<T> list() {
        return baseDao.findAll();
    }

    @Override
    public Optional<T> getbyid(Integer id) {
        return baseDao.findById(id);
    }
}
