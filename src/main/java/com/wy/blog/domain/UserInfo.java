package com.wy.blog.domain;

import com.wy.blog.utils.DateUtils;

import java.util.Date;

public class UserInfo {
    private int id;
    private String nickName;
    private String userName;
    private String password;
    private String profilePhoto;
    private String email;
    private String phoneNum;
    private Date registerTime;
    private String registerTimeStr;
    private Date birthday;
    private String birthdayStr;
    private int age;
    private Integer status;     // 0表示博主，1表示管理员，2表示普通用户
    private String statusStr;
    private String userDesc;    //用户简介
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterTimeStr() {
        if(registerTime != null){
            registerTimeStr = DateUtils.dateToString(registerTime,"yyyy-MM-dd HH:mm:ss");
        }
        return registerTimeStr;
    }

    public void setRegisterTimeStr(String registerTimeStr) {
        this.registerTimeStr = registerTimeStr;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public String getBirthdayStr() {
        if(birthday != null){
            birthdayStr = DateUtils.dateToString(birthday,"yyyy-MM-dd HH:mm:ss");
        }
        return birthdayStr;
}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        if(status != null){
            if(status == 0){
                statusStr = "博主";
            }else if(status == 1){
                statusStr = "管理员";
            }else{
                statusStr = "普通用户";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", registerTime=" + registerTime +
                ", registerTimeStr='" + registerTimeStr + '\'' +
                ", birthday=" + birthday +
                ", birthdayStr=" + birthdayStr +
                ", age=" + age +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", userDesc='" + userDesc + '\'' +
                '}';
    }
}
