package com.ch8springdataredis;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:context_redis_cluster.xml")
public class RedisConfigure {

}
