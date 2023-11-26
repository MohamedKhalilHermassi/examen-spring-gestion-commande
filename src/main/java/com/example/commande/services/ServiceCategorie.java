package com.example.commande.services;

import com.example.commande.entities.Categorie;
import com.example.commande.repositories.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceCategorie implements IServiceCategorie{
    CategorieRepository categorieRepository;
    @Override
    public void ajouterCategorie(Categorie cat) {
        categorieRepository.save(cat);

    }
    public List<String> getAllCategories()
    {
        List<Categorie> categories =  categorieRepository.findAll();
        List<String> nomCategories = new ArrayList<>();
        categories.stream().forEach(
                categorie ->  nomCategories.add(categorie.getNomcat())
        );
        return nomCategories;
    }
}
