package com.zyj.pojo;

import java.io.Serializable;

public class Gn implements Serializable {
    private int id;
    private String name;
    private String url;
    //需要的权限
    private String percode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode;
    }

    @Override
    public String toString() {
        return "Gn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", percode='" + percode + '\'' +
                '}';
    }
}
