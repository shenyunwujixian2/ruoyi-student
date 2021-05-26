package com.ruoyi.utilswx;


import java.util.List;

/**
 * EntWxSendMessage class
 *
 * @author jinhongshi
 * @date 2020/6/22
 */
public interface EntWxSendMessageBiz {
    /**
     * 给用户发送企业微信通知
     *
     * @param userIds 用户主键集合
     * @param content 发送消息内容
     * @return 发送是否成功状态反馈
     */
    SendEntWxMessageDto sendTextMessage2Users(List<String> userIds, String content);

    /**
     * 给部门发送企业微信通知
     *
     * @param departmentIds 部门主键集合
     * @param content       发送消息内容
     * @return 发送是否成功状态反馈
     */
    SendEntWxMessageDto sendTextMessage2department(List<String> departmentIds, String content);

    /**
     * 检查给用户发送消息结果
     *
     * @param sendEntWxMessageDto 发送信息返回值
     * @return 未发送成功的用户列表 如果列表为空 表示全部发送成功
     */
//    List<String> checkReturnOfSendTextMessage2Users(SendEntWxMessageDto sendEntWxMessageDto);
}
