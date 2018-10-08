package life.light.dev;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {

    private  Grille grille;
    public void paintComponent(Graphics g){
        //On choisit une couleur de fond pour le rectangle
        g.setColor(Color.white);
        //On le dessine de sorte qu'il occupe toute la surface
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);

        for (int colonne = 0; colonne < grille.getTaille(); colonne++) {
            for (int ligne = 0; ligne < grille.getTaille(); ligne++) {
                Coordonnees coordonnees = new Coordonnees(colonne, ligne);
                if (grille.getCellule(coordonnees)){
                    g.fillRect(colonne*10, ligne*10, 10, 10);
                }
            }
        }
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }
}