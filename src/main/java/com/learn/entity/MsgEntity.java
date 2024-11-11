package com.learn.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 站内消息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-13 14:31:20
 */
public class MsgEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;

    //消息内容
    private String content;

    //接收人
    private Long user;

    private SysUserEntity sysUserEntity;

    public SysUserEntity getSysUserEntity() {
        return sysUserEntity;
    }

    public void setSysUserEntity(SysUserEntity sysUserEntity) {
        this.sysUserEntity = sysUserEntity;
    }


    //发送时间
    private Date gmttime = new Date();

    //阅读状态
    private String state;


    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：消息内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置：接收人
     */
    public void setUser(Long user) {
        this.user = user;
    }

    /**
     * 获取：接收人
     */
    public Long getUser() {
        return user;
    }

    /**
     * 设置：发送时间
     */
    public void setGmttime(Date gmttime) {
        this.gmttime = gmttime;
    }

    /**
     * 获取：发送时间
     */
    public Date getGmttime() {
        return gmttime;
    }

    /**
     * 设置：阅读状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取：阅读状态
     */
    public String getState() {
        return state;
    }
}
