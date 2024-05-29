package GLSIAGROUPE13.TP_JEE.repository;

import GLSIAGROUPE13.TP_JEE.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Optional<Client> findByEmail(String email);


}
