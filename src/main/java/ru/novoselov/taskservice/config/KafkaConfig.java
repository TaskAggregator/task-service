package ru.novoselov.taskservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {


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
