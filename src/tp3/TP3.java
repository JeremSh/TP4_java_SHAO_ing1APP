/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3;

import java.time.LocalDate;

/**
 *
 * @author jerem
 */
public class TP3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Livre l1 = new Livre("1234561234561", 20, "livre de test", 10.0, 2);
        Manuel m1 = new Manuel("Histoire", "Cp", "1234561234562", 20, "manuel de test", 15.0, 5);
        Magazine mag1 = new Magazine("12345678", "mensuel", LocalDate.now(), "Magazine test", 8.0, 4);
        
        LigneDepot ligne1 = new LigneDepot("12345679", 12);
        
        BonDepot bon1 = new BonDepot("01 22 44 55 77");
        bon1.affiche();
        
        Etablissement e1 = new Etablissement("Magasin du monde");
        e1.afficheEtablissement();
        
        e1.ajouterLivre("Premier livre ajouter", 10.05, "1234561230123", 250, 5);
        e1.ajouterLivre("deuxième livre", 25.0, "1234561230122", 153, 2);
        e1.ajouterManuel("Art", "CM1", "1452637898451", 350, "Premier Manuel", 15.5, 20);
        e1.ajouterMagazine("11612378", "mensuel", LocalDate.now(), "Premier magasin", 8.5, 12);
        
        e1.afficheEtablissement();
        
        e1.ajouter("1452637898451", 10);
        e1.retirer("1234561230123", 5);
        e1.ajouter("11612378", 100);
        e1.retirer("11612378", 150);
        
        e1.afficheEtablissement();
        
        System.out.println(mag1.calculerPrix());
        LocalDate dateFutur = LocalDate.of(2030, 4, 23);
        System.out.println(mag1.calculerPrix(dateFutur));
        
        System.out.println(l1.calculerPrix());
        LocalDate dateFutur2 = LocalDate.of(2030, 4, 23);
        System.out.println(l1.calculerPrix(dateFutur));
        
        e1.ajouterBon("01 12 45 75 13");
        
        e1.getBons()[0].ajouterLigne("1452637898451", 30);
        
        e1.afficheEtablissement();
    }
    
}
