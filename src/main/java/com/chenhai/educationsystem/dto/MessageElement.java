package com.chenhai.educationsystem.dto;

import com.chenhai.educationsystem.constant.Color;

public class MessageElement {
    private String value;
    private String color = Color.BLACK;

    public MessageElement() {
    }

    public MessageElement(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
