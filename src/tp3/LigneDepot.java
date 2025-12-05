/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author jerem
 */
public class LigneDepot {
    String ID_article;
    int nbExemplaireDepot;
    
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
    
    
}
