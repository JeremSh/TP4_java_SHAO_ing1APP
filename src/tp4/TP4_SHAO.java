/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp4;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author jerem
 */
public class TP4_SHAO {

     public static String genererNumeroTel() {
         Random rand = new Random();
        // Choisir entre 06 et 07
        String numero = rand.nextBoolean() ? "06" : "07";
        // Ajouter les 8 chiffres restants
        for (int i = 0; i < 8; i++) {
            if(i%2==0){
                numero+=" ";
            }
            numero += rand.nextInt(10);
        }
        return numero;
    }
    
     
    public static LocalDate genererLocalDateAleatoire() {
        Random rand = new Random();

        int annee = rand.nextInt(2100 - 1900 + 1) + 1900;
        int mois  = rand.nextInt(12) + 1;                

        // nbMaxJours dépend du mois et de l'année (pour gérer février / année bissextile)
        int nbMaxJours = LocalDate.of(annee, mois, 1).lengthOfMonth();
        int jour = rand.nextInt(nbMaxJours) + 1;

        return LocalDate.of(annee, mois, jour);
    }
    
    public static String genererID() {
        Random rand = new Random();
        // Choisir aléatoirement entre 8 et 13 chiffres
        int longueur = rand.nextBoolean() ? 13 : 8;
        String id = "";
        for (int i = 0; i < longueur; i++) {
            id += rand.nextInt(10);
        }
        return id;
    }
    
    public static int genererQuantite() {
        Random rand = new Random();
        return rand.nextInt(10000) + 1;
    }
    
    public static BonDepot genererBon(){
        BonDepot nbon = new BonDepot(genererNumeroTel(), genererLocalDateAleatoire());
        Random rand = new Random();
        int nbLigne = rand.nextInt(nbon.getMaxLigne()) + 1;
        for(int cpt=0; cpt < nbLigne; cpt++){
            nbon.ajouterLigne(genererID(), rand.nextInt(10000) + 1);
        }
        return nbon;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
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
        
        e1.listerArticle();
        
        bon1.ajouterLigne("1452637898451", 20);
        bon1.ajouterLigne("1452634298452", 40);
        bon1.ajouterLigne("1452637898453", 100);
        bon1.ajouterLigne("1452637898454", 220);
        
        System.out.println(bon1.versFichier());
        
        e1.ajouterBon(bon1);
        
        e1.afficheEtablissement();
        
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Test Pour la génération ou la sauvegarde dans un fichier");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        
        e1.versFichierDepots("testBonMag1.txt");
        e1.afficheEtablissement();
        
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Test Pour la lecture à partir d'un fichier");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        
        Etablissement e2 = new Etablissement("Magasin d'encore l'autre monde");
        e2.afficheEtablissement();
        e2.depuisFichierDepots("bonTest.txt");
        e2.afficheEtablissement();

        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Test Finale Menu");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        
        boolean fin = false;
        Etablissement eMenu = new Etablissement("Magasin menu");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le menu du Magasin "+eMenu.getNom());
        while(!fin){    
            System.out.println("Faite le choix de votre action en saisisant le chiffre correspondant");
            System.out.println("1. Afficher les information de l'enseigne");
            System.out.println("2. Ajouter un Bon de test aléatoirement générer");
            System.out.println("3. sauvegarder dans un fichier les données");
            System.out.println("4. chargé les données d'un fichier");
            System.out.println("5. quitter");
            
            int choix = scanner.nextInt(); 
            
            switch (choix) {
                case 1:
                    System.out.println("Voici les informations de l'établissement");
                    eMenu.afficheEtablissement();
                    break;

                case 2:
                    BonDepot b = genererBon();
                    System.out.println("Le bon qui été générer et ajouter est le suivant :");
                    b.affiche();
                    eMenu.ajouterBon(b);
                    break;

                case 3:
                    eMenu.versFichierDepots();
                    break;
                    
                case 4:
                    eMenu.depuisFichierDepots();
                    break;
                    
                case 5:
                    fin = true;
                    break;

                default:
                    System.out.println("Choix invalide");
                    break;
            }
            
        } 
        System.out.println("Au revoir");
        scanner.close(); // optionnel mais conseillé
    }

}
