package com.jerry.myapp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @since   Jul 24, 2017 9:08:01 PM
 * @author  HJ
 * @return
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String realName;
    
    private String userName;

    private String password;

    private Date createDate;

    private Boolean valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
