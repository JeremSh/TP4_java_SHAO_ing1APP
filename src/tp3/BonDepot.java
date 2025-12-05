/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

import java.time.LocalDate;

/**
 *
 * @author jerem
 */
public class BonDepot {
    //constante du nombre max de ligne par bon
    final static int MAX_LIGNE_DEPOT = 5;
    private int ID;
    //compteur automatique pour le numéro d'identifiant
    private static int CountID = 100000;
    // le numéro de téléphone du dépositaire, on la mis en String car il se peut qu'on veillent mettre le numéro sous format +XXX
    private String numTel;
    private LocalDate dateDepot;
    // Par défaut à 0 car il n'y a rien à la création
    private int nbArticleDepot = 0;
    // le tableau avec n ligne de dépot max
    private LigneDepot [] LignesDep = new LigneDepot[MAX_LIGNE_DEPOT];
    
    BonDepot(String numTelephone){
        numTel = numTelephone;
        dateDepot = LocalDate.now();
        ID = CountID;
        CountID++;
    }
    
    BonDepot(String numTelephone, LocalDate date){
        numTel = numTelephone;
        dateDepot = date;
        ID = CountID;
        CountID++;
    }
    
    // constructur si jamais le numéro de telephone est donner comme int
    BonDepot(int numTelephone){
        numTel = ""+numTelephone;
        dateDepot = LocalDate.now();
        ID = CountID;
        CountID++;
    }
    
    BonDepot(int numTelephone, LocalDate date){
        numTel = ""+numTelephone;
        dateDepot = date;
        ID = CountID;
        CountID++;
    }
    
    public void affiche(){
        System.out.println("Bon de depot N°"+ID);
        System.out.println("Numero du depositaire : "+numTel);
        System.out.println("Date d'emission du bon : "+dateDepot);
        System.out.println("Ligne de depot :");
        if(nbArticleDepot > 0){
            for (LigneDepot ligne : LignesDep){
                if(ligne != null){
                    System.out.println(ligne.toString());
                }
            }
        }
        else {
            System.out.println("Il n'y a pas encore de ligne dans ce bon");
        }
        System.out.println();
    }
    
    public String toString(){
        String retour = "Bon de depot N°"+ID+"\n numero du depositaire : "+numTel+"\n date emission du bon : "+dateDepot+"\n ligne de depot :\n";
        for (LigneDepot ligne:LignesDep){
            retour += "\n"+ligne.toString();
        }
        return retour;
    }

    public int getID() {
        return ID;
    }

    public String getNumTel() {
        return numTel;
    }

    public LocalDate getDateDepot() {
        return dateDepot;
    }

    public int getNbArticleDepot() {
        return nbArticleDepot;
    }

    public LigneDepot[] getLignesDep() {
        return LignesDep;
    }
    
    //fonction qui permet de normaliser les id des livre, manuel et magazine
    private String normaliser(String s) {
    // enlève tout ce qui n'est pas chiffre ou X/x
    return s.replaceAll("[^0-9Xx]", "").toUpperCase();
    }
    
    // permet de vérifier la conformité d'un id donner
    private boolean Valid_ID(String idArticle){
        String idNorm = normaliser(idArticle);
        return(idNorm.length() == 8 || idNorm.length() == 13);
    }
    
    public void ajouterLigne(String id, int quantite){
        if(Valid_ID(id)){
            if (this.nbArticleDepot < MAX_LIGNE_DEPOT) {
                this.LignesDep[this.nbArticleDepot] = new LigneDepot(id, quantite);
                nbArticleDepot++;
                System.out.println("✅ Ajouté : " + id);
            } else {
                System.out.println("❌ Plus de place, tableau plein !");
            }
        }
        else {
            System.out.println("❌ l'identifiant "+id+" saisie n'est pas valide !");
        }
    }
}
