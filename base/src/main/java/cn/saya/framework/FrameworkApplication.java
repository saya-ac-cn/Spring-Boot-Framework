package cn.saya.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //定时任务
public class FrameworkApplication {

	private static Logger logger = LoggerFactory.getLogger(FrameworkApplication.class);

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(FrameworkApplication.class);
		// 禁止命令行设置参数
		springApplication.setAddCommandLineProperties(false);
		springApplication.run(args);
		// //项目启动完成打印项目名
		logger.warn("项目已经启动 ... ");
	}
}
