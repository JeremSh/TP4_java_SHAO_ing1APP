/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp4;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author jerem
 */
public class Livre extends Article {
    String ID_ISBN;
    int nbPages;

    public Livre(String ID_ISBN, int nbPages, String description, double prixInit, int nbExemplaire) {
        super(description, prixInit, nbExemplaire);
        this.ID_ISBN = ID_ISBN;
        this.nbPages = nbPages;
    }
    
    public String toString(){
        return "ID_ISBN : "+ID_ISBN+"\n description : "+description+"\n nombre de pages : "+nbPages+"\n prix : "+prixInit+"\n stock restant : "+nbExemplaire;
    }
    
    public String getNumero(){
        return this.ID_ISBN;
    }
    
    public int getNbPages() {
        return nbPages;
    }

    public String getDescription() {
        return description;
    }

    public double getPrixInit() {
        return prixInit;
    }

    public int getNbExemplaire() {
        return nbExemplaire;
    }    

    @Override
    public boolean placerApres(Article autreArticle) {
        return this.getNumero().compareTo(autreArticle.getNumero()) > 0;
    }

    @Override
    public void ajouter(int quantite) {
        this.nbExemplaire = nbExemplaire + quantite;
    }

    @Override
    public void retirer(int quantite) {
        // vérifie si après calcule le nombre d'exemplaire sera inférieur a 0
        if(this.nbExemplaire - quantite < 0){
            this.nbExemplaire = 0;
            System.out.println("INFO : la quantité à retirer souhaiter étant supérieur au nombre d'exemplaire restatn le nombre d'exemplaire restant à était ramener a 0");
        }
        else{
            this.nbExemplaire = this.nbExemplaire - quantite;
        }
    }

    @Override
    public double calculerPrix() {
        return (LocalDate.now().getMonth() == Month.APRIL) ? this.prixInit * 0.5 : this.prixInit;
    }

    @Override
    public double calculerPrix(LocalDate dateAchat) {
        return (dateAchat.getMonth() == Month.APRIL) ? this.prixInit * 0.5 : this.prixInit;
    }
    
}
