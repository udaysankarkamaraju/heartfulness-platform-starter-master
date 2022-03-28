package org.heartfulness.starter.integration.tests;

import org.heartfulness.starter.domain.model.VisitorTask;
import org.heartfulness.starter.domain.model.VisitorTaskRepository;
import org.heartfulness.starter.domain.service.GoogleCloudStorageServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@ComponentScan(
        basePackages = {
                "org.heartfulness.starter",
        }
        // Exclude classes which are dependent on external things. Mock them as required
        , excludeFilters = { @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {
                    GoogleCloudStorageServiceImpl.class
                })
        })
@EnableTransactionManagement
@EntityScan(basePackageClasses = VisitorTask.class)
@EnableJpaRepositories(basePackageClasses = {VisitorTaskRepository.class})
@EnableJpaAuditing
public class StarterTestingApp {
    public static void main(String[] args) {
        SpringApplication.run(StarterTestingApp.class, args);
    }
}
