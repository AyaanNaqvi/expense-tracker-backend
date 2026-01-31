package org.example.expense;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface expenserepository extends JpaRepository<expenseEntity ,Long> {
    void deleteByGroups_Id(long groupId);
   List<expenseEntity> findByUser_Id(long userId);
}
