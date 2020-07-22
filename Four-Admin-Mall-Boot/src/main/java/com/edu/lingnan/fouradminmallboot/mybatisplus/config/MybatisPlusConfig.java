package com.edu.lingnan.fouradminmallboot.mybatisplus.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 15:25 2020/7/19
 */
//@MapperScan("com.edu.lingnan.fouradminmallboot.*.mapper")
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
    /**
     * 注册乐观锁
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**
     * 逻辑删除
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

    /**
     *
     */
    @Bean
    @Profile({"dev"})
    PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        performanceInterceptor.setMaxTime(15000);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
}
