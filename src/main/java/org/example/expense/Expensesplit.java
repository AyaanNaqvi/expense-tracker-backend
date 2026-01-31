package org.example.expense;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Expensesplit {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User user;
@ManyToOne
    private expenseEntity expense;

private double amountowed;

    public Expensesplit(expenseEntity expense, User user, double amountOwed) {
        this.expense = expense;
        this.user = user;
        this.amountowed = amountOwed;
    }
public Expensesplit () {}
public expenseEntity getExpense(){
    return expense;
}
public long getId() {
    return id;
}
public User getUser() {
    return user;
}

public double getAmountowed() {
    return amountowed;
}

}

