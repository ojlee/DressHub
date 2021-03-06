package com.newoneplus.dresshub.Model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String password;
    private String name;
    private String email;
    private int userType;
    private String address;
    private String phoneNumber;
    private String nickname;
    private String introduce;
    private boolean openPrivateInfo;
    private boolean certification;
    private Date resisterDate;


}
