package GLSIAGROUPE13.TP_JEE.repository;

import GLSIAGROUPE13.TP_JEE.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    @Query("SELECT t FROM Transaction t WHERE t.compte.compteId = :id")
    List<Transaction> findAllByCompteCompteId(@Param("id") Integer id);
}
