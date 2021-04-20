package com.czd.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * mybatis-plus工具构造器配置类
 */

@Component
public class MybatisPlusConfig {
    /**
     * 乐观锁配置
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**
     * 配置逻辑删除构造器
     */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

    //分页配置
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

}
