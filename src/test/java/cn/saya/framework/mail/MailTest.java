package cn.saya.framework.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

/**
 * @Title: MailTest
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/10/14 17:51
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private MailService MailService;

    @Resource
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        MailService.sendHtmlMail("pandoras@189.cn","测试邮箱",content);
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "101");
        String emailContent = templateEngine.process("mail/layout1", context);
        MailService.sendHtmlMail("pandoras@189.cn","激活测试",emailContent);
    }

}
