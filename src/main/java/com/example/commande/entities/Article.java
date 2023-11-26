package com.example.commande.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idart;
    private String nom;
    private Integer prix;
    private String image;
    @ManyToOne
    private Commande commande;
    @ManyToOne
    private Categorie categorie;
}
