package life.light.dev;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JeuDeLaVieTest {

    @Test
    public void doit_initialiser_grille_de_2_par_2_a_mort() {
        Monde monde = new Monde(2);
        Monde mondeResultat = new Monde(2);
        mondeResultat.setCellule(0,0,false);
        mondeResultat.setCellule(0,1, false);
        mondeResultat.setCellule(1,0, false);
        mondeResultat.setCellule(1,1, false);
        assertEquals("La grille n'est pas égale au résultat attendu.", mondeResultat, monde);
    }

    @Test
    public void doit_ajouter_3_vivant_dans_grille_de_2_par_2() {
        Monde monde = new Monde(2);
        monde.initialiseLeMondeAvec( 3);
        int nbVivantCreer = 0;
        for (int colonne = 0; colonne < 2; colonne++) {
            for (int ligne = 0; ligne < 2; ligne++) {
                Coordonnees coordonnees = new Coordonnees(colonne, ligne);
                if (monde.getCellule(coordonnees).isVivant()) {
                    nbVivantCreer++;
                }
            }
        }
        assertEquals(3, nbVivantCreer);
    }

    @Test
    public void doit_etre_vrai_si_celulle_en_haut_a_gauche_de_celulle_courante_est_vivante() {
        // Interrogation : c'est bien comme ça que l'on doit utiliser assertTrue ?
        Monde monde = new Monde(3);
        monde.setCellule(0,0, true); // haut gauche
        monde.setCellule(0,1, false); // gauche
        monde.setCellule(0,2, false); // bas gauche
        monde.setCellule(1,0, false); // haut
        monde.setCellule(1,1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle en haut à gauche de la celulle courante est morte", Voisinage.isVivantHautGauche(monde, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_en_haut_de_celulle_courante_est_vivante() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, true); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        Assert.assertTrue("La celulle en haut de la celulle courante est morte", Voisinage.isVivantHaut(monde, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_en_haut_a_droite_de_celulle_courante_est_vivante() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, true); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle en haut à droit de la celulle courante est morte", Voisinage.isVivantHautDroite(monde, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_a_gauche_de_celulle_courante_est_vivante() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, true); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1,  false); // milieu
        monde.setCellule(1, 2,  false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle à gauche de la celulle courante est morte", Voisinage.isVivantGauche(monde, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_a_droite_de_celulle_courante_est_vivante() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, true); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle à droite de la celulle courante est morte", Voisinage.isVivantDroite(monde, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_en_bas_a_gauche_de_celulle_courante_est_vivante() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, true); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle en bas à gauche de la celulle courante est morte", Voisinage.isVivantBasGauche(monde, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_en_bas_de_celulle_courante_est_vivante() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, true); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle en bas de la celulle courante est morte", Voisinage.isVivantBas(monde, coordonnees));
    }

    @Test
    public void doit_etre_vrai_si_celulle_en_bas_a_droite_de_celulle_courante_est_vivante() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, true); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle en bas à droite de la celulle courante est morte", Voisinage.isVivantBasDroite(monde, coordonnees));
    }

    @Test
    public void doit_avoir_1_vivant_alentour() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, true); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertEquals(1, monde.nbVivantAlentour(coordonnees));
    }

    @Test
    public void doit_avoir_2_vivant_alentour() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, true); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, true); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertEquals(2, monde.nbVivantAlentour(coordonnees));
    }

    @Test
    public void doit_avoir_3_vivant_alentour() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, true); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, true); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, true); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertEquals(3, monde.nbVivantAlentour(coordonnees));
    }

    @Test
    public void doit_avoir_4_vivant_alentour() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, true); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, true); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, true); // bas
        monde.setCellule(2, 0, true); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertEquals(4, monde.nbVivantAlentour(coordonnees));
    }

    @Test
    public void doit_naitre_avec_cellule_morte_et_3_voisins_vivants() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, true); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, true); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, true); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle ne va pas naitre", monde.isNaissance(coordonnees));
    }

    @Test
    public void doit_survivre_avec_cellule_vivante_et_3_voisins_vivants() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, true); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, true); // haut
        monde.setCellule(1, 1, true); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, true); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle ne va pas survivre.", monde.isSurvie(coordonnees));
    }

    @Test
    public void doit_survivre_avec_cellule_vivante_et_2_voisins_vivants() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, true); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, true); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, true); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La celulle ne va pas survivre", monde.isSurvie(coordonnees));
    }

    @Test
    public void doit_mourir_avec_cellule_vivante_et_1_voisin_vivant() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, true); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, true); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La celulle ne va pas mourir", monde.isSurvie(coordonnees));
    }

    @Test
    public void doit_mourir_avec_cellule_vivante_et_4_voisins_vivants() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, true); // haut gauche
        monde.setCellule(0, 1, true); // gauche
        monde.setCellule(0, 2, true); // bas gauche
        monde.setCellule(1, 0, true); // haut
        monde.setCellule(1, 1, true); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La celulle ne va pas mourir", monde.isSurvie(coordonnees));
    }

    @Test
    public void doit_generer() {
        Monde monde = new Monde(4);
        monde.setCellule(0, 0, true);
        monde.setCellule(0, 1, true);
        monde.setCellule(0, 2, false);
        monde.setCellule(0, 3, false);
        monde.setCellule(1, 0, true);
        monde.setCellule(1, 1, false);
        monde.setCellule(1, 2, false);
        monde.setCellule(1, 3, false);
        monde.setCellule(2, 0, false);
        monde.setCellule(2, 1, true);
        monde.setCellule(2, 2, true);
        monde.setCellule(2, 3, true);
        monde.setCellule(3, 0, false);
        monde.setCellule(3, 1, false);
        monde.setCellule(3, 2,  false);
        monde.setCellule(3, 3,  false);
        monde = JeuDeLaVie.generation(monde);
        Monde mondeGeneration = new Monde(4);
        mondeGeneration.setCellule(0, 0,  true);
        mondeGeneration.setCellule(0, 1,  true);
        mondeGeneration.setCellule(0, 2,  false);
        mondeGeneration.setCellule(0, 3,  false);
        mondeGeneration.setCellule(1, 0,  true);
        mondeGeneration.setCellule(1, 1,  false);
        mondeGeneration.setCellule(1, 2,  false);
        mondeGeneration.setCellule(1, 3,  true);
        mondeGeneration.setCellule(2, 0,  false);
        mondeGeneration.setCellule(2, 1,  true);
        mondeGeneration.setCellule(2, 2,  true);
        mondeGeneration.setCellule(2, 3,  false);
        mondeGeneration.setCellule(3, 0,  false);
        mondeGeneration.setCellule(3, 1,  false);
        mondeGeneration.setCellule(3, 2,  true);
        mondeGeneration.setCellule(3, 3,  false);
        assertEquals(mondeGeneration, monde);
    }
}