package com.stevi.springbootstarterlogger.config;

import com.stevi.springbootstarterlogger.aspect.RepositoryLoggerAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ConditionalOnClass(name = "org.springframework.data.repository.Repository")
@Configuration
@EnableAspectJAutoProxy
public class LoggerAutoConfiguration {

    @Bean
    public RepositoryLoggerAspect methodExecutionTimeLoggerAspect() {
        return new RepositoryLoggerAspect();
    }
}
