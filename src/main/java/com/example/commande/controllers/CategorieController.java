package com.example.commande.controllers;

import com.example.commande.entities.Categorie;
import com.example.commande.services.ServiceCategorie;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("categorie")
public class CategorieController {
    ServiceCategorie serviceCategorie;
    @PostMapping("add")
    public void addCategorie(@RequestBody Categorie categorie)
    {
        serviceCategorie.ajouterCategorie(categorie);
    }
    @GetMapping("all")
    public List<String> getAllCategoriesNames()
    {
       return serviceCategorie.getAllCategories();
    }
}
