package com.chenhai.educationsystem.dto;

public class HomeworkMessage {
    private MessageElement first;
    private MessageElement keyword1;
    private MessageElement keyword2;
    private MessageElement keyword3;
    private MessageElement keyword4;
    private MessageElement remark;

    public HomeworkMessage(MessageElement first, MessageElement keyword1, MessageElement keyword2, MessageElement keyword3, MessageElement keyword4, MessageElement remark) {
        this.first = first;
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
        this.keyword3 = keyword3;
        this.keyword4 = keyword4;
        this.remark = remark;
    }

    public HomeworkMessage() {
    }

    public MessageElement getFirst() {
        return first;
    }

    public void setFirst(MessageElement first) {
        this.first = first;
    }

    public MessageElement getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(MessageElement keyword1) {
        this.keyword1 = keyword1;
    }

    public MessageElement getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(MessageElement keyword2) {
        this.keyword2 = keyword2;
    }

    public MessageElement getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(MessageElement keyword3) {
        this.keyword3 = keyword3;
    }

    public MessageElement getKeyword4() {
        return keyword4;
    }

    public void setKeyword4(MessageElement keyword4) {
        this.keyword4 = keyword4;
    }

    public MessageElement getRemark() {
        return remark;
    }

    public void setRemark(MessageElement remark) {
        this.remark = remark;
    }
}
