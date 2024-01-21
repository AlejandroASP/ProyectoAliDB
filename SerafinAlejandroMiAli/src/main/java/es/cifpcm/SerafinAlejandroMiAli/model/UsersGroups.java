package es.cifpcm.SerafinAlejandroMiAli.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "users_groups")
public class UsersGroups implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "group_id", nullable = false)
    private Integer groupId;

    @Id
    @Column(name = "user_name", nullable = false)
    private String userName;

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "UsersGroups{" +
                "groupId=" + groupId + '\'' +
                "userName=" + userName + '\'' +
                '}';
    }
}
