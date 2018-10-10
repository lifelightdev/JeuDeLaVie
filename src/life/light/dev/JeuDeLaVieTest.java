package life.light.dev;

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
    public void doit_initialiser_grille_de_2_par_2_a_mort() {
        Grille grille = new Grille(2);
        Grille grilleResultat = new Grille(2);
        grilleResultat.setCellule(0,0,false);
        grilleResultat.setCellule(0,1, false);
        grilleResultat.setCellule(1,0, false);
        grilleResultat.setCellule(1,1, false);
        assertTrue("La grille n'est pas égale au résultat attendu.",grilleResultat.equals(grille));
    }

    @Test
    public void doit_ajouter_3_vivant_dans_grille_de_2_par_2() {
        Grille grille = new Grille(2);
        grille.init_vivant( 3);
        int nbVivantCreer = 0;
        for (int colonne = 0; colonne < 2; colonne++) {
            for (int ligne = 0; ligne < 2; ligne++) {
                Coordonnees coordonnees = new Coordonnees(colonne, ligne);
                if (grille.getCellule(coordonnees).isVivant()) {
                    nbVivantCreer++;
                }
            }
        }
        assertEquals(3, nbVivantCreer);
    }

    @Test
    public void doit_etre_vrai_si_celulle_en_haut_a_gauche_de_celulle_courante_est_vivante() {
        // Interrogation : c'est bien comme ça que l'on doit utiliser assertTrue ?
        Grille grille = new Grille(3);
        grille.setCellule(0,0, true); // haut gauche
        grille.setCellule(0,1, false); // gauche
        grille.setCellule(0,2, false); // bas gauche
        grille.setCellule(1,0, false); // haut
        grille.setCellule(1,1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle en haut à gauche de la celulle courante est morte", Voisinage.isVivantHautGauche(grille, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_en_haut_de_celulle_courante_est_vivante() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, true); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        Assert.assertTrue("La celulle en haut de la celulle courante est morte", Voisinage.isVivantHaut(grille, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_en_haut_a_droite_de_celulle_courante_est_vivante() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, true); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle en haut à droit de la celulle courante est morte", Voisinage.isVivantHautDroite(grille, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_a_gauche_de_celulle_courante_est_vivante() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, true); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1,  false); // milieu
        grille.setCellule(1, 2,  false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle à gauche de la celulle courante est morte", Voisinage.isVivantGauche(grille, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_a_droite_de_celulle_courante_est_vivante() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, true); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle à droite de la celulle courante est morte", Voisinage.isVivantDroite(grille, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_en_bas_a_gauche_de_celulle_courante_est_vivante() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, true); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle en bas à gauche de la celulle courante est morte", Voisinage.isVivantBasGauche(grille, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_en_bas_de_celulle_courante_est_vivante() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, true); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle en bas de la celulle courante est morte", Voisinage.isVivantBas(grille, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_en_bas_a_droite_de_celulle_courante_est_vivante() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, true); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle en bas à droite de la celulle courante est morte", Voisinage.isVivantBasDroite(grille, coordonnees));
    }

    @Test
    public void doit_avoir_1_vivant_alentour() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, true); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertEquals(1, grille.nbVivantAlentour(coordonnees));
    }

    @Test
    public void doit_avoir_2_vivant_alentour() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, true); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, true); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertEquals(2, grille.nbVivantAlentour(coordonnees));
    }

    @Test
    public void doit_avoir_3_vivant_alentour() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, true); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, true); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, true); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertEquals(3, grille.nbVivantAlentour(coordonnees));
    }

    @Test
    public void doit_avoir_4_vivant_alentour() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, true); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, true); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, true); // bas
        grille.setCellule(2, 0, true); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertEquals(4, grille.nbVivantAlentour(coordonnees));
    }

    @Test
    public void doit_naitre_avec_cellule_morte_et_3_voisins_vivants() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, true); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, true); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, true); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle ne va pas naitre", grille.isNaissance(coordonnees));
    }

    @Test
    public void doit_survivre_avec_cellule_vivante_et_3_voisins_vivants() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, true); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, true); // haut
        grille.setCellule(1, 1, true); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, true); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle ne va pas survivre.", grille.isSurvie(coordonnees));
    }

    @Test
    public void doit_survivre_avec_cellule_vivante_et_2_voisins_vivants() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, true); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, true); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, true); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle ne va pas survivre", grille.isSurvie(coordonnees));
    }

    @Test
    public void doit_mourir_avec_cellule_vivante_et_1_voisin_vivant() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, true); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, true); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La celulle ne va pas mourir", grille.isSurvie(coordonnees));
    }

    @Test
    public void doit_mourir_avec_cellule_vivante_et_4_voisins_vivants() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, true); // haut gauche
        grille.setCellule(0, 1, true); // gauche
        grille.setCellule(0, 2, true); // bas gauche
        grille.setCellule(1, 0, true); // haut
        grille.setCellule(1, 1, true); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La celulle ne va pas mourir", grille.isSurvie(coordonnees));
    }

    @Test
    public void doit_generer() {
        Grille grille = new Grille(4);
        grille.setCellule(0, 0, true);
        grille.setCellule(0, 1, true);
        grille.setCellule(0, 2, false);
        grille.setCellule(0, 3, false);
        grille.setCellule(1, 0, true);
        grille.setCellule(1, 1, false);
        grille.setCellule(1, 2, false);
        grille.setCellule(1, 3, false);
        grille.setCellule(2, 0, false);
        grille.setCellule(2, 1, true);
        grille.setCellule(2, 2, true);
        grille.setCellule(2, 3, true);
        grille.setCellule(3, 0, false);
        grille.setCellule(3, 1, false);
        grille.setCellule(3, 2,  false);
        grille.setCellule(3, 3,  false);
        grille = JeuDeLaVie.generation(grille);
        Grille grilleGeneration = new Grille(4);
        grilleGeneration.setCellule(0, 0,  true);
        grilleGeneration.setCellule(0, 1,  true);
        grilleGeneration.setCellule(0, 2,  false);
        grilleGeneration.setCellule(0, 3,  false);
        grilleGeneration.setCellule(1, 0,  true);
        grilleGeneration.setCellule(1, 1,  false);
        grilleGeneration.setCellule(1, 2,  false);
        grilleGeneration.setCellule(1, 3,  true);
        grilleGeneration.setCellule(2, 0,  false);
        grilleGeneration.setCellule(2, 1,  true);
        grilleGeneration.setCellule(2, 2,  true);
        grilleGeneration.setCellule(2, 3,  false);
        grilleGeneration.setCellule(3, 0,  false);
        grilleGeneration.setCellule(3, 1,  false);
        grilleGeneration.setCellule(3, 2,  true);
        grilleGeneration.setCellule(3, 3,  false);
        assertEquals(grilleGeneration, grille);
    }
}