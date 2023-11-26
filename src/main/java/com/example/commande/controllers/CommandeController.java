package com.example.commande.controllers;

import com.example.commande.entities.Commande;
import com.example.commande.services.ServiceCommande;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("commande")
public class CommandeController {
    ServiceCommande serviceCommande;
    @PostMapping("add")
    public void ajouterCommande(@RequestBody Commande commande)
    {
        serviceCommande.ajouterCommande(commande);
    }

}
