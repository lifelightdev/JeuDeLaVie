package life.light.dev;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {

    private  Boolean[][] grille;
    public void paintComponent(Graphics g){
        //if (fondcouleur) {
            //On choisit une couleur de fond pour le rectangle
            g.setColor(Color.white);
            //On le dessine de sorte qu'il occupe toute la surface
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        //}
        g.setColor(Color.black);

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille.length; j++) {
                if (grille[i][j]){
                    g.fillRect(i*10, j*10, 10, 10);
                }
            }
        }

    }

    public void setGrille(Boolean[][] grille) {
        this.grille = grille;
    }
}