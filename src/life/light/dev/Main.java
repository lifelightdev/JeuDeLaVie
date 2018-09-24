package life.light.dev;

import javax.swing.*;
import java.util.Random;

public class Main {

    public static Boolean[][] grille;
    public static int taille;

    public static void main(String[] args) {
        taille = 90;
        int nombreVivant = taille*10;
        grille = genererGrille(taille, nombreVivant);

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
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            generation();
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
                nbCelluleVivante = nbCelluleVivante + 2;
            }
        }
        return grille;
    }

    private static boolean celulleEstVivante(int ligne, int colonne, Boolean[][] grille) {
        return grille[ligne][colonne];
    }

    private static int calculNombreVivantAutour(int ligne, int colonne, Boolean[][] grille) {
        int nbVivant = 0;
        boolean hautGauche = false;
        if (ligne > 0 && colonne > 0) {
            hautGauche = grille[ligne - 1][colonne - 1];
        }
        boolean haut = false;
        if (ligne > 0) {
            haut = grille[ligne - 1][colonne];
        }
        boolean hautDroit = false;
        if (ligne > 0 && colonne < taille - 1) {
            hautDroit = grille[ligne - 1][colonne + 1];
        }
        boolean gauche = false;
        if (colonne > 0) {
            gauche = grille[ligne][colonne - 1];
        }
        boolean droit = false;
        if (colonne < taille - 1) {
            droit = grille[ligne][colonne + 1];
        }
        boolean basGauche = false;
        if (ligne < taille - 1 && colonne > 0) {
            basGauche = grille[ligne + 1][colonne - 1];
        }
        boolean bas = false;
        if (ligne < taille - 1) {
            bas = grille[ligne + 1][colonne];
        }
        boolean basDroit = false;
        if (ligne < taille - 1 && colonne < taille - 1) {
            basDroit = grille[ligne + 1][colonne + 1];
        }
        if (hautGauche) {
            nbVivant++;
        }
        if (haut) {
            nbVivant++;
        }
        if (hautDroit) {
            nbVivant++;
        }
        if (gauche) {
            nbVivant++;
        }
        if (droit) {
            nbVivant++;
        }
        if (basGauche) {
            nbVivant++;
        }
        if (bas) {
            nbVivant++;
        }
        if (basDroit) {
            nbVivant++;
        }
        return nbVivant;
    }

    private static void generation() {
        // vivant
        for (int ligne = 0; ligne < taille; ligne++) {
            for (int colonne = 0; colonne < taille; colonne++) {
                int nbVivant = calculNombreVivantAutour(ligne, colonne, grille);
                if (celulleEstVivante(ligne, colonne,grille)) {
                    if (nbVivant == 2 || nbVivant == 3) {
                        grille[ligne][colonne] = true;
                    } else {
                        grille[ligne][colonne] = false;
                    }
                } else {
                    if (nbVivant == 3) {
                        grille[ligne][colonne] = true;
                    } else {
                        grille[ligne][colonne] = false;
                    }
                }
            }
        }
        grille = grille;
    }
}
