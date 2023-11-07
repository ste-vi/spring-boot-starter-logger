package com.stevi.springbootstarterlogger.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ConditionalOnClass(name = "org.springframework.data.repository.Repository")
@EnableAspectJAutoProxy
@Configuration
public class LoggerAutoConfiguration {
}
