package com.newone.xiaohongshu.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.newone.xiaohongshu.common.domain.mapper")
public class MybatisPlusConfig {
}
