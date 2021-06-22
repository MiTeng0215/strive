package com.miteng.strive.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("all")
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static <T> T getBean(Class<T> cls) {
        return applicationContext.getBean(cls);
    }


    public static <T> T getBean(String className) {
        return (T) applicationContext.getBean(className);
    }

    public static <T> T getBean(String className, Class<T> cls) {
        return applicationContext.getBean(className, cls);
    }

    public static <T> List<T> getBeans(Class<T> cls) {
        Map<String, T> beanMap = applicationContext.getBeansOfType(cls);
        return beanMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
       SpringContextHolder.applicationContext = applicationContext;
    }
}
