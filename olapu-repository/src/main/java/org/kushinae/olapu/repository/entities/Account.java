package org.kushinae.olapu.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 用户头像
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 用户昵称
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 用户密码 md5加密存储
     */
    @Column(name = "password")
    private String password;

    /**
     * 用户唯一uid
     */
    @Column(name = "uid")
    private String uid;

    /**
     * 数据创建时间
     */
    @Column(name = "create_at")
    private Date createAt;

    /**
     * 数据编辑时间
     */
    @Column(name = "modified_at")
    private Date modifiedAt;

    /**
     * 数据是否删除
     */
    @Column(name = "deleted")
    private Boolean deleted;

}
