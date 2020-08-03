package com.fh.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import java.io.IOException;
import java.io.UnsupportedEncodingException;






public class CodeUtil {

    public static void main(String[] args) throws Exception {

        HttpClient client = new HttpClient();

        PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");

        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码

        NameValuePair[] data = {

                new NameValuePair("Uid", "java_miracle"), // 注册的用户名

                new NameValuePair("Key", "d41d8cd98f00b204e980"), // 注册成功后,登录网站使用的密钥

                new NameValuePair("smsMob", "15515468277"), // 手机号码

                new NameValuePair("smsText", "您的手机验证码是123456") };//设置短信内容

        post.setRequestBody(data);

        client.executeMethod(post);

        Header[] headers = post.getResponseHeaders();

        int statusCode = post.getStatusCode();

        //statusCode=200表示请示成功！
        System.out.println("statusCode:" + statusCode);

        for (Header h : headers) {

            System.out.println(h.toString());

        }

        //设置编码格式
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));

        System.out.println(result);

        post.releaseConnection();

    }

}
