package org.example.expense;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.util.List;

@Entity
@Table(name = "expense_group")
public class Groups {
    @Id
    @GeneratedValue
    private long Id;

    private String name;
public Groups() {}

    public String getName(){
    return name;
    }
    public void setName(String name){
        this.name=name;

    }
    public long getId(){
        return Id;
    }


}
