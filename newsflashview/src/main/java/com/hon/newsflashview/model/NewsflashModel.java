package com.hon.newsflashview.model;

/**
 * @author LLhon
 * @Project NewsflashView-master
 * @Package com.hon.newsflashview.model
 * @Date 2017/1/17 22:56
 * @description
 */

public class NewsflashModel {

    private String label;
    private String content;
    private String label2;
    private String content2;

    public NewsflashModel() {

    }

    public NewsflashModel(String label, String content, String label2, String content2) {
        this.content2 = content2;
        this.content = content;
        this.label2 = label2;
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    @Override public String toString() {
        return "NewsflashModel{" +
            "content2='" + content2 + '\'' +
            ", label='" + label + '\'' +
            ", content='" + content + '\'' +
            ", label2='" + label2 + '\'' +
            '}';
    }
}
