package cn.saya.framework.api.config;

import cn.saya.framework.api.handle.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置拦截器
 */
@Configuration
public class WebConfigurerAdapter extends WebMvcConfigurerAdapter {

    /**
     * 拦截路由
     * @param registry
     * addPathPatterns 用于要添加拦截的路由
     * excludePathPatterns 用于排除要拦截路由
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/backend/**");
        super.addInterceptors(registry);
    }

}
