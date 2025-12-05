/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author jerem
 */
public class Magazine extends Article {
    String ID_ISSN;
    String périodicité;
    LocalDate datePublication;

    public Magazine(String ID_ISSN, String périodicité, LocalDate datePublication, String description, double prixInit, int nbExemplaire) {
        super(description, prixInit, nbExemplaire);
        this.ID_ISSN = ID_ISSN;
        this.périodicité = périodicité;
        this.datePublication = datePublication;
    }
    
    public String toString(){
        return "ID_ISSN : "+ID_ISSN+"\n périodicite : "+périodicité+"\n date de publication : "+datePublication+"\n description : "+description+"\n prix : "+prixInit+"\n nbExemplaire : "+nbExemplaire;
    }
    
    public String getNumero(){
        return this.ID_ISSN;
    }
    
    public String getPériodicité() {
        return périodicité;
    }

    public LocalDate getDatePublication() {
        return datePublication;
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
            long jours = ChronoUnit.DAYS.between(this.datePublication, LocalDate.now());
    double prix = this.prixInit;

    if (this.périodicité.equalsIgnoreCase("hebdomadaire")) {
        long semaines = jours / 7;
        if (semaines > 4) return prix * 0.25;
        if (semaines > 2) return prix * 0.5;
    }

    if (this.périodicité.equalsIgnoreCase("mensuel")) {
        long mois = Period.between(this.datePublication, LocalDate.now()).toTotalMonths();
        if (mois > 4) return prix * 0.25;
        if (mois > 2) return prix * 0.5;
    }

    if (this.périodicité.equalsIgnoreCase("trimestriel")) {
        long trimestres = (jours / 90);
        if (trimestres > 4) return prix * 0.25;
        if (trimestres > 2) return prix * 0.5;
    }

    return prix;
    }

    @Override
    public double calculerPrix(LocalDate dateAchat) {
        long jours = ChronoUnit.DAYS.between(this.datePublication, dateAchat);
        double prix = this.prixInit;

        if (this.périodicité.equalsIgnoreCase("hebdomadaire")) {
            long semaines = jours / 7;
            if (semaines > 4) return prix * 0.25;
            if (semaines > 2) return prix * 0.5;
    }

        if (this.périodicité.equalsIgnoreCase("mensuel")) {
            long mois = Period.between(this.datePublication, dateAchat).toTotalMonths();
            if (mois > 4) return prix * 0.25;
            if (mois > 2) return prix * 0.5;
        }

        if (this.périodicité.equalsIgnoreCase("trimestriel")) {
            long trimestres = (jours / 90);
            if (trimestres > 4) return prix * 0.25;
            if (trimestres > 2) return prix * 0.5;
        }

        return prix;
    }
}
