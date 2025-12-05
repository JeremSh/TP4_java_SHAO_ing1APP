/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp4;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author jerem
 */
public class LigneDepot {
    String ID_article;
    int nbExemplaireDepot;
    public final static String FICHIER_LIGNE = "ligne_depot.txt";
    
    LigneDepot(String id){
        ID_article = id;
        nbExemplaireDepot = 1;
    }
    
    LigneDepot(String id, int nb){
        ID_article = id;
        nbExemplaireDepot = nb;
    }
    
    public String toString(){
        return "ID de l'article : "+ID_article+"\n nombre d'exemplaire deposer : "+nbExemplaireDepot;
    }

    public String getID_article() {
        return ID_article;
    }

    public int getNbExemplaireDepot() {
        return nbExemplaireDepot;
    }
    
    public String versFichier(){
        return nbExemplaireDepot+" : "+ID_article;
    }
}
