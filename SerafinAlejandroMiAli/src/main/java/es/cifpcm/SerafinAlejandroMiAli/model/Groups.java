package es.cifpcm.SerafinAlejandroMiAli.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "groups")
public class Groups implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "group_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    @Column(name = "description")
    private String description;

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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "groupId=" + groupId + '\'' +
                "groupName=" + groupName + '\'' +
                "description=" + description + '\'' +
                '}';
    }
}
