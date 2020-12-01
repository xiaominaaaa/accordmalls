package cn.accordmall.util;

import cn.accordmall.controller.BaseController;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * 自动代码生成器
 */
public class AccordmallAutoGenerator {
    public static void autoCode(){
        //1.自动生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        //2. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //设置开发人员, 老四是我
        globalConfig.setAuthor("laosi");
        //输出完之后不打开输出目录
        globalConfig.setOpen(false);
        //当前项目目录
        String projectPath = System.getProperty("user.dir");
        //设置输出位置
        globalConfig.setOutputDir(projectPath+"/src/main/java");
        //无可奈何
        //globalConfig.setServiceName("%sService/%sService");
        //swagger
        globalConfig.setSwagger2(true);
        autoGenerator.setGlobalConfig(globalConfig);

        //3. 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/accordmall?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=PRC");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        autoGenerator.setDataSource(dataSourceConfig);

        //4. 包配置
        PackageConfig packageConfig = new PackageConfig();
        //模板名
        packageConfig.setModuleName("");
        //父类包
        packageConfig.setParent("cn.accordmall");
        //实体类包名
        packageConfig.setEntity("pojo.model");
        //淦，包要出错，包名居然要出错。。。。。。
        //service 文件
//        packageConfig.setService("%sService/");
        //service impl 文件
//        packageConfig.setServiceImpl("%sService.impl");
        autoGenerator.setPackageInfo(packageConfig);

        //5.自定义配置

        //velocity 模板
        String velocity = "/templates/mapper.xml.vm";

        //自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        //自定义输出配置
        List<FileOutConfig> fileOutConfigs = new ArrayList<FileOutConfig>();
        //自定义位置会优先输出
        fileOutConfigs.add(new FileOutConfig(velocity) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输出文件名
                return projectPath+"/src/main/resources/mapper/"+packageConfig.getModuleName()
                        +"/"+tableInfo.getEntityName()+"Mapper"+ StringPool.DOT_XML;
            }
        });

        //设置自定义mapper输出位置
        injectionConfig.setFileOutConfigList(fileOutConfigs);
        //设置自定义模板配置
        autoGenerator.setCfg(injectionConfig);

        //设置模板引擎
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        autoGenerator.setTemplate(templateConfig);

        //6. 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //设置控制器父类实体
        strategyConfig.setSuperControllerClass(BaseController.class);
        //下划线转驼峰
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //lombok
        strategyConfig.setEntityLombokModel(true);

        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setTemplateEngine(new VelocityTemplateEngine());

        //执行
        autoGenerator.execute();
    }

    public static void main(String[] args) {
        autoCode();
    }
}
