package cn.panjin.shenxianbms.base.user.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseUser implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.login_name
     *
     * @mbggenerated
     */
    private String loginName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.locked
     *
     * @mbggenerated
     */
    private Boolean locked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.state_type
     *
     * @mbggenerated
     */
    private Boolean stateType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.real_name
     *
     * @mbggenerated
     */
    private String realName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.phone
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.sex
     *
     * @mbggenerated
     */
    private Boolean sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.creater_id
     *
     * @mbggenerated
     */
    private Long createrId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.creater_name
     *
     * @mbggenerated
     */
    private String createrName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.updater_id
     *
     * @mbggenerated
     */
    private Long updaterId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.updater_name
     *
     * @mbggenerated
     */
    private String updaterName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_user.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table base_user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.id
     *
     * @return the value of base_user.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.id
     *
     * @param id the value for base_user.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.login_name
     *
     * @return the value of base_user.login_name
     *
     * @mbggenerated
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.login_name
     *
     * @param loginName the value for base_user.login_name
     *
     * @mbggenerated
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.password
     *
     * @return the value of base_user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.password
     *
     * @param password the value for base_user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.locked
     *
     * @return the value of base_user.locked
     *
     * @mbggenerated
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.locked
     *
     * @param locked the value for base_user.locked
     *
     * @mbggenerated
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.state_type
     *
     * @return the value of base_user.state_type
     *
     * @mbggenerated
     */
    public Boolean getStateType() {
        return stateType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.state_type
     *
     * @param stateType the value for base_user.state_type
     *
     * @mbggenerated
     */
    public void setStateType(Boolean stateType) {
        this.stateType = stateType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.real_name
     *
     * @return the value of base_user.real_name
     *
     * @mbggenerated
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.real_name
     *
     * @param realName the value for base_user.real_name
     *
     * @mbggenerated
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.phone
     *
     * @return the value of base_user.phone
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.phone
     *
     * @param phone the value for base_user.phone
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.sex
     *
     * @return the value of base_user.sex
     *
     * @mbggenerated
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.sex
     *
     * @param sex the value for base_user.sex
     *
     * @mbggenerated
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.email
     *
     * @return the value of base_user.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.email
     *
     * @param email the value for base_user.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.description
     *
     * @return the value of base_user.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.description
     *
     * @param description the value for base_user.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.creater_id
     *
     * @return the value of base_user.creater_id
     *
     * @mbggenerated
     */
    public Long getCreaterId() {
        return createrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.creater_id
     *
     * @param createrId the value for base_user.creater_id
     *
     * @mbggenerated
     */
    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.creater_name
     *
     * @return the value of base_user.creater_name
     *
     * @mbggenerated
     */
    public String getCreaterName() {
        return createrName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.creater_name
     *
     * @param createrName the value for base_user.creater_name
     *
     * @mbggenerated
     */
    public void setCreaterName(String createrName) {
        this.createrName = createrName == null ? null : createrName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.create_time
     *
     * @return the value of base_user.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.create_time
     *
     * @param createTime the value for base_user.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.updater_id
     *
     * @return the value of base_user.updater_id
     *
     * @mbggenerated
     */
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.updater_id
     *
     * @param updaterId the value for base_user.updater_id
     *
     * @mbggenerated
     */
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.updater_name
     *
     * @return the value of base_user.updater_name
     *
     * @mbggenerated
     */
    public String getUpdaterName() {
        return updaterName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.updater_name
     *
     * @param updaterName the value for base_user.updater_name
     *
     * @mbggenerated
     */
    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName == null ? null : updaterName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_user.update_time
     *
     * @return the value of base_user.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_user.update_time
     *
     * @param updateTime the value for base_user.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}