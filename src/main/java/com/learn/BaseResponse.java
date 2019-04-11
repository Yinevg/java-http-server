package com.learn;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Yinevg on 2019/4/11
 */
public class BaseResponse {

    private OutputStream out;

    public BaseResponse(OutputStream out) {
        this.out = out;
    }

    public void write(String content) throws IOException {

        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</body></html>");
        out.write(response.toString().getBytes());
        out.close();
    }
}
