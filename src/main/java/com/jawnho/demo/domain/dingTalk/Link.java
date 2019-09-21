package com.jawnho.demo.domain.dingTalk;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jawnho
 * @date 2019/7/19
 */

@Getter
@Setter
public class Link {

    /**
     * 消息类型，此时固定为：link
     * @see MessageType
     */
    private final String msgType = MessageType.LINK;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容。如果太长只会部分展示
     */
    private String text;

    /**
     * 点击消息跳转的URL
     */
    private String messageUrl;

    /**
     * 图片URL,可选
     */
    private String picUrl;

}
