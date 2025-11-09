package life.light.dev;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JeuDeLaVie {

    public static final int TAILLE_DE_LA_CELLULE_A_L_ECRAN = 10;
    public static final int NOMBRE_DE_GENERATION_MAX = 10000;
    public static final int NOMBRE_DE_MILLISECONDE_ENTRE_CHAQUE_GENERATION = 100;
    static Logger logger = Logger.getLogger(JeuDeLaVie.class.getName());

    static void main() {

        logger.setLevel(Level.ALL);

        int tailleDuMonde = 60;
        Monde monde = new Monde(tailleDuMonde);
        monde.initialiseLeMondeAvec(tailleDuMonde * (100 / 3));

        //Affichage
        JFrame fenetre = new JFrame();
        fenetre.setContentPane(new Panneau());

        //Définit un titre de la fenêtre
        fenetre.setTitle("Le jeu de la vie");

        //Définit sa taille
        fenetre.setSize(
                tailleDuMonde * TAILLE_DE_LA_CELLULE_A_L_ECRAN,
                tailleDuMonde * TAILLE_DE_LA_CELLULE_A_L_ECRAN);

        //Positionne la fenêtre au centre
        fenetre.setLocationRelativeTo(null);

        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Et enfin, la rendre visible la fenêtre
        fenetre.setVisible(true);
        Panneau pan = new Panneau();
        fenetre.setContentPane(pan);

        // Affichage de chaque génération
        for (int nbGeneration = 0; nbGeneration < NOMBRE_DE_GENERATION_MAX; nbGeneration++) {
            pan.setGrille(monde);
            pan.revalidate();
            pan.repaint();
            try {
                Thread.sleep(NOMBRE_DE_MILLISECONDE_ENTRE_CHAQUE_GENERATION);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Sleep interrupted");
            }
            monde = generation(monde);
        }
    }

    public static Monde generation(Monde monde) {
        Monde mondeDeLaNouvelleGeneration = new Monde(monde.getTaille());
        for (int colonne = 0; colonne < monde.getTaille(); colonne++) {
            for (int ligne = 0; ligne < monde.getTaille(); ligne++) {
                Coordonnees coordonnees = new Coordonnees(colonne, ligne);
                if (monde.isNaissance(coordonnees)) {
                    mondeDeLaNouvelleGeneration.setCellule(coordonnees, true);
                }
                if (monde.isSurvie(coordonnees)) {
                    mondeDeLaNouvelleGeneration.setCellule(coordonnees, true);
                }
            }
        }
        return mondeDeLaNouvelleGeneration;
    }

}
