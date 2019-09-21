package com.jawnho.demo.domain.dingTalk;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jawnho
 * @date 2019/7/19
 */

@Setter
@Getter
public class MarkDown {


    /**
     * 消息类型，消息类型为固定markdown
     *
     * @see MessageType
     */
    private final String msgType = MessageType.MARKDOWN;

    /**
     * 首屏会话透出的展示内容
     */
    private String title;

    /**
     * markdown格式的消息
     */
    private String text;

    /**
     * 	被@人的手机号(在text内容里要有@手机号)
     */
    private String[] atMobiles;

    /**
     * @ 所有人时：true，否则为：false
     */
    private boolean isAtAll;


}
