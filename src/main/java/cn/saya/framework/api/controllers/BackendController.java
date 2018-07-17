package cn.saya.framework.api.controllers;

import cn.saya.framework.api.entity.LogEntity;
import cn.saya.framework.api.service.impl.BackendService;
import cn.saya.framework.api.tools.Result;
import cn.saya.framework.api.tools.ResultUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/backend")
public class BackendController {

    @Autowired
    @Qualifier("backendService")
    private BackendService backendService;

    @GetMapping(value = "/log")
    public Result<LogEntity> showLog() throws Exception
    {
        Gson gson = new Gson();
        return ResultUtil.success(gson.toJson(backendService.findLogAll()));
    }
}
