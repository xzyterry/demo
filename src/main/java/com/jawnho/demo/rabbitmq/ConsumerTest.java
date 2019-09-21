package com.jawnho.demo.rabbitmq;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jawnho
 * @date 2019/9/20
 */
public class ConsumerTest {

    public static void main(String[] args) throws IOException, TimeoutException {

        Channel channel = Base.getChannel();
        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                    BasicProperties properties, byte[] body) throws IOException {

                String msg = new String(body, "utf8");
                System.out.println(msg);
                channel.basicAck(envelope.getDeliveryTag(), false);

            }
        };
        channel.basicConsume(Base.QUEUE_NAME, false, consumer);

    }


}
