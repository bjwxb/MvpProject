package com.wxb.mvp.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wuxiaobo on 2018/1/29.
 * 用户信息
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String account;//account
    private String nickname;
    private String member_nickname;
    private String mobile;//手机号
    private String headportraits;//头像url
    private String member_name;
    private String hx_login;//环信手机号
    private String member_avatar;
    private String key;
    @Generated(hash = 1261394312)
    public User(Long id, String account, String nickname, String member_nickname,
            String mobile, String headportraits, String member_name,
            String hx_login, String member_avatar, String key) {
        this.id = id;
        this.account = account;
        this.nickname = nickname;
        this.member_nickname = member_nickname;
        this.mobile = mobile;
        this.headportraits = headportraits;
        this.member_name = member_name;
        this.hx_login = hx_login;
        this.member_avatar = member_avatar;
        this.key = key;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getMember_nickname() {
        return this.member_nickname;
    }
    public void setMember_nickname(String member_nickname) {
        this.member_nickname = member_nickname;
    }
    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getHeadportraits() {
        return this.headportraits;
    }
    public void setHeadportraits(String headportraits) {
        this.headportraits = headportraits;
    }
    public String getMember_name() {
        return this.member_name;
    }
    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }
    public String getHx_login() {
        return this.hx_login;
    }
    public void setHx_login(String hx_login) {
        this.hx_login = hx_login;
    }
    public String getMember_avatar() {
        return this.member_avatar;
    }
    public void setMember_avatar(String member_avatar) {
        this.member_avatar = member_avatar;
    }
    public String getKey() {
        return this.key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
