package cn.saya.framework.api.handle;

import cn.saya.framework.api.tools.Result;
import cn.saya.framework.api.tools.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局控制的拦截器，主要用于对异常的处理-除了在此要配置外，还要在dispatcher-servlet中配置，让它能正常扫描到。
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof MyException) {
            MyException myException = (MyException) e;
            return ResultUtil.error(myException.getCode(), myException.getMessage());
        }else
        {
            //不在定义范围内的异常错误
            return ResultUtil.error(-1, "未知错误");
        }
    }

}