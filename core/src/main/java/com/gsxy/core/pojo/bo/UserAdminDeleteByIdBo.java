package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 *  2023-10-24
 *  通过id删除useradmin
 */
public class UserAdminDeleteByIdBo implements Serializable {

    private String token;
    private Long id;

    public UserAdminDeleteByIdBo() {
    }

    public UserAdminDeleteByIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserAdminDeleteByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
