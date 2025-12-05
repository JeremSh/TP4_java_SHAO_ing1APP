/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jerem
 */
public class Etablissement {
    private final static int MAX_ARTICLE = 20;
    private final static int MAX_BON = 10;
//    public final static String FICHIER_ARTICLE = "article.txt";
    public final static String FICHIER_BON = "bon.txt";
    
    private String nom;
    // on peut utiliser des List comme des arraylist par exemple, mais on devrais gérer nous même la limite
    // j'ai choisie des tableaux car c'est ce qui était demandé
    private Article[] articles = new Article[MAX_ARTICLE];
    private BonDepot[] bons = new BonDepot[MAX_BON];
    private int nbArticle = 0;
    private int nbBon = 0;

    public Etablissement(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Article[] getArticles() {
        return articles;
    }

    public BonDepot[] getBons() {
        return bons;
    }
    
    
    
    public void afficheEtablissement(){
        System.out.println("nom de l'etablissement : "+nom);
        System.out.println("Liste des artciles disponible : ");
        if(nbArticle > 0){
            for (Article article : articles){
                if(article != null){
                    System.out.println(article.toString());
                    System.out.println();
                }
            }
        }
        else{
            System.out.println("Il n'y a pas encore d'article dans l'établissement");
        }
        if(nbBon > 0){
        System.out.println("Liste des bons : ");
            for (BonDepot bon : bons){
                if(bon != null){
                    bon.affiche();
                    System.out.println();
                }
            }
        }
        else{
            System.out.println("Il n'y a pas encore de bon enregistrer dans l'établissement");
        }
        System.out.println();
    }
    
    
    //actuellement on a pas implémenté la possibilité de retirer des articles, mais quand cela sera le cas on aura a gérer les null dans le tableau que cela provoquera, une méthode pour moi serai de rajouter une variable comme indice et de le mettre a jour quand on retire et à la fin de ajouter de faire une vérification pour mettre l'indice au prochain espace vide ou alors passer a une arrayList en ajouter une vérification pour la limite demandé
    public void ajouterLivre(String description, double prixI, String num, int nbPage, int quantite){
        if(normaliser(num).length() == 13){
            if (nbArticle < MAX_ARTICLE) {
                Livre nouveau = new Livre(num, nbPage, description, prixI, quantite);

                int cpt = 0;
                // on cherche la bonne position ou insérer le nouveau livre
                while (cpt < nbArticle && nouveau.placerApres(articles[cpt])) {
                    cpt++;
                }
                // on décale les autre objet
                for (int i = nbArticle; i > cpt; i--) {
                    articles[i] = articles[i - 1];
                }
                articles[cpt] = nouveau;
                nbArticle++;

                System.out.println("✅ Ajouté (à la position " + cpt + ") : " + num);

            } else {
                System.out.println("❌ Plus de place, tableau plein !");
            }
        }
        else {
            System.out.println("❌ l'ISBN "+num+" saisie n'est pas valide !");
        }
    }
    
    public void ajouterManuel(String matière, String nivScolaire, String ID_ISBN, int nbPages, String description, double prixInit, int nbExemplaire){
        if (normaliser(ID_ISBN).length() == 13){
            if (nbArticle < MAX_ARTICLE) {
                
                Manuel nouveau = new Manuel(matière, nivScolaire, ID_ISBN, nbPages, description, prixInit, nbExemplaire);

                int cpt = 0;
                // on cherche la bonne position ou insérer le nouveau manuelle
                while (cpt < nbArticle && nouveau.placerApres(articles[cpt])) {
                    cpt++;
                }
                // on décale les autre objet
                for (int i = nbArticle; i > cpt; i--) {
                    articles[i] = articles[i - 1];
                }
                articles[cpt] = nouveau;
                nbArticle++;

                System.out.println("✅ Ajouté (à la position " + cpt + ") : " + ID_ISBN);
            } else {
                System.out.println("❌ Plus de place, tableau plein !");
            }
        }
        else {
            System.out.println("❌ l'ISBN "+ID_ISBN+" saisie n'est pas valide !");
        }
    }
    
    public void ajouterMagazine(String ID_ISSN, String périodicité, LocalDate datePublication, String description, double prixInit, int nbExemplaire){
        if(normaliser(ID_ISSN).length() == 8){
            if (nbArticle < MAX_ARTICLE) {
                
                Magazine nouveau = new Magazine(ID_ISSN, périodicité, datePublication, description, prixInit, nbExemplaire);

                int cpt = 0;
                // on cherche la bonne position ou insérer le nouveau manuelle
                while (cpt < nbArticle && nouveau.placerApres(articles[cpt])) {
                    cpt++;
                }
                // on décale les autre objet
                for (int i = nbArticle; i > cpt; i--) {
                    articles[i] = articles[i - 1];
                }
                articles[cpt] = nouveau;
                nbArticle++;

                System.out.println("✅ Ajouté (à la position " + cpt + ") : " + ID_ISSN);
                
            } else {
                System.out.println("❌ Plus de place, tableau plein !");
            }
        }
        else{
            System.out.println("❌ l'ISSN "+ID_ISSN+" saisie n'est pas valide !");
        }
    }
    
    //fonction qui permet de normaliser les id des livre, manuel et magazine
    private String normaliser(String s) {
    // enlève tout ce qui n'est pas chiffre ou X/x
    return s.replaceAll("[^0-9Xx]", "").toUpperCase();
    }
    
    public Article recherche(String id){
        int cpt = 0;
        boolean trouve = false;
        Article article = null;
        // on continue a cherche tant qu'on a pas trouver ou jusqu'à la dernière valeur
        // PS : on peut aussi utiliser un for et mettre un return à l'intérieur
        while(cpt < articles.length && !trouve){
            if(articles[cpt] != null && articles[cpt].getNumero().equals(id)){
                article = articles[cpt];
                trouve = true;
            }
            cpt ++;
        }
        
        if(!trouve){
            System.out.println("L'article "+id+" n'a pas était trouvé dans les stocks du magasin "+nom);
        }
        return article;
    }
    
    public void ajouter(String id, int quantite){
        // on récupère l'article si il est présent dans la boutique
        Article article = recherche(id);
        
        if(article != null){
            article.ajouter(quantite);
            System.out.println("La quantité de l'article "+id+" à bien était augmenté de "+quantite+" unité(s)");
        }
        else{
            System.out.println("L'article "+id+" n'a pas était trouvé dans le magasin");
        }
    }
    
    public void retirer(String id, int quantite){
        // on récupère l'article si il est présent dans la boutique
        Article article = recherche(id);
        
        if(article != null){
            //on fait avant pour savoir si on doit faire l'affichage
            if(article.nbExemplaire - quantite >=0){
                System.out.println("La quantité de l'article "+id+" à bien était diminuer de "+quantite+" unité(s)");
            }
            // les méthodes retirer des articles gére déjà les cas ou on essaye de trop diminuer la quantité d'un article, mais on pourrait rajouter un traitement ou une vérification.
            article.retirer(quantite);
        }
        else{
            System.out.println("L'article "+id+" n'a pas était trouvé dans le magasin");
        }
    }
    
    public void ajouterBon(String numTel){
        if(nbBon < MAX_BON){
            BonDepot nouveau = new BonDepot(numTel);
            
            int pos = 0;
            while (pos < nbBon && bons[pos].getDateDepot().isBefore(nouveau.getDateDepot())) {
                pos++;
            }
            
            for (int i = nbBon; i > pos; i--) {
                bons[i] = bons[i - 1];
            }
            
            bons[pos] = nouveau;
            nbBon++;

            System.out.println("Le nouveau bon a bien était enregistré");
        }
        else {
            System.out.println("❌ Plus de place, tableau plein !");
        }
    }
    
    public void ajouterBon(BonDepot nouveau){
        if(nbBon < MAX_BON){
            int pos = 0;
            while (pos < nbBon && bons[pos].getDateDepot().isBefore(nouveau.getDateDepot())) {
                pos++;
            }
            
            for (int i = nbBon; i > pos; i--) {
                bons[i] = bons[i - 1];
            }
            
            bons[pos] = nouveau;
            nbBon++;

            System.out.println("Le nouveau bon a bien était enregistré");
        }
        else {
            System.out.println("❌ Plus de place, tableau plein !");
        }
    }    
   
    public void listerArticle(){
        Article[] newTab = new Article[this.articles.length];
        newTab[0] = articles[0];
        // création d'un nouveau tableau trier par ordre croissant par nombre d'exemplaire
        for (int i = 1; i < this.articles.length; i++) {
            if(this.articles[i] != null){
                Article articleCourant = this.articles[i];
                int j = i - 1;

                // on reste dans la partie déjà remplie : j >= 0
                while (j >= 0 && newTab[j].getNbExemplaire() > articleCourant.getNbExemplaire()) {
                    newTab[j + 1] = newTab[j];
                    j--;
                }
                newTab[j + 1] = articleCourant;
            }
        }
        
        //affichage du nouveau tableau trié
        for(Article article : newTab){
            if(article != null){
                System.out.println(article.toString());
            }
        }
    }
    
    
    public void versFichierDepots() throws IOException{
        FileWriter fich=new FileWriter(FICHIER_BON);
        for(int i=0; i<this.nbBon; i++){
            String ch = this.bons[i].versFichier();
            fich.write(ch);
        }
        System.out.println("Fichier : "+FICHIER_BON+" créer avec succès");
        fich.close();
    }
    
        public void versFichierDepots(String fichier) throws IOException{
        FileWriter fich=new FileWriter(fichier);
        for(int i=0; i<this.nbBon; i++){
            String ch = this.bons[i].versFichier();
            fich.write(ch);
        }
        System.out.println("Fichier : "+fichier+" créer avec succès");
        fich.close();
    }
    
    public void depuisFichierDepots() throws IOException, FileNotFoundException{
        FileReader fich = new FileReader(FICHIER_BON);
        BufferedReader br = new BufferedReader(fich);
        int nbBonLue = 0;
        
        System.out.println("contenu chargé du fichier : "+FICHIER_BON);
        
        String ligne = br.readLine();
        while(ligne != null){
            int id = Integer.parseInt(ligne);
            ligne = br.readLine();
            String[]tab = ligne.split(" : ");
            String numTel = tab[0];
            LocalDate date = LocalDate.parse(tab[1]);
            BonDepot nouveauBon = new BonDepot(id, numTel, date);
            int nbLigne = Integer.parseInt(tab[2]);
            System.out.println(nbLigne);
            for(int cpt = 0; cpt < nbLigne; cpt++){
                ligne = br.readLine();
                tab = ligne.split(" : ");
                int nbExemplaire = Integer.parseInt(tab[0]);
                String idLigne = tab[1];
                nouveauBon.ajouterLigne(idLigne, nbExemplaire);
            }
            this.ajouterBon(nouveauBon);
            ligne = br.readLine();
        }
        fich.close();
    }
    
        public void depuisFichierDepots(String fichier) throws IOException, FileNotFoundException{
        FileReader fich = new FileReader(fichier);
        BufferedReader br = new BufferedReader(fich);
        int nbBonLue = 0;
        
        System.out.println("contenu chargé du fichier : "+fichier);
        
        String ligne = br.readLine();
        while(ligne != null){
            int id = Integer.parseInt(ligne);
            ligne = br.readLine();
            String[]tab = ligne.split(" : ");
            String numTel = tab[0];
            LocalDate date = LocalDate.parse(tab[1]);
            BonDepot nouveauBon = new BonDepot(id, numTel, date);
            int nbLigne = Integer.parseInt(tab[2]);
            System.out.println(nbLigne);
            for(int cpt = 0; cpt < nbLigne; cpt++){
                ligne = br.readLine();
                tab = ligne.split(" : ");
                int nbExemplaire = Integer.parseInt(tab[0]);
                String idLigne = tab[1];
                nouveauBon.ajouterLigne(idLigne, nbExemplaire);
            }
            this.ajouterBon(nouveauBon);
            ligne = br.readLine();
        }
        fich.close();
    }
    
}
