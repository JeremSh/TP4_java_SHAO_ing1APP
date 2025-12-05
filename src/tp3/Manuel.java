/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author jerem
 */
public class Manuel extends Livre {
    String matière;
    String nivScolaire;

    public Manuel(String matière, String nivScolaire, String ID_ISBN, int nbPages, String description, double prixInit, int nbExemplaire) {
        super(ID_ISBN, nbPages, description, prixInit, nbExemplaire);
        this.matière = matière;
        this.nivScolaire = nivScolaire;
    }
    
    public String toString(){
        return "ID_ISBN : "+ID_ISBN+"\n matiere : "+matière+"\n niveau :"+nivScolaire+"\n description : "+description+"\n nombre de pages : "+nbPages+"\n prix : "+prixInit+"\n stock restant : "+nbExemplaire;
    }
    
    public String getMatière() {
        return matière;
    }

    public String getNivScolaire() {
        return nivScolaire;
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
    
}
