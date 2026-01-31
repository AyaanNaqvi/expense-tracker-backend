package org.example.expense;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Debtentity {
    @Id
    @GeneratedValue
    private int id;
@ManyToOne
    private User paidby;
@ManyToOne
    private User topay;

private double amount;
private long groupId;



public Debtentity(User paidby,User topay,double amount, long groupId) {
    this.paidby=paidby;
    this.topay=topay;
    this.amount=amount;
this.groupId=groupId;
}

    public long getId() {
        return id;
    }

    public User getPaidby() {
        return paidby;
    }

    public User getTouser() {
        return topay;
    }
    public long getagroupId() {
        return groupId;
    }

    public double getAmount() {
        return amount;
    }

    public Debtentity() {

    }

}

