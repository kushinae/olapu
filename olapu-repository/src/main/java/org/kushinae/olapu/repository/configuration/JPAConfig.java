package org.kushinae.olapu.repository.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Configuration
@EnableTransactionManagement
@EntityScan("org.kushinae.olapu.repository.entities")
@EnableJpaRepositories("org.kushinae.olapu.repository.repository.impl")
public class JPAConfig {

}
