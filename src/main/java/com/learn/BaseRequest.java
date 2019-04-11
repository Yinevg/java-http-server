package com.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Yinevg on 2019/4/10
 */
public class BaseRequest {

    private static Logger log = LoggerFactory.getLogger(BaseRequest.class);

    private String url;
    private String method;
    // TODO: 2019/4/10 header待做

//    http请求
//    GET /index HTTP/1.1
//    Host: localhost:8080
//    Connection: keep-alive
//    Accept: */*
//    User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36

    public BaseRequest(InputStream in) throws IOException {
        String requestInfo = "";
        byte[] buffer = new byte[1024];
        int length = 0;
        if ((length = in.read(buffer)) > 0) {
            // TODO: 2019/4/10 暂定header长度小于1024比特
            requestInfo = new String(buffer, 0, length);
        }
        log.info("request info : {}", requestInfo);
        String httpHead = requestInfo.split("\n")[0];
        method = httpHead.split(" ")[0];
        url = httpHead.split(" ")[1];
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
