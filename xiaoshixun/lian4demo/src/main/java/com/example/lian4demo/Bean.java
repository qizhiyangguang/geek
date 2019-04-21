package com.example.lian4demo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Bean {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String img;
    @Property
    private String url;
    @Property
    private String title;
    @Generated(hash = 1776945835)
    public Bean(Long id, String img, String url, String title) {
        this.id = id;
        this.img = img;
        this.url = url;
        this.title = title;
    }
    @Generated(hash = 80546095)
    public Bean() {
    }

    public Bean(String img, String url, String title) {
        this.img = img;
        this.url = url;
        this.title = title;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
