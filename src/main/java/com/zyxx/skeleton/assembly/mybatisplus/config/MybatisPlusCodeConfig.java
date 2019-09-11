package com.zyxx.skeleton.assembly.mybatisplus.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Mybatis plus 代码生成器配置
 *
 * @author Tellsea
 * @date 2019/7/18
 * Mybatis plus 官网：https://mp.baomidou.com/guide/generator.html
 */
public class MybatisPlusCodeConfig {

    /**
     * 项目路径
     */
    private static final String projectPath = System.getProperty("user.dir");
    /**
     * 模板存放位置
     */
    private static final String templatePathEntity = "/templates/code/entity.java.ftl";
    private static final String templatePathController = "/templates/code/controller.java.ftl";
    private static final String templatePathService = "/templates/code/service.java.ftl";
    private static final String templatePathServiceImpl = "/templates/code/serviceImpl.java.ftl";
    private static final String templatePathMapper = "/templates/code/mapper.java.ftl";
    private static final String templatePathDao = "/templates/code/dao.java.ftl";
    private static final String templatePathJsp = "/templates/code/view.jsp.ftl";
    /**
     * 生成文件位置
     */
    private static final String javaLocation = projectPath + "/src/main/java/com/zyxx/";
    private static final String pageLocation = projectPath + "/src/main/resources/views/";
    /**
     * 基类路径
     */
    private static final String basePackage = "com.zyxx.skeleton.core.base";

    /**
     * 代码生成
     *
     * @param model     模块名称
     * @param author    作者
     * @param tableName 表名
     */
    public static void codeGenerator(String model, String author, String tableName) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setFileOverride(true);
        gc.setServiceName("%sService");
        gc.setFileOverride(false);
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(getApplicationYml("url"));
        dsc.setDriverName(getApplicationYml("driver-class-name"));
        dsc.setUsername(getApplicationYml("username"));
        dsc.setPassword(getApplicationYml("password"));
        mpg.setDataSource(dsc);

        // 基础包配置
        final PackageConfig pc = new PackageConfig();
        pc.setModuleName(model);
        pc.setParent("com.zyxx");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>(16);
                map.put("Dao", "com.zyxx.skeleton.".concat(model).concat(".dao"));
                map.put("tableName", tableName);
                this.setMap(map);
            }
        };

        // 自定义输出配置，配置会被优先输出
        cfg.setFileOutConfigList(getFileOutConfig(model));
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(basePackage + ".entity.BaseEntity");
        strategy.setSuperControllerClass(basePackage + ".controller.BaseController");
        strategy.setSuperServiceClass(basePackage + ".service.BaseService");
        strategy.setSuperServiceImplClass(basePackage + ".service.impl.BaseServiceImpl");
        strategy.setSuperMapperClass(basePackage + ".mapper.MyMapper");
        strategy.setEntityLombokModel(true);
        strategy.setInclude(tableName);

        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * 自定义输出配置
     *
     * @return
     */
    private static List<FileOutConfig> getFileOutConfig(String model) {
        List<FileOutConfig> focList = new ArrayList<>();

        // Entity
        focList.add(new FileOutConfig(templatePathEntity) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return javaLocation + model + "/entity/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });

        // Controller
        focList.add(new FileOutConfig(templatePathController) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                tableInfo.setXmlName(convertToLowercase(tableInfo.getEntityName()));
                return javaLocation + model + "/controller/" + tableInfo.getEntityName() + "Controller" + StringPool.DOT_JAVA;
            }
        });

        // Service
        focList.add(new FileOutConfig(templatePathService) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return javaLocation + model + "/service/" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
            }
        });

        // ServiceImpl
        focList.add(new FileOutConfig(templatePathServiceImpl) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return javaLocation + model + "/service/impl/" + tableInfo.getEntityName() + "ServiceImpl" + StringPool.DOT_JAVA;
            }
        });

        // Mapper.java
        focList.add(new FileOutConfig(templatePathMapper) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return javaLocation + model + "/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
            }
        });

        // Dao.java
        focList.add(new FileOutConfig(templatePathDao) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return javaLocation + model + "/dao/" + tableInfo.getEntityName() + "Dao" + StringPool.DOT_JAVA;
            }
        });

        return focList;
    }

    /**
     * 全部转为小写
     *
     * @param oldStr
     * @return
     */
    public static String convertToLowercase(String oldStr) {
        char[] chars = oldStr.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private static Pattern pattern = Pattern.compile("[A-Z]");

    /**
     * 驼峰转下划线
     *
     * @param str
     * @return
     */
    public static StringBuffer humpTurnUnderscore(StringBuffer str) {
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer(str);
        if (matcher.find()) {
            sb = new StringBuffer();
            //将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里。
            //正则之前的字符和被替换的字符
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
            //把之后的也添加到StringBuffer对象里
            matcher.appendTail(sb);
        } else {
            return sb;
        }
        return humpTurnUnderscore(sb);
    }

    /**
     * 读取 application.yml
     *
     * @param key
     * @return
     */
    public static String getApplicationYml(String key) {
        Yaml yaml = new Yaml();
        InputStream resourceAsStream = null;
        Map map;
        Map datasource = null;
        try {
            resourceAsStream = MybatisPlusCodeConfig.class.getClassLoader().getResourceAsStream("application.yml");
            map = yaml.load(resourceAsStream);
            Map spring = (Map) map.get("spring");
            Map profiles = (Map) spring.get("profiles");
            String active = profiles.get("active").toString();
            if (StringUtils.isEmpty(active)) {
                // 没有设置当前启动环境
                datasource = (Map) spring.get("datasource");
            } else {
                resourceAsStream = MybatisPlusCodeConfig.class.getClassLoader().getResourceAsStream("application-" + active + ".yml");
                map = yaml.load(resourceAsStream);
                spring = (Map) map.get("spring");
                datasource = (Map) spring.get("datasource");
            }
            return (String) datasource.get(key);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
