package br.com.lp2.repository.mongodb.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class ConfigMongoDev {

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(getUser(),"lp2021-dev-eolo");
    }

    private MongoClient getUser(){
        return MongoClients.create("mongodb+srv://lp2:9sPpfptyRDumWWhY@lp2-cluster-01.zqexz.mongodb.net");
    }
}
