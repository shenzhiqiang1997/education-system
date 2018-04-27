package com.chenhai.educationsystem.dto;

import com.chenhai.educationsystem.constant.Color;

public class TemplateJson<T>{
    private String touser;
    private String template_id;
    private String url="";
    private String topcolor= Color.BLACK;
    private T data;

    public TemplateJson() {
    }

    public TemplateJson(String touser, String template_id) {
        this.touser = touser;
        this.template_id = template_id;
    }

    public TemplateJson(String touser, String template_id, T data) {
        this.touser = touser;
        this.template_id = template_id;
        this.data = data;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
