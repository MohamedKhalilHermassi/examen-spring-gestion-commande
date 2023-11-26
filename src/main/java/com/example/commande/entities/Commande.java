package com.example.commande.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcmd;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "commande",  fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<Article> articles;

}
