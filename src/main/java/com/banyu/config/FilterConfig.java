package com.banyu.config;

import com.banyu.filter.CustomFilter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2022/6/15 17:04
 * @describe
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "huxiao.eagle-eye")
@ConditionalOnProperty(name = "huxiao.eagle-eye.enabled", havingValue = "true", matchIfMissing = true)
@Slf4j
public class FilterConfig {

    private boolean enabled;

    @Bean
    public FilterRegistrationBean<CustomFilter> tracingFilterRegistrationBean() {
        log.info("FilterConfig");
        FilterRegistrationBean<CustomFilter> filterRegistrationBean = new FilterRegistrationBean<CustomFilter>();
        filterRegistrationBean.setFilter(new CustomFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("FilterConfig");
        return filterRegistrationBean;
    }
}
