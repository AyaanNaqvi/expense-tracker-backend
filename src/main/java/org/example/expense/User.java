package org.example.expense;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Entity
public class User{
    @Id
    @GeneratedValue
    private long id;

    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    public User(){}
        public long getId   () {
            return id;
        }
        public String getUsername(){
        return username;
        }
        public void setUsername(String name){
        this.username=name;
    }
    public String  getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }




}
