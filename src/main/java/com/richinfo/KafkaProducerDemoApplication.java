package com.richinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
public class KafkaProducerDemoApplication {

	static {
		System.setProperty("java.security.auth.login.config", "E:\\IDEA_studing\\kafka-producer-demo\\src\\main\\resources\\kafka_cilent_jaas.conf");
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerDemoApplication.class, args);
	}

}
