package ac.cn.saya.data.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Title: FirstDataSourceConfig
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2/18/21 22:10
 * @Description:
 */
@Configuration
@MapperScan(basePackages = "ac.cn.saya.data.dao.first",sqlSessionTemplateRef ="firstSqlSessionTemplate")
public class FirstDataSourceConfig {


    /**本数据源扫描的mapper路径*/
    static final String MAPPER_LOCATION = "classpath:mapper/first/*.xml";


    /**创建数据源*/
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.primary")
    public DataSource primaryDataSource() {
        return new AtomikosDataSourceBean();
    }


    /**创建SessionFactory*/
    @Bean(name = "firstSqlSessionFactory")
    @Primary
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //设置mapper配置文件
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }

    /**创建事务管理器*/
//    @Bean("firstTransactionManger")
//    @Primary
//    public DataSourceTransactionManager firstTransactionManger(@Qualifier("primaryDataSource") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }

    /**创建SqlSessionTemplate*/
    @Bean(name = "firstSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
