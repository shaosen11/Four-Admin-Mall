package com.edu.lingnan.fouradminmallboot.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 16:44 2020/7/19
 *
 * 一定要看这里的注释
 * 代码自动生成器
 * 只需要修改两个地方，其他地方暂时都不需要改
 * 1. 63行的模块名称，表名的前缀，生产在指定的文件夹下面
 * 2. 75行的表名，对应数据库的表名
 */

public class MybatisPlusGenerator {
    public static void main(String[] args) {
        //需要构建一个代码自动生成器
        AutoGenerator mpg = new AutoGenerator();
        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //获取项目文件路径
        String projectPath = System.getProperty("user.dir");
        //设置基础路径
        globalConfig.setOutputDir(projectPath + "/Four-Admin-Mall-Boot/src/main/java");
        globalConfig.setAuthor("four-admin-mall");
        globalConfig.setOpen(false);
        //是否覆盖
        globalConfig.setFileOverride(true);
        globalConfig.setServiceName("%sService");
        //设置主键策略
        globalConfig.setIdType(IdType.ID_WORKER);
        //设置swagger
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setSwagger2(true);
        mpg.setGlobalConfig(globalConfig);

        //2.设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://47.98.240.31:3307/four_admin_mall");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("20177600");
        dataSourceConfig.setDbType(DbType.MYSQL);
        mpg.setDataSource(dataSourceConfig);

        //3.包的配置
        PackageConfig pc = new PackageConfig();
        //1.一定要确定module名称，按表名前缀选择
        pc.setModuleName("ums");
//        pc.setModuleName("oms");
        pc.setParent("com.edu.lingnan.fouradminmallboot");
        pc.setEntity("pojo");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //4.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //2.修改要生产的表
        strategyConfig.setInclude("ums_resource");
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        //设置逻辑删除
        strategyConfig.setLogicDeleteFieldName("delete_id");

        //自动填充配置
        TableFill gmt_create = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmt_modified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmt_create);
        tableFills.add(gmt_modified);
        strategyConfig.setTableFillList(tableFills);
        //乐观锁设置
        strategyConfig.setVersionFieldName("version");

        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategyConfig);

        mpg.execute();

    }
}
