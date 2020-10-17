package ac.cn.saya.data;

import ac.cn.saya.data.dao.ClassesDAO;
import ac.cn.saya.data.entity.ClassesEntity;
import ac.cn.saya.data.entity.MajorEntity;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
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
    private ClassesDAO classesDAO;

    @Test
    public void contextLoads() {
        System.out.println("启动");
    }

    @Test
    public void save(){
        //classesDAO.save("2014级1班",1);
        System.out.println(classesDAO.findById(1));
    }

}
