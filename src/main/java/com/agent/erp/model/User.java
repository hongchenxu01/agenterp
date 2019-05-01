package com.agent.erp.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	
    private String id;

    private String name;

    private String password;

    private Integer gender;

    private String idNo;

    private String phone;

    private String email;

    private Date createTime;

    private Date updateTime;

    private Date delTime;

    private Integer isDel;

    
}