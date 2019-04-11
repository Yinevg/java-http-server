package com.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Yinevg on 2019/4/11
 */
public class IndexServlet extends Servlet {

    private static Logger log = LoggerFactory.getLogger(IndexServlet.class);

    @Override
    public void doGet(BaseRequest request, BaseResponse response) {
        try {
            response.write("Get Index");
        } catch (IOException e) {
            log.error("IndexServlet get error", e);
        }
    }

    @Override
    public void doPost(BaseRequest request, BaseResponse response) {
        try {
            response.write("Post Index");
        } catch (IOException e) {
            log.error("IndexServlet post error", e);
        }
    }
}
