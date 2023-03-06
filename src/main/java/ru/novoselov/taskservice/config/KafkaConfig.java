package ru.novoselov.taskservice.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class KafkaConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String kafkaUrl;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaUrl);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic taskCreatedTopic() {
        return TopicBuilder
                .name(KafkaTopics.TASK_CREATED.getName())
                .partitions(3)
                .compact()
                .build();
    }


    @Bean
    public NewTopic taskCompletedopic() {
        return TopicBuilder
                .name(KafkaTopics.TASK_COMPLETED.getName())
                .partitions(3)
                .compact()
                .build();
    }
}
