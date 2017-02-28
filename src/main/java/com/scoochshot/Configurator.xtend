package com.scoochshot

import org.springframework.context.annotation.Configuration
import org.mybatis.spring.annotation.MapperScan

@Configuration
@MapperScan("com.scoochshot.repository.mapping")
class Configurator {
	
}