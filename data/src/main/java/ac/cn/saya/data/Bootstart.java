package ac.cn.saya.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Title: Bootstart
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2020-10-14 22:38
 * @Description:
 */
@SpringBootApplication
public class Bootstart {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Bootstart.class);
        // 禁止命令行设置参数
        springApplication.setAddCommandLineProperties(false);
        springApplication.run(args);
        // //项目启动完成打印项目名
        System.out.println("项目已经启动 ... ");
    }

}
