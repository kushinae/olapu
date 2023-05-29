package org.kushinae.olapu.api;

import org.kushinae.olapu.repository.configuration.JPAConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@SpringBootApplication
@Import(JPAConfig.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
