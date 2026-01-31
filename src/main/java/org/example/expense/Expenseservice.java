package org.example.expense;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Expenseservice {

    private final expenserepository expenseRepository;
    private final Expensesplitrepos expenseSplitRepository;
    private final Grprep grprep;
    private final UserRep userrepo;
    private final GroupsRep groupsrep;
    private final Debtservice debtservice;

    public Expenseservice(
            expenserepository expenseRepository,
            Expensesplitrepos expenseSplitRepository,
            Grprep grprep,
            UserRep userrepo,
            GroupsRep groupsrep,
            Debtservice debtservice) {
        this.expenseRepository = expenseRepository;
        this.expenseSplitRepository = expenseSplitRepository;
        this.grprep = grprep;
        this.userrepo = userrepo;
        this.groupsrep = groupsrep;
        this.debtservice = debtservice;
    }

    public expenseEntity addExpense(long groupId, long userId, double amount) {

        User user = userrepo.findById(userId).orElseThrow();
        Groups group = groupsrep.findById(groupId).orElseThrow();


        expenseEntity expense = new expenseEntity(group, amount, user  );
        expenseEntity savedExpense = expenseRepository.save(expense);

        System.out.println("expense added in :"+expense.getGroup().getName());


        List<GroupMember> members = grprep.findByGroup(group);

        double splitAmount = amount / members.size();
        User paidby= members.get(0).getUser();
        for (GroupMember gm : members) {
            User member= gm.getUser();
            Expensesplit split = new Expensesplit(
                    savedExpense,
                    gm.getUser(),
                    splitAmount
            );
            expenseSplitRepository.save(split);




                if(member.getId()!=(paidby.getId())){
                    debtservice.createdebt(paidby.getId(),member.getId(),splitAmount,groupId);
                }


System.out.println(split.getUser().getUsername());
        }

        System.out.println("paid by "+paidby.getUsername()+ paidby.getId());
        System.out.println("amount per person:"+splitAmount);
        return savedExpense;

    }

}
