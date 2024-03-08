package com.ll.domain;

public class WSlist {
    private int num;
    private String content;
    private String author;

    public WSlist(int num, String content, String author) {
        this.num = num;
        this.content = content;
        this.author = author;
    }
    public int getId() {
        return num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthorName(String author) {
        this.author = author;
    }
}
