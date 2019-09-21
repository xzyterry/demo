package com.jawnho.demo.domain.dingTalk;

import lombok.Getter;
import lombok.Setter;

/**
 * 整体跳转ActionCard类型
 *
 * @author jawnho
 * @date 2019/7/19
 */

@Getter
@Setter
public class SingleActionCard {

    /**
     * 消息类型，此消息类型为固定actionCard
     *
     * @see MessageType
     */
    private final String msgType = MessageType.ACTION_CARD;

    /**
     * 首屏会话透出的展示内容
     */
    private String title;

    /**
     * markdown格式的消息
     */
    private String text;


    /**
     * 单个按钮的方案。(设置此项和singleURL后btns无效)
     */
    private String singleTitle;

    /**
     * 点击singleTitle按钮触发的URL
     */
    private String singleURL;

    /**
     * 0-按钮竖直排列，1-按钮横向排列,可选
     */
    private String btnOrientation;

    /**
     * 0-正常发消息者头像，1-隐藏发消息者头像,可选
     */
    private String hideAvatar;


}
