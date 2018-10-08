package life.light.dev;

import javax.swing.*;
import java.util.Random;

public class JeuDeLaVie {

    public static void main (String arg[]){
        int taille = 90;
        int nbVivantACreer = 3000;
        Grille grille = new Grille(taille);
        init_mort(grille);
        init_vivant(grille, nbVivantACreer);

        //Affichage
        JFrame fenetre = new JFrame();
        fenetre.setContentPane(new Panneau());

        //Définit un titre de la fenêtre
        fenetre.setTitle("Le jeux de la vie");
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

        for( int nbGeneration = 0; nbGeneration < 10000; nbGeneration ++){
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

    public static void init_mort(Grille grille) {
        int taille = grille.getTaille();
        for ( int colonne = 0 ; colonne < taille; colonne++){
            for ( int ligne = 0 ; ligne < taille; ligne++){
                Coordonnees coordonnees = new Coordonnees(colonne, ligne);
                grille.setCellule(coordonnees,false);
            }
        }
    }

    public static Grille generation(Grille grille){
        Grille grilleNewGeneration = new Grille(grille.getTaille());
        init_mort(grilleNewGeneration);
        for ( int colonne = 0 ; colonne < grille.getTaille(); colonne++){
            for ( int ligne = 0 ; ligne < grille.getTaille(); ligne++){
                Coordonnees coordonnees = new Coordonnees(colonne, ligne);
               if(grille.isNaissance(coordonnees)){
                   grilleNewGeneration.setCellule(coordonnees, true);
               }
               if(grille.isSurvie(coordonnees)){
                   grilleNewGeneration.setCellule(coordonnees, true);
               }
            }
        }
        return grilleNewGeneration;
    }

    public static void init_vivant(Grille grille, int nombreDeVivantACreer) {
        Random rand = new Random();
        int nbVivantEnCreation = 0;
        while (nbVivantEnCreation < nombreDeVivantACreer){
            int colonne = rand.nextInt(grille.getTaille());
            int ligne = rand.nextInt(grille.getTaille());
            Coordonnees coordonnees = new Coordonnees(colonne, ligne);
            if (!grille.getCellule(coordonnees)){
                grille.setCellule(coordonnees, true);
                nbVivantEnCreation++;
            }
        }
    }

}
