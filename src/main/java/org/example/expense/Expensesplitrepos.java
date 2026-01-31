package org.example.expense;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Expensesplitrepos extends JpaRepository<Expensesplit,Long> {
    void deleteByExpense_Groups_Id(Long groupId);
}
