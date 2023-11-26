package com.example.commande.controllers;

import com.example.commande.entities.Article;
import com.example.commande.services.ServiceArticle;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("article")
public class ArticleController {
    ServiceArticle serviceArticle;
    @PostMapping("add")
    public void ajouterArticle(@RequestBody Article article)
    {
        serviceArticle.ajouterArticle(article);
    }

    @PutMapping("affecterArticleCategorie/{idcat}/{idart}")
    public void affecterArticleCategorie(@PathVariable Integer idcat,@PathVariable Integer idart)
    {
        serviceArticle.affecterArtCat(idcat,idart);
    }
    @PutMapping("affecterArticleCommande/{idcmd}/{idart}")
    public void affecterArticleCommande(@PathVariable Integer idcmd,@PathVariable Integer idart)
    {
        serviceArticle.affecterArtCmd(idcmd,idart);
    }

    @GetMapping("nameCategorie/{idcat}")
    public List<String> afficherArticlebyCategorieContain(@PathVariable Integer idcat)
    {
     return    serviceArticle.getAllArticleNamesByCategorie(idcat);
    }
}
