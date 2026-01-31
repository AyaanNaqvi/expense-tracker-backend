package org.example.expense;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/debts")

public class Debtcontroller {
    private final Debtservice debtservice;
    public Debtcontroller(Debtservice debtservice){
        this.debtservice=debtservice;
    }
    @PostMapping
    public void addDebt(@RequestParam long paidbyId ,@RequestParam long touserId, @RequestParam double amount, @RequestParam long groupId){
      debtservice.createdebt(paidbyId,touserId,amount, groupId);
    }
    @GetMapping("/users/{userId}/debt")
    public List<Debtentity> getDebts(@RequestParam long paidbyId){
       return debtservice.getDebts(paidbyId);
    }
    @GetMapping("/users/{userId}/netbalance")
    public double netbalance(@RequestParam long userId ){
        return netbalance(userId);
    }
    @GetMapping("/users/{userId}/debtlist")
    public double debtlist(@PathVariable long userId ){
        return debtlist(userId);
    }
    @GetMapping
    public HashMap<String,Double> debtlist(){
        return debtservice.debtmapt();
    }
    @DeleteMapping
    public void deleteDebt(@RequestParam long groupId){
        debtservice.deletedebt(groupId);
    }

}
