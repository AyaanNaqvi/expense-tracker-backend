package org.example.expense;

import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
    @RequestMapping("/groups")
public class ExpenseController {
    private final Expenseservice expenseservice;
    public ExpenseController(Expenseservice expenseservice) {
        this.expenseservice = expenseservice;
    }
    @PostMapping("/{groupId}/expenses")
    public expenseEntity createexpense (

    @PathVariable
            Long groupId,
    @RequestParam Long userId,
    @RequestParam double amount) {

      return  expenseservice.addExpense(groupId, userId, amount);

    }
}
