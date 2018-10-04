package life.light.dev;

import javax.swing.*;
import java.util.Random;

public class JeuDeLaVie {

    public static final int NAISSANCE = 3;
    public static final int SURVIE2VIVANTS = 2;
    public static final int SURVIE3VIVANTS = 3;

    public static void main (String arg[]){
        int taille = 90;
        int nbVivantACreer = 3000;
        Boolean[][] grille = creer_grille(taille);
        init_mort(grille);
        init_vivant(grille, nbVivantACreer);

        //Affichage
        JFrame fenetre = new JFrame();
        fenetre.setContentPane(new Panneau());

        //Définit un titre de la fenêtre
        fenetre.setTitle("Le jeux de la Vie");
        //Définit sa taille
        fenetre.setSize(taille*10+20, taille*10+40);
        //Positionne la fenêtre au centre
        fenetre.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Et enfin, la rendre visible
        fenetre.setVisible(true);
        Panneau pan = new Panneau();
        fenetre.setContentPane(pan);

        for( int nbGeneration = 0; nbGeneration < 1000; nbGeneration ++){
            pan.setGrille(grille);
            pan.revalidate();
            pan.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            grille = generation(grille);
        }

    }

    public static Boolean[][] creer_grille(int taille) {

        return new Boolean[taille][taille];
    }

    public static void init_mort(Boolean[][] grille) {
        int taille = grille.length;
        for ( int colonne = 0 ; colonne < taille; colonne++){
            for ( int ligne = 0 ; ligne < taille; ligne++){
               grille[colonne][ligne]=false;
            }
        }
    }

    public static Boolean[][] generation(Boolean[][] grille){
        int taille = grille.length;
        Boolean[][] grilleNewGeneration = creer_grille(taille);
        init_mort(grilleNewGeneration);
        for ( int colonne = 0 ; colonne < taille; colonne++){
            for ( int ligne = 0 ; ligne < taille; ligne++){
               if(isNaissance(grille, colonne, ligne)){
                   grilleNewGeneration[colonne][ligne] = true;
               }
               if(isSurvie(grille, colonne,ligne)){
                   grilleNewGeneration[colonne][ligne] = true;
               }
            }
        }
        return grilleNewGeneration;
    }


    public static void init_vivant(Boolean[][] grille, int nombreDeVivantACreer) {
        Random rand = new Random();
        int nbVivantEnCreation = 0;
        while (nbVivantEnCreation < nombreDeVivantACreer){
            int colonne = rand.nextInt(grille.length);
            int ligne = rand.nextInt(grille.length);
            if (!grille[colonne][ligne]){
                grille[colonne][ligne] = true;
                nbVivantEnCreation++;
            }
        }
    }

    public static Boolean isNaissance (Boolean[][] grille, int colonne, int ligne){
        if (!grille[colonne][ligne]) {
            if (nbVivantAlentour(grille, colonne, ligne) == NAISSANCE) {
                return true;
            }
        }
        return false;
    }

    public static Boolean isSurvie (Boolean[][] grille, int colonne, int ligne){
        if(grille[colonne][ligne]){
            int nbVivantAlentour = nbVivantAlentour(grille, colonne, ligne);
            if ((nbVivantAlentour != SURVIE2VIVANTS) && (nbVivantAlentour != SURVIE3VIVANTS)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static int nbVivantAlentour(Boolean[][] grille, int colonne, int ligne) {
        int nbVivantAlentour = 0;
        if (isVivantHautGauche(grille, colonne, ligne)){
            nbVivantAlentour++;
        }
        if (isVivantHaut(grille, colonne, ligne)){
            nbVivantAlentour++;
        }
        if (isVivantHautDroite(grille, colonne, ligne)){
            nbVivantAlentour++;
        }
        if (isVivantDroite(grille, colonne, ligne)){
            nbVivantAlentour++;
        }
        if (isVivantGauche(grille, colonne, ligne)){
            nbVivantAlentour++;
        }
        if (isVivantDroite(grille, colonne, ligne)){
            nbVivantAlentour++;
        }
        if (isVivantBasGauche(grille, colonne, ligne)){
            nbVivantAlentour++;
        }
        if (isVivantBas(grille, colonne, ligne)){
            nbVivantAlentour++;
        }
        if (isVivantBasDroite(grille, colonne, ligne)){
            nbVivantAlentour++;
        }
        return nbVivantAlentour;
    }

    public static boolean isVivantHautGauche(Boolean[][] grille, int colonne, int ligne) {
        colonne = colonne - 1;
        ligne = ligne - 1 ;
        if (isDansGrille(grille, colonne, ligne)){
            return grille[colonne][ligne];
        } else {
            return false;
        }
    }

    public static boolean isVivantHaut(Boolean[][] grille, int colonne, int ligne) {
        ligne = ligne - 1 ;
        if (isDansGrille(grille, colonne, ligne)){
            return grille[colonne][ligne];
        } else {
            return false;
        }
    }

    public static boolean isVivantHautDroite(Boolean[][] grille, int colonne, int ligne) {
        colonne = colonne + 1;
        ligne = ligne - 1 ;
        if (isDansGrille(grille, colonne, ligne)){
            return grille[colonne][ligne];
        } else {
            return false;
        }
    }

    public static boolean isVivantGauche(Boolean[][] grille, int colonne, int ligne) {
        colonne = colonne - 1;
        if (isDansGrille(grille, colonne, ligne)){
            return grille[colonne][ligne];
        } else {
            return false;
        }
    }

    public static boolean isVivantDroite(Boolean[][] grille, int colonne, int ligne) {
        colonne = colonne + 1;
        if (isDansGrille(grille, colonne, ligne)){
            return grille[colonne][ligne];
        } else {
            return false;
        }
    }

    public static boolean isVivantBasGauche(Boolean[][] grille, int colonne, int ligne) {
        colonne = colonne - 1;
        ligne = ligne + 1;
        if (isDansGrille(grille, colonne, ligne)){
            return grille[colonne][ligne];
        } else {
            return false;
        }
    }

    public static boolean isVivantBas(Boolean[][] grille, int colonne, int ligne) {
        ligne = ligne + 1;
        if (isDansGrille(grille, colonne, ligne)){
            return grille[colonne][ligne];
        } else {
            return false;
        }
    }

    public static boolean isVivantBasDroite(Boolean[][] grille, int colonne, int ligne) {
        colonne = colonne + 1;
        ligne = ligne + 1;
        if (isDansGrille(grille, colonne, ligne)){
            return grille[colonne][ligne];
        } else {
            return false;
        }
    }

    public static boolean isDansGrille(Boolean[][] grille, int colonne, int ligne) {
        if (!isColonneDansGrille(grille, colonne)){
            return false;
        }
        if (!isLigneDansGrille(grille, ligne)){
            return  false;
        }
        return true;
    }

    public static boolean isLigneDansGrille(Boolean[][] grille, int ligne) {
        return ligne >= 0 && ligne < grille.length;
    }

    public static boolean isColonneDansGrille(Boolean[][] grille, int colonne) {
        return colonne >= 0 && colonne < grille.length;
    }

}
