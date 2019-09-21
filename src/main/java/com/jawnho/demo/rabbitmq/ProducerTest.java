package com.jawnho.demo.rabbitmq;


import com.google.common.base.Preconditions;
import com.rabbitmq.client.MessageProperties;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author jawnho
 * @date 2019/9/19
 */
public class ProducerTest {


    public static void main(String[] args) throws IOException, TimeoutException {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            sendMsg(sc.nextLine());
        }
    }

    public static void sendMsg(String msg) throws IOException, TimeoutException {
        Preconditions.checkNotNull(msg);

        // 交换机 路由key 消息属性 消息
        Base.getChannel().basicPublish(
                "",
                Base.QUEUE_NAME,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                msg.getBytes()
        );
    }
}
