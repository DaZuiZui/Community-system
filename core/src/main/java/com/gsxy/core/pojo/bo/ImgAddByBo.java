package com.gsxy.core.pojo.bo;

import com.gsxy.core.domain.Img;

import java.io.Serializable;

/**
 *  2023-10-23
 *  增加img
 */
public class ImgAddByBo implements Serializable {

    private String token;
    private Img img;

    public ImgAddByBo() {
    }

    public ImgAddByBo(String token, Img img) {
        this.token = token;
        this.img = img;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "ImgAddByBo{" +
                "token='" + token + '\'' +
                ", img=" + img +
                '}';
    }
}
