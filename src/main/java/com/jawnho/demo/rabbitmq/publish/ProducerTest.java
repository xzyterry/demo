package com.jawnho.demo.rabbitmq.publish;

import com.jawnho.demo.rabbitmq.Base;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author jawnho
 * @date 2019/9/20
 */
public class ProducerTest {

    public static final String EX_NAME = "exchangeMasterA";
    public static final String ROUTING_KEY = "routingKey";

    public static void main(String[] args) throws IOException, TimeoutException {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            publish(sc.nextLine());
        }

    }

    public static void publish(String msg) throws IOException, TimeoutException {

        Channel channel = Base.getChannel();
        channel.exchangeDeclare(EX_NAME, "fanout");

        BasicProperties basicProperties = new BasicProperties();
        basicProperties.builder().deliveryMode(2).build();

        // mandatory false:没有找到队列,直接抛弃消息
        // deliveryMode 1.非持久化 2. 持久化
        channel.basicPublish(EX_NAME, ROUTING_KEY, false, basicProperties, msg.getBytes());
    }
}
