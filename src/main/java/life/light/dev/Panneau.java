package life.light.dev;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

import static life.light.dev.JeuDeLaVie.TAILLE_DE_LA_CELLULE_A_L_ECRAN;

public class Panneau extends JPanel {

    Set<Cellule> listeDesCellulesVivantes;

    @Override
    public void paintComponent(Graphics g) {
        //On choisit une couleur de fond pour le rectangle
        g.setColor(Color.white);
        //On le dessine de sorte qu'il occupe toute la surface
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);

        if (listeDesCellulesVivantes != null) {
            for (Cellule c : listeDesCellulesVivantes) {
                g.fillRect(c.colonne() * TAILLE_DE_LA_CELLULE_A_L_ECRAN, c.ligne() * TAILLE_DE_LA_CELLULE_A_L_ECRAN, TAILLE_DE_LA_CELLULE_A_L_ECRAN, TAILLE_DE_LA_CELLULE_A_L_ECRAN);
            }
        }
    }
}