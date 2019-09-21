package com.jawnho.demo.Utils;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.request.OapiRobotSendRequest.Actioncard;
import com.dingtalk.api.request.OapiRobotSendRequest.Btns;
import com.dingtalk.api.request.OapiRobotSendRequest.Feedcard;
import com.dingtalk.api.request.OapiRobotSendRequest.Link;
import com.dingtalk.api.request.OapiRobotSendRequest.Links;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jawnho
 * @date 2019/7/19
 */
public class DingTalkUtil {

    public static void main(String[] args) throws ApiException {

        String webhook = "https://oapi.dingtalk.com/robot/send?access_token=e466cbae981b1b103cf4f7629dfefe3ae96936b1e1a665d508948eec21bc5700";

        //客户端
        DingTalkClient client = new DefaultDingTalkClient(webhook);

        // 机器人请求
        OapiRobotSendRequest request = new OapiRobotSendRequest();

        actionCardWhole(request);
        at(request, client);

    }

    public static void text(OapiRobotSendRequest request) {
        // 设置消息
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("");
        request.setText(text);
    }

    public static void at(OapiRobotSendRequest request, DingTalkClient client) throws ApiException {
        // @群成员
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setIsAtAll("true");
        request.setAt(at);
        client.execute(request);
    }

    public static void link(OapiRobotSendRequest request, DingTalkClient client)
            throws ApiException {
        // 设置链接
        request.setMsgtype("link");
        OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
        link.setMessageUrl("https://www.dingtalk.com/");
        link.setPicUrl("");
        link.setTitle("时代的火车向前开");
        link.setText("这个即将发布的新版本，创始人陈航（花名“无招”）称它为“红树林”。\n" +
                "而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是“红树林");
        request.setLink(link);
        client.execute(request);
    }

    public static void markdown(OapiRobotSendRequest request, DingTalkClient client)
            throws ApiException {
        // markdown
        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("杭州天气");
        markdown.setText("#### 杭州天气 @156xxxx8827\n" +
                "> 9度，西北风1级，空气良89，相对温度73%\n\n" +
                "> ![screenshot](https://gw.alipayobjects.com/zos/skylark-tools/public/files/84111bbeba74743d2771ed4f062d1f25.png)\n"
                +
                "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n");
        request.setMarkdown(markdown);
        client.execute(request);
    }

    public static void feedCard(OapiRobotSendRequest request){
        request.setMsgtype("feedCard");

        Feedcard feedcard = new Feedcard();

        List<Links> links = new LinkedList<>();
        Links links1 = new Links();
        links1.setTitle("斗鱼");
        links1.setMessageURL("https://douyu.com");
        links1.setPicURL("https://sta-op.douyucdn.cn/dylamr/2019/06/09/76dd2e7c4bbaf0b48bf7507121afb798.jpg");
        links.add(links1);

        Links link2 = new Links();
        link2.setTitle("虎牙");
        link2.setMessageURL("https://www.huya.com/");
        link2.setPicURL("http://livewebbs2.msstatic.com/huya_1557200420_content.jpg");

        links.add(link2);
        feedcard.setLinks(links);
        request.setFeedCard(feedcard);
    }

    public static void actionCard(OapiRobotSendRequest request){

        request.setMsgtype("actionCard");

        Actioncard actioncard = new Actioncard();
        actioncard.setTitle("直播平台");
        actioncard.setText("# 直播\n ### 直播 (点击)[https://www.baidu.com]");
        actioncard.setHideAvatar("1");
        actioncard.setBtnOrientation("0");

        List<Btns> btns = new LinkedList<>();

        Btns btn1 = new Btns();
        btn1.setTitle("斗鱼");
        btn1.setActionURL("https://douyu.com");
        btns.add(btn1);

        Btns btn2 = new Btns();
        btn2.setTitle("虎牙");
        btn2.setActionURL("https://www.huya.com/");
        btns.add(btn2);

        actioncard.setBtns(btns);
        request.setActionCard(actioncard);

    }


    public static void actionCardWhole(OapiRobotSendRequest request) {

        request.setMsgtype("actionCard");

        Actioncard actioncard = new Actioncard();
        actioncard.setTitle("直播平台");
        actioncard.setText("# 直播\n ### 直播 (点击)[https://www.baidu.com]");
        actioncard.setHideAvatar("1");
        actioncard.setBtnOrientation("0");
        actioncard.setSingleTitle("斗鱼");
        actioncard.setSingleURL("https://douyu.com");

        request.setActionCard(actioncard);

    }


}
