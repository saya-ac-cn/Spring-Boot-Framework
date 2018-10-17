package cn.saya.framework;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //定时任务
public class FrameworkApplication {

	private static final Logger logger = Logger.getLogger(FrameworkApplication.class);

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(FrameworkApplication.class);
		springApplication.setAddCommandLineProperties(false);// 禁止命令行设置参数
		springApplication.run(args);
		logger.warn("项目已经启动 ... ");//项目启动完成打印项目名
	}
}
