package cn.saya.framework.api.service.impl;

import cn.saya.framework.api.dao.LogDAO;
import cn.saya.framework.api.handle.MyException;
import cn.saya.framework.api.entity.LogEntity;
import cn.saya.framework.api.service.IBackendService;
import cn.saya.framework.api.tools.ResultEnum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("backendService")
public class BackendService implements IBackendService {

    @Resource
    @Qualifier("logDAO")
    private LogDAO logDAO;

    @Override
    public List<LogEntity> findLogAll() throws Exception {
        return logDAO.findAll();
    }
}
