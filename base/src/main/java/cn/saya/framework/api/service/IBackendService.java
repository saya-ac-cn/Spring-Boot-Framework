package cn.saya.framework.api.service;

import cn.saya.framework.api.entity.LogEntity;

import java.util.List;

public interface IBackendService {

    public List<LogEntity> findLogAll() throws Exception;

}
