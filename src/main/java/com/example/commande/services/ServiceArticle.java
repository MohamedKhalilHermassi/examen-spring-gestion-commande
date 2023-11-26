package com.example.commande.services;

import com.example.commande.entities.Article;
import com.example.commande.entities.Categorie;
import com.example.commande.entities.Commande;
import com.example.commande.entities.Status;
import com.example.commande.repositories.ArticleRepository;
import com.example.commande.repositories.CategorieRepository;
import com.example.commande.repositories.CommandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServiceArticle implements IServiceArticle{
    ArticleRepository articleRepository;
    CategorieRepository categorieRepository;
    CommandeRepository commandeRepository;
    @Override
    public void ajouterArticle(Article article) {
        articleRepository.save(article);

    }

    public void affecterArtCat(Integer idcat, Integer idart)
    {
        Categorie categorie = categorieRepository.findById(idcat).get();
        Article article = articleRepository.findById(idart).get();
        //affecter article à une catégorie
        List<Article> list_articles = categorie.getArticles();
        list_articles.add(article);
        categorie.setArticles(list_articles);
        //affecter une catégorie à un article
        article.setCategorie(categorie);
        categorieRepository.save(categorie);
        articleRepository.save(article);


    }

    public void affecterArtCmd(Integer idcmd, Integer idart)
    {
        Commande commande = commandeRepository.findById(idcmd).get();
        Article article = articleRepository.findById(idart).get();
        // affetcer commande à un article
        article.setCommande(commande);
        // affecter article à une commande
        List<Article> liste_article = commande.getArticles();
        liste_article.add(article);
        commande.setArticles(liste_article);
        commande.setStatus(Status.COMMANDE);
        articleRepository.save(article);
        commandeRepository.save(commande);

    }

    public List<String> getAllArticleNamesByCategorie(Integer idcat) {
        Optional<Categorie> categorieOptional = categorieRepository.findById(idcat);
        if (categorieOptional.isPresent()) {
            Categorie categorie = categorieOptional.get();

            List<Article> articles = articleRepository.findAllByCategorie(categorie);
            return articles.stream()
                    .map(Article::getNom)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList(); // Return an empty list if the category is not found
        }
    }

}
