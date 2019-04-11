package com.learn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yinevg on 2019/4/11
 */
public class ServletConfig {

    private List<ServletConfigItem> servletConfigItems;

    private Map<String, String> servletMap;

    public ServletConfig(List<ServletConfigItem> servletConfigItems) {
        this.servletConfigItems = servletConfigItems;
        this.servletMap = new HashMap<>();
        for (ServletConfigItem item : servletConfigItems) {
            servletMap.put(item.getUrl(), item.getClazz());
        }
    }

    public String getServletClass(String url) {
        return servletMap.get(url);
    }

    public List<ServletConfigItem> getServletConfigItems() {
        return servletConfigItems;
    }

    public void setServletConfigItems(List<ServletConfigItem> servletConfigItems) {
        this.servletConfigItems = servletConfigItems;
    }

    public Map<String, String> getServletMap() {
        return servletMap;
    }

    public void setServletMap(Map<String, String> servletMap) {
        this.servletMap = servletMap;
    }
}
