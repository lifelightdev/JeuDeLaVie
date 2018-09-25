package life.light.dev;
import javax.swing.*;
import java.util.Random;

public class Main {

    public static int taille;

    public static void main(String[] args) {


        taille = 90;
        int nombreVivant = taille*10;
        Boolean[][] grille = genererGrille(taille, nombreVivant);

        JFrame fenetre = new JFrame();

        fenetre.setContentPane(new Panneau());

        //Définit un titre pour notre fenêtre
        fenetre.setTitle("Le jeux de la Vie");
        //Définit sa taille
        fenetre.setSize(taille*10+20, taille*10+40);
        //Nous demandons maintenant à notre objet de se positionner au centre
        fenetre.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Et enfin, la rendre visible
        fenetre.setVisible(true);

        Panneau pan = new Panneau();
        fenetre.setContentPane(pan);

        for (int i =0; i<1000;i++) {
            pan.setGrille(grille);
            pan.revalidate();
            pan.repaint();
            grille = generation(grille);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static Boolean[][] genererGrille (int taille, int nombreVivant){

        Boolean[][] grille = new Boolean[taille][taille];
        grille = initMort(grille);
        grille = initVivant(nombreVivant, grille);
        return grille;

    }

    public static Boolean[][] initMort(Boolean[][] grille) {
        for (int ligne = 0; ligne < taille; ligne++) {
            for (int colonne = 0; colonne < taille; colonne++) {
                grille[ligne][colonne] = false;
            }
        }
        return grille;
    }

    public static Boolean[][] initVivant(int nombre, Boolean[][] grille) {
        int nbCelluleVivante = 0;
        int ligne = 0;
        int colonne = 0;
        while (nbCelluleVivante <= nombre) {
            Random rand = new Random();
            ligne = rand.nextInt(taille);
            colonne = rand.nextInt(taille);
            if (!celulleEstVivante(ligne, colonne, grille)) {
                grille[ligne][colonne] = true;
                nbCelluleVivante = nbCelluleVivante + 1;
            }
        }
        return grille;
    }

    private static boolean celulleEstVivante(int ligne, int colonne, Boolean[][] grille) {
        if (ligne>=0 && ligne < taille && colonne >=0 && colonne < taille ) {
            return grille[ligne][colonne];
        } else {
            return false;
        }
    }

    private static int calculNombreVivantAutour(int ligne, int colonne, Boolean[][] grille) {
        int nbVivant = 0;
        // haut Gauche
        if (celulleEstVivante(ligne - 1,colonne - 1, grille)){
            nbVivant++;
        }
        // haut
        if (celulleEstVivante(ligne - 1,colonne , grille)){
            nbVivant++;
        }
        // haut droit
        if (celulleEstVivante(ligne - 1,colonne + 1 , grille)){
            nbVivant++;
        }
        //gauche
        if (celulleEstVivante(ligne,colonne - 1 , grille)){
            nbVivant++;
        }
        // droit
        if (celulleEstVivante(ligne,colonne + 1 , grille)){
            nbVivant++;
        }
        //bas Gauche
        if (celulleEstVivante(ligne + 1,colonne - 1 , grille)){
            nbVivant++;
        }
        //bas
        if (celulleEstVivante(ligne + 1,colonne , grille)){
            nbVivant++;
        }
        //bas droit
        if (celulleEstVivante(ligne + 1,colonne + 1 , grille)){
            nbVivant++;
        }

        return nbVivant;
    }

    private static Boolean[][] generation(Boolean[][] grilleEnCours) {
        Boolean[][] grilleNouvelleGeneration = genererGrille(taille, 0);
        // vivant
        for (int ligne = 0; ligne < taille; ligne++) {
            for (int colonne = 0; colonne < taille; colonne++) {
                int nbVivant = calculNombreVivantAutour(ligne, colonne, grilleEnCours);
                if (celulleEstVivante(ligne, colonne,grilleEnCours)) {
                    grilleNouvelleGeneration[ligne][colonne] = false;
                    if (nbVivant == 2 || nbVivant == 3 ) {
                        grilleNouvelleGeneration[ligne][colonne] = true;
                    }
                } else {
                    grilleNouvelleGeneration[ligne][colonne] = false;
                    if (nbVivant == 3) {
                        grilleNouvelleGeneration[ligne][colonne] = true;
                    }
                }
            }
        }
        return grilleNouvelleGeneration;
    }
}
