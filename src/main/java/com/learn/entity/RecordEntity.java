package com.learn.entity;

        import java.io.Serializable;
        import java.util.Date;
        import com.learn.service.*;



/**
 * 考勤信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-18 23:10:05
 */
public class RecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;

            //
                    private Long id;
        
            //考勤日期
                    private String day;
        
            //考勤人
                    private Long user;

            private SysUserEntity sysUserEntity;

            public SysUserEntity getSysUserEntity() {
                return sysUserEntity;
            }

            public void setSysUserEntity(SysUserEntity sysUserEntity) {
                this.sysUserEntity = sysUserEntity;
            }

        
            //到勤情况
                    private String state;
        
            //备注
                    private String remark;
        
            //type
                    private String type;
        
            //添加时间
                    private Date gmttime =new  Date();
        
    
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
         * 设置：考勤日期
         */
        public void setDay(String day) {
            this.day = day;
        }

        /**
         * 获取：考勤日期
         */
        public String getDay() {
            return day;
        }
            /**
         * 设置：考勤人
         */
        public void setUser(Long user) {
            this.user = user;
        }

        /**
         * 获取：考勤人
         */
        public Long getUser() {
            return user;
        }
            /**
         * 设置：到勤情况
         */
        public void setState(String state) {
            this.state = state;
        }

        /**
         * 获取：到勤情况
         */
        public String getState() {
            return state;
        }
            /**
         * 设置：备注
         */
        public void setRemark(String remark) {
            this.remark = remark;
        }

        /**
         * 获取：备注
         */
        public String getRemark() {
            return remark;
        }
            /**
         * 设置：type
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * 获取：type
         */
        public String getType() {
            return type;
        }
            /**
         * 设置：添加时间
         */
        public void setGmttime(Date gmttime) {
            this.gmttime = gmttime;
        }

        /**
         * 获取：添加时间
         */
        public Date getGmttime() {
            return gmttime;
        }
    }
