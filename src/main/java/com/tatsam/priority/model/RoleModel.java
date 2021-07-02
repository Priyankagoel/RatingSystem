package com.tatsam.priority.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user_role")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(targetEntity = UserModel.class, mappedBy = "role", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private Set<UserModel> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserModel> getUsers() {
        return users;
    }

    public void setUsers(Set<UserModel> users) {
        this.users = users;
    }
}
