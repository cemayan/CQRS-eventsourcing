package com.ca.musiccmdapi;

import com.ca.musiccore.configuration.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({AxonConfig.class})
@EnableDiscoveryClient
@EnableR2dbcRepositories
@EntityScan(basePackages = "com.ca.musiccore.models")
public class MusicCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicCommandApplication.class, args);
    }

}
