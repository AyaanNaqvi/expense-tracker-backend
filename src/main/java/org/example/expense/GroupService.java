package org.example.expense;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GroupService {
    public GroupsRep groupsrep;
    private final Grprep grprep;
    private final expenserepository expenserepository;
    private final Expensesplitrepos expensesplitrepos;
    private final Debtservice debtservice;



    public GroupService(GroupsRep groupsrep,Grprep grprep, expenserepository expenserepository, Expensesplitrepos expensesplitrepos
    , Debtservice debtservice) {
        this.grprep = grprep;
        this.expenserepository = expenserepository;
        this.expensesplitrepos = expensesplitrepos;
this.debtservice = debtservice;


        this.groupsrep = groupsrep;

    }
    public Groups addgroups(Groups  groups) {
       return groupsrep.save(groups);
    }

@Transactional
public void deleteGroups(long groupId) {
    System.out.println("deleted " + groupId);
    expensesplitrepos.deleteByExpense_Groups_Id(groupId);
    expenserepository.deleteByGroups_Id(groupId);
    grprep.deleteByGroup_Id(groupId);
    debtservice.deletedebt(groupId);
    groupsrep.deleteById(groupId);


    groupsrep.deleteById(groupId);
}


    public List<Groups> getgroups(){
        return groupsrep.findAll();
    }
}
