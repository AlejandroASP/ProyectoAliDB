package es.cifpcm.SerafinAlejandroMiAli.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "membership")
public class Membership implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "group_id", nullable = false)
    private Integer groupId;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "userName=" + userName + '\'' +
                "groupId=" + groupId + '\'' +
                "groupName=" + groupName + '\'' +
                '}';
    }
}
