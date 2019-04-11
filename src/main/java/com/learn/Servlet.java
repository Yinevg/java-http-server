package com.learn;

/**
 * Created by Yinevg on 2019/4/11
 */
public abstract class Servlet {

    public abstract void doGet(BaseRequest request, BaseResponse response);

    public abstract void doPost(BaseRequest request, BaseResponse response);

    public void service(BaseRequest request, BaseResponse response) {
        if (request.getMethod().equalsIgnoreCase("POST")) {
            this.doPost(request, response);
        } else if (request.getMethod().equalsIgnoreCase("GET")) {
            this.doGet(request, response);
        }
    }
}
