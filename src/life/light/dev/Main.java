package life.light.dev;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Main {

    public static Boolean[][] grille;
    public static int taille;

    public static void main(String[] args) {
        taille = 50;
        genererGrille(taille);
        initMort();
        initVivant(500);

        JFrame fenetre = new JFrame();

        fenetre.setContentPane(new Panneau());

        //Définit un titre pour notre fenêtre
        fenetre.setTitle("Le jeux de la Vie");
        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        fenetre.setSize(taille*20, taille*20);
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
            pan.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            generation();
        }
    }

    private static void generation() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                boolean hautGauche = false;
                if (i > 0 && j > 0) {
                    hautGauche = grille[i - 1][j - 1];
                }
                boolean haut = false;
                if (i > 0) {
                    haut = grille[i - 1][j];
                }
                boolean hautDroit = false;
                if (i > 0 && j < taille - 1) {
                    hautDroit = grille[i - 1][j + 1];
                }
                boolean gauche = false;
                if (j > 0) {
                    gauche = grille[i][j - 1];
                }
                boolean droit = false;
                if (j < taille - 1) {
                    droit = grille[i][j + 1];
                }
                boolean basGauche = false;
                if (i < taille - 1 && j > 0) {
                    basGauche = grille[i + 1][j - 1];
                }
                boolean bas = false;
                if (i < taille - 1) {
                    bas = grille[i + 1][j];
                }
                boolean basDroit = false;
                if (i < taille - 1 && j < taille - 1) {
                    basDroit = grille[i + 1][j + 1];
                }
                if (grille[i][j]) {
                    int nbVivant = 0;
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
                    if (grille[i][j]) {
                        if (nbVivant == 2 || nbVivant == 3) {
                            grille[i][j] = true;
                        } else {
                            grille[i][j] = false;
                        }
                    } else {
                        if (nbVivant == 3) {
                            grille[i][j] = true;
                        } else {
                            grille[i][j] = false;
                        }
                    }
                }
            }
        }
    }

    public static Boolean[][] genererGrille(int newtaille) {
        taille = newtaille;
        grille = new Boolean[taille][taille];
        return grille;
    }

    public static void initMort() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = false;
            }
        }
    }

    public static void initVivant(int nombre) {
        int nbCelluleVivante = 0;
        int ligne = 0;
        int colonne = 0;
        while (nbCelluleVivante <= nombre) {
            Random rand = new Random();
            ligne = rand.nextInt(taille);
            colonne = rand.nextInt(taille);
            if (!grille[ligne][colonne]) {
                grille[ligne][colonne] = true;
                nbCelluleVivante = nbCelluleVivante + 2;
            }
        }
    }

}

