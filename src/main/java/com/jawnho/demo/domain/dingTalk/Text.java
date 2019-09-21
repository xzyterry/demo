package com.jawnho.demo.domain.dingTalk;

import lombok.Getter;
import lombok.Setter;

/**
 * 文本消息
 *
 * @author jawnho
 * @date 2019/7/19
 */

@Setter
@Getter
public class Text {

    /**
     * 指定为 text
     * @see MessageType
     */
    private final String msgType = MessageType.TEXT;

    /**
     * 文本内容 不能为空
     */
    private String content;

    /**
     * @群成员 对应手机列表
     */
    private String[] atMobiles;

    /**
     * @所有人
     */
    private boolean isAtAll;


}
