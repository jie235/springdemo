package com.jie.springbootlogin.bean;

/**
 * @author: jie
 */
public class Book {
    private String title;
    private String author;
    private String publisher;
    private String publishDate;
    private String instoreDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getInstoreDate() {
        return instoreDate;
    }

    public void setInstoreDate(String instoreDate) {
        this.instoreDate = instoreDate;
    }
}
