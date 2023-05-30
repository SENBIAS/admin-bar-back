package com.startup.bar.infraestructure.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class DataSourceMongoConfig extends AbstractMongoClientConfiguration {
    @Value("${mongo.configuration.host}")
    public String host;

    @Value("${mongo.configuration.port}")
    public String port;

    @Value("${mongo.configuration.database}")
    public String database;

    @Value("${mongo.configuration.usecredentials}")
    public String useCredentials;

    @Value("${mongo.configuration.username}")
    public String username;

    @Value("${mongo.configuration.password}")
    public String password;

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Primary
    @Bean(name = "transactionMongoTemplate")
    public MongoTemplate primaryMongoTemplate() {
        return new MongoTemplate(mongoClient(), database);
    }

    @Override
    public MongoClient mongoClient() {
        if (Boolean.parseBoolean(useCredentials)) {
            return MongoClients.create(
                    MongoClientSettings.builder()
                            .credential(
                                    MongoCredential.createCredential(
                                            username, getDatabaseName(), password.toCharArray()))
                            .applyToClusterSettings(
                                    block ->
                                            block.hosts(Arrays.asList(new ServerAddress(host, Integer.parseInt(port)))))
                            .build());
        } else {
            return MongoClients.create(
                    MongoClientSettings.builder()
                            .applyToClusterSettings(
                                    block ->
                                            block.hosts(Arrays.asList(new ServerAddress(host, Integer.parseInt(port)))))
                            .build());
        }
    }
}
