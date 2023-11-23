package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.services", "org.example.mappers", "org.example.reposirtory", "org.example.proxies"})
public class SpringConfig {
}
