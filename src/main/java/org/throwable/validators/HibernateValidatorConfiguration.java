package org.throwable.validators;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/16 11:29
 */
@Configuration
public class HibernateValidatorConfiguration {

    @Bean
    public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setFallbackToSystemLocale(true);
        messageSource.setUseCodeAsDefaultMessage(false);
        messageSource.setBasename("classpath:valid/validation");
        return messageSource;
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean localValidatorFactoryBean(
            ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource) {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(reloadableResourceBundleMessageSource);
        return localValidatorFactoryBean;
    }

}
