package life.light.dev;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Set;

import static life.light.dev.JeuDeLaVie.TAILLE_DE_LA_CELLULE_A_L_ECRAN;
import static org.assertj.core.api.Assertions.assertThat;

class PanneauTest {

    private BufferedImage rendu(Panneau panneau, int largeur, int hauteur) {
        panneau.setSize(largeur, hauteur);
        BufferedImage image = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        try {
            panneau.paintComponent(g2d);
        } finally {
            g2d.dispose();
        }
        return image;
    }

    @Test
    void quand_aucune_cellule_vivante_est_fournie_le_panneau_est_entierement_blanc() {
        Panneau panneau = new Panneau();
        // État par défaut: listeDesCellulesVivantes == null
        int tailleDuMonde = 3 * TAILLE_DE_LA_CELLULE_A_L_ECRAN;
        BufferedImage image = rendu(panneau, tailleDuMonde, tailleDuMonde);

        for (int y = 0; y < tailleDuMonde; y += tailleDuMonde) {
            for (int x = 0; x < tailleDuMonde; x += tailleDuMonde) {
                assertThat(image.getRGB(x, y)).isEqualTo(Color.white.getRGB());
            }
        }
    }

    @Test
    void dessine_un_carre_noir_pour_une_cellule_vivante() {
        Panneau panneau = new Panneau();
        // Place une cellule vivante à la colonne 1, ligne 1
        panneau.listeDesCellulesVivantes = Set.of(new Cellule(1, 1));

        int tailleDuMonde = 3 * TAILLE_DE_LA_CELLULE_A_L_ECRAN;
        BufferedImage image = rendu(panneau, tailleDuMonde, tailleDuMonde);

        assertThat(image.getRGB(TAILLE_DE_LA_CELLULE_A_L_ECRAN, TAILLE_DE_LA_CELLULE_A_L_ECRAN)).isEqualTo(Color.black.getRGB());
        assertThat(image.getRGB(0, 0)).isEqualTo(Color.white.getRGB());
        assertThat(image.getRGB(2 * TAILLE_DE_LA_CELLULE_A_L_ECRAN, 2 * TAILLE_DE_LA_CELLULE_A_L_ECRAN)).isEqualTo(Color.white.getRGB());
    }
}
