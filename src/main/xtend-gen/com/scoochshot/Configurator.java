package com.scoochshot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.scoochshot.repository.mapping")
@SuppressWarnings("all")
public class Configurator {
}
