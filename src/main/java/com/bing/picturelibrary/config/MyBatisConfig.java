package com.bing.picturelibrary.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 * Created by bingglewang on 2019/5/15.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.bing.picturelibrary.mapper"})
public class MyBatisConfig {
}
