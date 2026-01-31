package org.example.expense;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Debtservice {
    private final Debtrepository debtrepository;
    private final UserRep userrep;
    public Debtservice(Debtrepository debtrepository, UserRep userrep) {
        this.debtrepository = debtrepository;
        this.userrep = userrep;

    }

    public void createdebt(long paidbyId, long topayId, double amount, long groupId){
        User paidby = userrep.findById(paidbyId).orElseThrow();
        User topay = userrep.findById(topayId).orElseThrow();
        Debtentity debt= new Debtentity(paidby,topay,amount, groupId);
        debtrepository.save(debt);
    }
    public List<Debtentity> getDebts(@RequestParam long paidbyId){
        return debtrepository.findByPaidbyId(paidbyId);
    }
    public List<Debtentity>debtsperuser(@RequestParam long userId){
        return debtrepository.findByTouserId(userId);
    }
    public double getnetbalance(long userId){
        double amountpaid=0;
        double amountowe=0;
        List<Debtentity>paidlist=debtrepository.findByPaidbyId(userId);
        List<Debtentity>oweslist=debtrepository.findByTouserId(userId);
        for(Debtentity debts: paidlist){
            amountpaid+=debts.getAmount();
            }
        for(Debtentity debts: oweslist){
            amountowe+=debts.getAmount();
        }

 double netbalance=amountpaid-amountowe;
        return netbalance;
    }
    public Map getdebtmap(long userID){
        Map<Long,Double>balances= new HashMap<>();
        List<Debtentity>paidlist=debtrepository.findByPaidbyId(userID);
        List<Debtentity>oweslist=debtrepository.findByTouserId(userID);
        for(Debtentity debts: paidlist){
            long touserid= debts.getPaidby().getId();
            balances.put(touserid,balances.getOrDefault(touserid,0.0)+debts.getAmount());
        }
        for(Debtentity debts: oweslist){
            long paidbyid= debts.getTouser().getId();
            balances.put(paidbyid,balances.getOrDefault(paidbyid,0.0)-debts.getAmount());
        }
return  balances;
    }
    public HashMap<String,Double> debtmapt(){
        List<Debtentity>debtlist = debtrepository.findAll();


        HashMap<String,Double> balancemap = new HashMap<>();
        for( Debtentity debt: debtlist){
            long paidbyid=debt.getPaidby().getId();
            long touserid= debt.getTouser().getId();
double actualamount=0;
            double amount=debt.getAmount();
            long firstuserid= Math.min(paidbyid,touserid);
            long seconduserid= Math.max(paidbyid,touserid);
            String key= firstuserid+"-"+seconduserid;
            if(touserid==firstuserid){
                actualamount+=amount;
            }
            else {
                actualamount-=amount;
            }

balancemap.put(
        key,
        balancemap.getOrDefault(key,0.0)+actualamount
);
        }
        return balancemap;
    }
    @Transactional
    public void deletedebt(long groupId){
        debtrepository.deleteByGroupId(groupId);
        System.out.println("Deleting debts for groupId: " + groupId);

    }



}
