package com.ruoyi.utilswx;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * EntWxSendMessageBizImpl class
 *
 * @author jinhongshi
 * @date 2020/6/22
 */
@Service
public class EntWxSendMessageBizImpl implements EntWxSendMessageBiz {

    /**
     * 企业id
     */
    @Value(value = "${wechat.corpid}")
    private String corpId;
    /**
     * 应用 Secret
     */
    @Value(value = "${wechat.corpsecret}")
    private String cropSecret;
    /**
     * 应用 agentid
     */
    @Value(value = "${wechat.agentId}")
    private String agentId;
    /**
     * token 有效期 单位 s
     */
//    @Value(value = "${entwx.term.expries_in}")
    private String expriesIn;
    /**
     * 获取token的url
     */
    @Value(value = "${wechat.ACCESS_TOKEN_URL}")
    public String getTokenUrl;
    /**
     * 发送应用消息的url
     */
    @Value(value = "${wechat.CREATE_SESSION_URL}")
    private String sendMessageUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private EntWxTokenBiz entWxTokenBiz;

    /**
     * 给指定用户发送 文本 消息
     *
     * @param userIds
     * @param content
     * @return
     */
    @Override
    public SendEntWxMessageDto sendTextMessage2Users(List<String> userIds, String content) {
        String url = sendMessageUrl.replace("ACCESS_TOKEN", getAccessTokenFromDb());
        StringBuilder users = new StringBuilder();
        for (String userId : userIds) {
            users.append(userId).append("|");
        }
        // 设置请求头 解决乱码
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        // 设置发送消息内容
        Map<String, Object> contentMap = new HashMap<>();
        contentMap.put("content", content);
        // 组装请求体
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("touser", users.toString());
        paramMap.put("msgtype", "text");
        paramMap.put("agentid", agentId);
        paramMap.put("text", contentMap);
        paramMap.put("safe", 0);
        String requestBody = JSON.toJSONString(paramMap);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        // 发送请求
        return restTemplate.postForObject(url, entity, SendEntWxMessageDto.class);
    }

    /**
     * 给指定部门发送文本消息
     *
     * @param departmentIds
     * @param content
     * @return
     */
    @Override
    public SendEntWxMessageDto sendTextMessage2department(List<String> departmentIds, String content) {

        String url = sendMessageUrl.replace("ACCESS_TOKEN", getAccessTokenFromDb());
        StringBuffer departments = new StringBuffer();
        for (String departmentId : departmentIds) {
            departments.append(departmentId + "|");
        }
        // 设置请求头 解决乱码
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        // 设置发送消息内容
        Map<String, Object> contentMap = new HashMap<>();
        contentMap.put("content", content);
        // 组装请求体
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("toparty", departments.toString());
        paramMap.put("msgtype", "text");
        paramMap.put("agentid", agentId);
        paramMap.put("text", contentMap);
        paramMap.put("safe", 0);
        String requestBody = JSON.toJSONString(paramMap);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        // 发送请求
        SendEntWxMessageDto sendEntWxMessageDto = restTemplate.postForObject(url, entity, SendEntWxMessageDto.class);
        return sendEntWxMessageDto;
    }

//    /**
//     * 检查给用户发送消息结果
//     *
//     * @param sendEntWxMessageDto 发送信息返回值
//     * @return
//     */
//    @Override
//    public List<String> checkReturnOfSendTextMessage2Users(SendEntWxMessageDto sendEntWxMessageDto) {
//        String successFlag = "0";
//        if (sendEntWxMessageDto.getErrcode().equals(successFlag)) {
//            String invalidUser = sendEntWxMessageDto.getInvaliduser();
//            String[] userIdArray = invalidUser.split("\\|");
//            return Arrays.asList(userIdArray);
//        } else {
////            throw new BusinessException("消息发送失败,错误码" + sendEntWxMessageDto.getErrcode());
//            return null;
//        }
//    }

    /**
     * 从微信服务器获取 token
     *
     * @return
     */
    private String getAccessTokenFromNet() {
        RestTemplate restTemplate = new RestTemplate();
        String url = getTokenUrl.replace("ID", corpId).replace("SECRET", cropSecret);
//        AccessTokenDto accessTokenDto = restTemplate.getForObject(url, AccessTokenDto.class);
//        return accessTokenDto.getAccess_token();
        return "";
    }

    /**
     * 从数据库获取 token
     *
     * @return
     */
    private String getAccessTokenFromDb() {

//        EntWxTokenEntity entWxTokenEntity = entWxTokenBiz.getToken();
//        // 首次执行无token 先获取token 保存数据库
//        if (entWxTokenEntity == null) {
//            String accessToken = getAccessTokenFromNet();
//            EntWxTokenEntity entWxTokenEntity1 = new EntWxTokenEntity();
//            entWxTokenEntity1.setToken(accessToken);
//            entWxTokenEntity1.setCreateDate(DateTimeLiteralExpression.DateTime.now());
//            entWxTokenBiz.save(entWxTokenEntity1);
//            return accessToken;
//        }
//        // 拿到插入时间检验是否过期
//        Date old = entWxTokenEntity.getCreateDate();
//        boolean tokenExpires = checkTokenExpires(old);
//
//        if (tokenExpires) {
//            return entWxTokenEntity.getToken();
//        } else {
//            String accessTokenFromNet = getAccessTokenFromNet();
//            EntWxTokenEntity entWxTokenEntity2 = new EntWxTokenEntity();
//            entWxTokenEntity2.setId(entWxTokenEntity.getId());
//            entWxTokenEntity2.setToken(accessTokenFromNet);
//            entWxTokenEntity2.setCreateDate(DateTime.now());
//            entWxTokenBiz.update(entWxTokenEntity2);
//            return accessTokenFromNet;
//        }
        return "";
    }

    /**
     * 检查token是否过期
     *
     * @param old 数据库中token的时间
     * @return true未过期 ；false过期
     */
    private boolean checkTokenExpires(Date old) {
//        Date now = DateUtil.parse(DateUtil.now());
//        long between = DateUtil.between(now, old, DateUnit.SECOND);
//        return between < Convert.toLong(expriesIn);
        return  false;
    }
}
