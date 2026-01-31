package org.example.expense;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Debtrepository extends JpaRepository<Debtentity, Long> {


    List<Debtentity> findByPaidbyId(long paidbyId);
    List<Debtentity> findByTouserId(long userId);
    void deleteByGroupId(long groupId);

}
