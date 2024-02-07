package es.cifpcm.SerafinAlejandroMiAli.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId + '\'' +
                "userName=" + userName + '\'' +
                "password=" + password + '\'' +
                '}';
    }
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Groups group;
    public void setGroup(Groups group) {
        this.group = group;
    }

    public Groups getGroup() {
        return group;
    }
    @ManyToMany
    @JoinTable(
            name = "USER_GROUPS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID")
    )
    private Set<Groups> groups;
}
