package life.light.dev;

import life.light.dev.JeuDeLaVie;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JeuDeLaVieTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void doit_creer_grille() {
        Boolean grille [][] = new Boolean[10][10];
        assertArrayEquals(grille, JeuDeLaVie.creer_grille(10));
    }

    @Test
    public void doit_initialiser_grille_de_10_a_mort(){
        Boolean grille [][] = new Boolean[2][2];
        Boolean grilleResultat [][] = new Boolean[2][2];
        grilleResultat[0][0] = false;
        grilleResultat[0][1] = false;
        grilleResultat[1][0] = false;
        grilleResultat[1][1] = false;
        JeuDeLaVie.init_mort(grille);
        assertArrayEquals(grilleResultat, grille );
    }

    @Test
    public void doit_ajouter_3_vivant_dans_grille(){
        Boolean grille [][] = new Boolean[2][2];
        JeuDeLaVie.init_mort(grille);
        JeuDeLaVie.init_vivant(grille,3);
        int nbVivantCreer = 0;
        for ( int colonne = 0 ; colonne < 2; colonne++){
            for ( int ligne = 0 ; ligne < 2; ligne++){
                if (grille[colonne][ligne]){
                    nbVivantCreer++;
                }
            }
        }
        assertEquals(3, nbVivantCreer);
    }

    @Test
    public void celulle_alentour_en_haut_a_gauche_doit_etre_vivante(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = true; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = false; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = false; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit
        assertTrue("La celulle en haut à gauche de la celulle courante est morte",JeuDeLaVie.isVivantHautGauche(grille,1,1));
    }

    @Test
    public void celulle_alentour_en_haut_doit_etre_vivante(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = false; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = true; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = false; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit
        Assert.assertTrue("La celulle en haut à gauche de la celulle courante est morte",JeuDeLaVie.isVivantHaut(grille,1,1));
    }

    @Test
    public void celulle_alentour_en_haut_a_droite_doit_etre_vivante(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = false; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = false; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = true; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit
        assertTrue("La celulle en haut à droit de la celulle courante est morte",JeuDeLaVie.isVivantHautDroite(grille,1,1));
    }

    @Test
    public void celulle_alentour_a_gauche_doit_etre_vivante(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = false; // haut gauche
        grille[0][1] = true; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = false; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = false; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit
        assertTrue("La celulle à gauche de la celulle courante est morte",JeuDeLaVie.isVivantGauche(grille,1,1));
    }

    @Test
    public void celulle_alentour_a_droite_doit_etre_vivante(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = false; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = false; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = false; // haut droit
        grille[2][1] = true; // droit
        grille[2][2] = false; // bas droit
        assertTrue("La celulle à droite de la celulle courante est morte",JeuDeLaVie.isVivantDroite(grille,1,1));
    }

    @Test
    public void celulle_alentour_en_bas_a_gauche_doit_etre_vivante(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = false; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = true; // bas gauche
        grille[1][0] = false; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = false; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit
        assertTrue("La celulle en bas à gauche de la celulle courante est morte",JeuDeLaVie.isVivantBasGauche(grille,1,1));
    }

    @Test
    public void celulle_alentour_en_bas_doit_etre_vivante(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = false; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = false; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = true; // bas
        grille[2][0] = false; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit
        assertTrue("La celulle en bas de la celulle courante est morte",JeuDeLaVie.isVivantBas(grille,1,1));
    }

    @Test
    public void celulle_alentour_en_bas_a_droite_doit_etre_vivante(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = false; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = false; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = false; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = true; // bas droit
        assertTrue("La celulle en bas à droite de la celulle courante est morte",JeuDeLaVie.isVivantBasDroite(grille,1,1));
    }

    @Test
    public void doit_avoir_1_vivant_alentour(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = false; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = false; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = false; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = true; // bas droit
        assertEquals(1,JeuDeLaVie.nbVivantAlentour(grille, 1, 1));
    }

    @Test
    public void doit_avoir_2_vivant_alentour(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = false; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = true; // bas gauche
        grille[1][0] = false; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = false; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = true; // bas droit
        assertEquals(2,JeuDeLaVie.nbVivantAlentour(grille, 1, 1));
    }

    @Test
    public void doit_avoir_3_vivant_alentour(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = true; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = true; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = true; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit
        assertEquals(3,JeuDeLaVie.nbVivantAlentour(grille, 1, 1));
    }

    @Test
    public void doit_avoir_4_vivant_alentour(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = true; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = true; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = true; // bas
        grille[2][0] = true; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit
        assertEquals(4,JeuDeLaVie.nbVivantAlentour(grille, 1, 1));
    }

    @Test
    public void cellule_morte_avec_3_voisins_vivants_alors_naissance(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = true; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = true; // haut
        grille[1][1] = false; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = true; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit

        assertTrue("La celulle ne va pas naitre",JeuDeLaVie.isNaissance(grille,1,1));
    }

    @Test
    public void cellule_vivante_avec_3_voisins_vivants_alors_survie(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = true; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = true; // haut
        grille[1][1] = true; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = true; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit
        assertTrue("La celulle ne va pas naitre",JeuDeLaVie.isSurvie(grille,1,1));
    }

    @Test
    public void cellule_vivante_avec_2_voisins_vivants_alors_survie(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = true; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = false; // haut
        grille[1][1] = true; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = true; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit
        assertTrue("La celulle ne va pas naitre",JeuDeLaVie.isSurvie(grille,1,1));
    }

    @Test
    public void cellule_vivante_avec_1_voisin_vivant_alors_mort(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = true; // haut gauche
        grille[0][1] = false; // gauche
        grille[0][2] = false; // bas gauche
        grille[1][0] = false; // haut
        grille[1][1] = true; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = false; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit
        assertFalse("La celulle ne va pas mourir",JeuDeLaVie.isSurvie(grille,1,1));
    }

    @Test
    public void cellule_vivante_avec_4_voisin_vivant_alors_mort(){
        Boolean grille [][] = new Boolean[3][3];
        grille[0][0] = true; // haut gauche
        grille[0][1] = true; // gauche
        grille[0][2] = true; // bas gauche
        grille[1][0] = true; // haut
        grille[1][1] = true; // milieu
        grille[1][2] = false; // bas
        grille[2][0] = false; // haut droit
        grille[2][1] = false; // droit
        grille[2][2] = false; // bas droit
        assertFalse("La celulle ne va pas mourir",JeuDeLaVie.isSurvie(grille,1,1));
    }

    @Test
    public void generation(){
        Boolean grille [][] = new Boolean[4][4];
        grille[0][0] = true;
        grille[0][1] = true;
        grille[0][2] = false;
        grille[0][3] = false;
        grille[1][0] = true;
        grille[1][1] = false;
        grille[1][2] = false;
        grille[1][3] = false;
        grille[2][0] = false;
        grille[2][1] = true;
        grille[2][2] = true;
        grille[2][3] = true;
        grille[3][0] = false;
        grille[3][1] = false;
        grille[3][2] = false;
        grille[3][3] = false;
        grille = JeuDeLaVie.generation(grille);
        Boolean grilleGeneration [][] = new Boolean[4][4];
        grilleGeneration[0][0] = true;
        grilleGeneration[0][1] = true;
        grilleGeneration[0][2] = false;
        grilleGeneration[0][3] = false;
        grilleGeneration[1][0] = true;
        grilleGeneration[1][1] = false;
        grilleGeneration[1][2] = false;
        grilleGeneration[1][3] = true;
        grilleGeneration[2][0] = false;
        grilleGeneration[2][1] = true;
        grilleGeneration[2][2] = true;
        grilleGeneration[2][3] = false;
        grilleGeneration[3][0] = false;
        grilleGeneration[3][1] = false;
        grilleGeneration[3][2] = true;
        grilleGeneration[3][3] = false;
        assertArrayEquals(grilleGeneration,grille);
    }
}