package org.example.expense;

import jakarta.persistence.*;

@Entity
public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    public User user;
    @ManyToOne
    public Groups group;

    public GroupMember() {
    }

    public GroupMember(User user, Groups group) {
        this.user = user;
        this.group = group;
    }

    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public Groups getGroup() {
        return group;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setGroup(Groups group) {
        this.group = group;
    }

}
