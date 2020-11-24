package cn.accordmall.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidCongfig {

    @Bean
    @ConfigurationProperties("sprin.datasource")
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**
     * 监控的bean
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        //注册servlet,配置访问的路径
        ServletRegistrationBean<StatViewServlet> statServlegt = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(),"/druid/*");

        //后台配置
        Map<String,String> initParamsMap = new HashMap<String, String>();

        initParamsMap.put("loginUsername","root");
        initParamsMap.put("loginPassword","123456");

        //谁可以访问,不写表示所有人都可以
//        initParamsMap.put("allow","127.0.0.1");
        //不允许谁访问,直接写
//        initParamsMap.put("laosi","192.168.0.1");
        //设置
        statServlegt.setInitParameters(initParamsMap);
        return statServlegt;
    }

    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();

        //设置过滤请求
        Map<String,String> initParamsMap = new HashMap<String, String>();
        //不拦截
        initParamsMap.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParamsMap);

        return bean;
    }
}
