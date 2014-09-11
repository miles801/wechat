package com.miles.wechat.impl;

import com.miles.wechat.api.BasicService;
import com.miles.wechat.core.ServiceLoader;
import com.miles.wechat.utils.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

/**
 * @author miles
 * @datetime 2014/5/21 1:41
 */
public class BasicServiceImpl implements BasicService {
    public static final int MAX_EXPIRE = 30 * 1000;//30秒


    @Override
    public boolean signature(String signature, String timestamp, String nonce) {
        String[] tokens = ServiceLoader.newInstance().getTokenPolicy().getTokens();
        if (tokens == null || tokens.length < 1) {
            throw new SecurityException("没有获得微信的token!");
        }
        if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce)) {
            throw new IllegalArgumentException("微信接口认证时缺少参数!");
        }
        for (String token : tokens) {
            if (verify(token, signature, timestamp, nonce)) {
                return true;
            }
        }
        return false;
    }

    private boolean verify(String token, String signature, String timestamp, String nonce) {
        Long serverTime = Long.parseLong(timestamp);
        if (new Date().getTime() - serverTime > MAX_EXPIRE) {
            throw new SecurityException("请求的发起时间与当前时间间隔过大，怀疑为恶意校验!");
        }

        String[] arr = new String[]{token, timestamp, nonce};
        // 将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (String anArr : arr) {
            content.append(anArr);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = StringUtils.byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        content = null;
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null && tmpStr.equals(signature.toUpperCase());
    }
}
