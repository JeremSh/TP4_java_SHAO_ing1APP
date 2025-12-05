/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

import java.time.Month;
import java.time.LocalDate;

/**
 *
 * @author jerem
 */
abstract class Article {
    String description;
    double prixInit;
    int nbExemplaire;

    public Article(String description, double prixInit, int nbExemplaire) {
        this.description = description;
        this.prixInit = prixInit;
        this.nbExemplaire = nbExemplaire;
    }
    
    public abstract String getNumero();
    public abstract boolean placerApres(Article autreArticle); 
    public abstract void ajouter(int quantite);
    public abstract void retirer(int quantite);
    public abstract double calculerPrix();
    public abstract double calculerPrix(LocalDate dateAchat);
    
}
