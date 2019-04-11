package com.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by Yinevg on 2019/4/10
 */
public class Server {

    // TODO: 2019/4/11 参考 https://mp.weixin.qq.com/s/2wioHX9zW7bCdxCMmkszPg，后再进一步拓展 

    private static Logger log = LoggerFactory.getLogger(Server.class);

    private Integer port = 8080;
    private ServletConfig servletConfig;

    public Server() {
        servletConfig = new ServletConfig(Arrays.asList(new ServletConfigItem("/index", "index", "com.learn.IndexServlet")));
    }

    public Server(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }

    public Server(Integer port, ServletConfig servletConfig) {
        this.port = port;
        this.servletConfig = servletConfig;
    }

    private void dispatch(BaseRequest request, BaseResponse response) {
        String clazz = servletConfig.getServletClass(request.getUrl());
        try {
            Class<Servlet> servletClass = (Class<Servlet>) Class.forName(clazz);
            Servlet servlet = servletClass.newInstance();
            servlet.service(request, response);
        } catch (Exception e) {
            log.error("dispatch error", e);
        }
    }

    public void start() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            log.info("server start : {}", port);
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                // TODO: 2019/4/11 未能正确解析请求，待解决 
                BaseRequest request = new BaseRequest(in);
                BaseResponse response = new BaseResponse(out);
                this.dispatch(request, response);
                socket.close();
            }
        } catch (Exception e) {
            log.error("listen {} error", port, e);
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (Exception e) {
                    log.error("stop server error", e);
                }
            }
        }
    }
}

