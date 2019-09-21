package com.jawnho.demo.rabbitmq.publish;

import com.jawnho.demo.rabbitmq.Base;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.AMQP.Queue.BindOk;
import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author jawnho
 * @date 2019/9/20
 */
public class ConsumerTest {


    public static void main(String[] args) throws IOException, TimeoutException {

        subscribe("队列A");
    }


    public static void subscribe(String queueName) throws IOException, TimeoutException {

        Channel channel = Base.getChannel();

        // 声明队列
        Map<String, Object> map = new HashMap<>();
        DeclareOk declareOk = channel.queueDeclare(queueName, false, false, true, map);

        // 队列绑定交换机
        channel.queueBind(declareOk.getQueue(), ProducerTest.EX_NAME, ProducerTest.ROUTING_KEY, map);

        // 消息监听
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(
                    String consumerTag,
                    Envelope envelope,
                    BasicProperties properties,
                    byte[] body) throws IOException {

                System.out.println("consumerTag:    " + consumerTag);
                System.out.println("envelope:    " + envelope.toString());
                System.out.println("properties:    " + properties.toString());
                System.out.println("body:    " + new String(body));

            }
        };

        // 回调
        channel.basicConsume(declareOk.getQueue(), true, "消费者A", consumer);

    }

}
