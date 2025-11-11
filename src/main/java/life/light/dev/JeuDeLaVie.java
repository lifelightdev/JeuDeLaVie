package life.light.dev;

import javax.swing.*;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JeuDeLaVie {

    public static final int TAILLE_DE_LA_CELLULE_A_L_ECRAN = 10;
    public static final int NOMBRE_DE_GENERATION_MAX = 100;
    public static final int NOMBRE_DE_MILLISECONDE_ENTRE_CHAQUE_GENERATION = 150;
    static Logger logger = Logger.getLogger(JeuDeLaVie.class.getName());

    private JeuDeLaVie() {
    }

    static void main() {

        logger.setLevel(Level.ALL);

        int tailleDuMonde = 60;

        //Affichage
        JFrame fenetre = new JFrame();

        //Définit un titre de la fenêtre
        fenetre.setTitle("Le jeu de la vie");

        //Définit sa taille
        fenetre.setSize(
                tailleDuMonde * TAILLE_DE_LA_CELLULE_A_L_ECRAN,
                tailleDuMonde * TAILLE_DE_LA_CELLULE_A_L_ECRAN);

        //Positionne la fenêtre au centre
        fenetre.setLocationRelativeTo(null);

        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Et enfin, la rendre visible la fenêtre
        fenetre.setVisible(true);
        Panneau panneauDuMonde = new Panneau();
        fenetre.setContentPane(panneauDuMonde);

        Monde monde = new Monde(tailleDuMonde);
        Set<Cellule> listeDesCellulesVivantes = monde.initialiseLeMondeAvec(tailleDuMonde * (100 / 3));

        panneauDuMonde.listeDesCellulesVivantes = listeDesCellulesVivantes;
        panneauDuMonde.revalidate();
        panneauDuMonde.repaint();

        for (int nbGeneration = 0; nbGeneration < NOMBRE_DE_GENERATION_MAX; nbGeneration++) {
            panneauDuMonde.listeDesCellulesVivantes = listeDesCellulesVivantes;
            panneauDuMonde.revalidate();
            panneauDuMonde.repaint();
            try {
                Thread.sleep(NOMBRE_DE_MILLISECONDE_ENTRE_CHAQUE_GENERATION);
            } catch (InterruptedException _) {
                logger.log(Level.WARNING, "Erreur d'attente");
            }
            listeDesCellulesVivantes = monde.nouvelleGeneration(listeDesCellulesVivantes);
        }
    }

}
