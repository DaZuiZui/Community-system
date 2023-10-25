package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.UserAdmin;

import java.io.Serializable;

/**
 *  2023-10-24
 *  更新管理员信息
 */
public class UserAdminUpdateByIdBo implements Serializable {

    private String token;
    private UserAdmin userAdmin;

    public UserAdminUpdateByIdBo() {
    }

    public UserAdminUpdateByIdBo(String token, UserAdmin userAdmin) {
        this.token = token;
        this.userAdmin = userAdmin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserAdmin getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(UserAdmin userAdmin) {
        this.userAdmin = userAdmin;
    }

    @Override
    public String toString() {
        return "UserAdminUpdateByIdBo{" +
                "token='" + token + '\'' +
                ", userAdmin=" + userAdmin +
                '}';
    }
}