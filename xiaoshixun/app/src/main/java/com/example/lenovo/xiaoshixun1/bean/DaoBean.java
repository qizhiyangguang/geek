package com.example.lenovo.xiaoshixun1.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DaoBean {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String img;
    @Property
    private String url;
    @Property
    private String title;
    @Generated(hash = 1135518384)
    public DaoBean(Long id, String img, String url, String title) {
        this.id = id;
        this.img = img;
        this.url = url;
        this.title = title;
    }
    @Generated(hash = 405743142)
    public DaoBean() {
    }

    public DaoBean(String img, String url, String title) {
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
