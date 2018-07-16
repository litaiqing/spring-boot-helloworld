package cn.com.analysys.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/11 13:55
 * @since JDK 1.8
 */
@Entity
@Table(name = "base_user_info")
public class BaseUserInfo implements java.io.Serializable  {

    private static final long serialVersionUID = 2435627654781054867L;


    @Id
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String telephone;

    @Column
    private String status;

    @Column(name = "create_time")
    private Date createTime;

    @Column
    private String comment;

    @Column
    private String host;

    @Column(name = "activation_status")
    private Integer activationStatus;

    @Column(name = "activation_telephone")
    private Long activationTelephone;

    @Column(name = "sys_type")
    private Integer sysType;

    @Column(name = "user_type")
    private Integer userType;

    @Column
    private String nickname;

    @Column
    private String country;

    @Column(name = "map_id")
    private BigInteger mapId;

    @Column
    private String salt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(Integer activationStatus) {
        this.activationStatus = activationStatus;
    }

    public Long getActivationTelephone() {
        return activationTelephone;
    }

    public void setActivationTelephone(Long activationTelephone) {
        this.activationTelephone = activationTelephone;
    }

    public Integer getSysType() {
        return sysType;
    }

    public void setSysType(Integer sysType) {
        this.sysType = sysType;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigInteger getMapId() {
        return mapId;
    }

    public void setMapId(BigInteger mapId) {
        this.mapId = mapId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

}
