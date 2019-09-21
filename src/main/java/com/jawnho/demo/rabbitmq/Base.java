package com.jawnho.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jawnho
 * @date 2019/9/20
 */
public class Base {

    public static final ConnectionFactory FACTORY = new ConnectionFactory();

    public static final String QUEUE_NAME = "queue";

    /**
     * init
     */
    public static Channel getChannel() throws IOException, TimeoutException {

        FACTORY.setHost("192.168.196.129");
        FACTORY.setPort(5672);
        FACTORY.setVirtualHost("/");
        FACTORY.setUsername("admin");
        FACTORY.setPassword("admin");

        // 失败重连模式：网络异常自动重新连接
        FACTORY.setAutomaticRecoveryEnabled(true);
        // 失败重连模式：每10秒重试连接
        FACTORY.setNetworkRecoveryInterval(10000);
        // 失败重连模式：重新声明交换器，队列等信息
        FACTORY.setTopologyRecoveryEnabled(true);


        // 连接
        Connection connection = FACTORY.newConnection();
        // 通道
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, true, null);

        return channel;
    }

}
