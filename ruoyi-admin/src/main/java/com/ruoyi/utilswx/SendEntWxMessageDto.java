package com.ruoyi.utilswx;

import lombok.Data;

import java.io.Serializable;

/**
 * SendMessageResponse class
 *
 * @author jinhongshi
 * @date 2020/6/21
 */
@Data
public class SendEntWxMessageDto implements Serializable {
    /**
     * 返回码
     */
    private String errcode;
    /**
     * 返回消息
     */
    private String errmsg;
    /**
     * 未发送成功的用户
     */
    private String invaliduser;
    /**
     * 未发送成功的部门
     */
    private String invalidparty;
    /**
     * 未发送成功的标签
     */
    private String invalidtag;
}
