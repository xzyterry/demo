package com.jawnho.demo.mongo;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 数据库配置
 *
 * @author gyj
 * @date 2019/5/20
 */
@Configuration
@EnableScheduling
public class DalConfig {

    //region mongodb connection

    @Bean
    public MongoClientOptions mongoClientOptions() {
        MongoClientOptions.Builder builder = MongoClientOptions.builder();
        builder.connectionsPerHost(1000);
        builder.threadsAllowedToBlockForConnectionMultiplier(1000);
        builder.maxWaitTime(180000);
        builder.connectTimeout(2000);
        builder.socketTimeout(120000);
        builder.writeConcern(new WriteConcern(1, 10000));

        return builder.build();
    }

    //endregion

    //region ws-main

    @Bean
    public MongoClient mainMongo() {
        String host = "127.0.0.1";
        String port = "27017";
        String username = "jawnho";
        String password = "123,./";
        String authDB = "test";

        return new MongoClient(
                new ServerAddress(
                        host,
                        Integer.valueOf(port.trim())
                ),
                MongoCredential.createCredential(
                        username,
                        authDB,
                        password.trim().toCharArray()
                ),
                mongoClientOptions()
        );
    }

    @Bean
    public SimpleMongoDbFactory mainMongoDbFactory() {
        String database = "xzy-ws-main";
        return new SimpleMongoDbFactory(mainMongo(), database);
    }

    @Bean
    public MongoTemplate mainMongoTemplate() {
        return new MongoTemplate(mainMongoDbFactory());
    }

    //endregion


    public static void main(String[] args) {
//        DalConfig config = new DalConfig();
//        MongoTemplate mongoTemplate = config.mainMongoTemplate();

        String str = "sdafads";
        System.out.println(stringToInt(str));

    }

    public static int stringToInt(String activeUserAmountStr) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(activeUserAmountStr));

        try {
            return Integer.parseInt(activeUserAmountStr);
        } catch (Exception e) {
            return 0;
        }
    }

}
