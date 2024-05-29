package GLSIAGROUPE13.TP_JEE.controller;


import GLSIAGROUPE13.TP_JEE.dto.TransactionDto;
import GLSIAGROUPE13.TP_JEE.entity.Transaction;
import GLSIAGROUPE13.TP_JEE.repository.TransactionRepository;
import GLSIAGROUPE13.TP_JEE.service.ImpService.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ega/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/")
    public Transaction saveTransaction(@RequestBody Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }
    @GetMapping("/All")
    public List<TransactionDto> showAllTransaction(){
        return transactionService.showAllTransaction();
    }
    @GetMapping("/One")
    public TransactionDto getOneTransaction(int id){
    return transactionService.getOneTransaction(id);
    }

    @DeleteMapping("/Del")
    public void deleteTransaction(int id) {
         transactionService.deleteTransaction(id);
    }

    @PostMapping("/Dep")
    public int depot(@RequestBody Transaction transaction){
         transactionService.depot(transaction);
         return 0;
    }
    @PostMapping("/Ret")
    public int retrait(@RequestBody Transaction transaction){
         transactionService.retrait(transaction);
        return 0;
    }
    @PostMapping("/Vir")
    public int virement(@RequestBody Transaction transaction){
        return transactionService.virement(transaction);
    }
    @GetMapping("/All/{id}")
    public List<TransactionDto> getAllBycompteId(@PathVariable("id") Integer id){
        return transactionService.getAllByCompteId(id);
    }

}
