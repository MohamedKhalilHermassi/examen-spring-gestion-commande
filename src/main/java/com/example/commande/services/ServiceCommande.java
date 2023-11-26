package com.example.commande.services;

import com.example.commande.entities.Commande;
import com.example.commande.repositories.CommandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceCommande implements IServiceCommande {
    CommandeRepository commandeRepository;
    @Override
    public void ajouterCommande(Commande commande) {
        commandeRepository.save(commande);

    }
}
