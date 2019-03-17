package cn.saya.framework.api.tools;

/**
 * @Title: Log4jUtils
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/10/18 21:27
 * @Description:
 */

import java.io.PrintWriter;
import java.io.StringWriter;
public class Log4jUtils {


    /**
     * log4j日志记录
     * @param t
     * @return
     */
    public static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }
}

