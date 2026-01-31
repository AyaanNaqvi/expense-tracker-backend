package org.example.expense;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class expenseEntity {
    @Id
    @GeneratedValue
    private long id;
    private double ExpenseValue;
    @ManyToOne
    private User user;
   @ManyToOne
    private Groups groups;
    public expenseEntity() {
    }
    public expenseEntity(Groups group, double ExpenseValue, User user) {
        this.ExpenseValue = ExpenseValue;
        this.user = user;
        this.groups = group;
    }
    public double getExpenseValue() {
   return ExpenseValue;
    }
    public long getId() {
        return id;
    }
    public Groups getGroup(){
        return groups;
    }
    public void setExpenseValue(long ExpenseValue) {
        this.ExpenseValue = ExpenseValue;
    }
    public User GetUser(){ return user;}
}
