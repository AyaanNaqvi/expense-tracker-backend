package org.example.expense;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Grprep extends JpaRepository<GroupMember, Long> {
        List<GroupMember> findByGroup(Groups group);
    void deleteByGroup_Id(long groupId);

    }

