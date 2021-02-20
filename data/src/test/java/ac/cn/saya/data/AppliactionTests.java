package ac.cn.saya.data;

import ac.cn.saya.data.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title: AppliactionTests
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2020-10-14 23:23
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppliactionTests {

    @Autowired
    private TransactionService transactionService;

    @Test
    public void contextLoads() {
        System.out.println("启动");
    }

    @Test
    public void save() {
        transactionService.tx();
    }

}
