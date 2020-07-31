package com.richinfo.producer;

import com.alibaba.fastjson.JSONObject;
import com.richinfo.domain.Student;
import com.richinfo.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

/**
 * kafka消息生产者例子
 *
 * @author yexuce
 * @date 2019-05-14
 */
@Component
public class KafkaMsgProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaMsgProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.app.topic.foo}")
    private String topic;

    @Scheduled(cron = "20 * * * * ?")
    public void sendMessage() {

        String message = "";
        Student s = null;
        String jsonString = "";
        ListenableFuture<SendResult<String, String>> future = null;
        for (int i = 1; i <= 10; i++) {
            message = "Hello World---" + System.currentTimeMillis();
            logger.info("topic=" + topic + ",message=" + message);
            s = new Student();
            s.setName("姓名" + i);
            s.setAge(i);
            jsonString = JsonUtils.obj2String(s);

            future = kafkaTemplate.send(topic, jsonString);
            future.addCallback(success -> logger.info("KafkaMessageProducer 发送消息成功！"),
                    fail -> logger.error("KafkaMessageProducer 发送消息失败！"));
        }
    }
}
