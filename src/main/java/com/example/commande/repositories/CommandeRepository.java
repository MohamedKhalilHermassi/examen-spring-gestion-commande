package com.example.commande.repositories;

import com.example.commande.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Integer> {
}
