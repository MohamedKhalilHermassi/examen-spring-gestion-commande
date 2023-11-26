package com.example.commande.repositories;

import com.example.commande.entities.Article;
import com.example.commande.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {
     List<Article> findAllByCategorie(Categorie type);
}
