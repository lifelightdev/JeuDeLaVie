package life.light.dev;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VoisinageTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isVivantHautGauche() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, true); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La cellule voisine en haut à gauche est morte.", Voisinage.isVivantHautGauche(grille,coordonnees));
    }

    @Test
    public void isMortHautGauche() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine en haut à gauche est vivante.", Voisinage.isVivantHautGauche(grille,coordonnees));
    }

    @Test
    public void isVivantHaut() {
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
        assertTrue("La cellule voisine en haut  est morte.", Voisinage.isVivantHaut(grille,coordonnees));
    }

    @Test
    public void isMortHaut() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine en haut  est vivant.", Voisinage.isVivantHaut(grille,coordonnees));
    }

    @Test
    public void isVivantHautDroite() {
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
        assertTrue("La cellule voisine en haut à droite est morte.", Voisinage.isVivantHautDroite(grille,coordonnees));
    }

    @Test
    public void isMortHautDroite() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine en haut à droite est vivante.", Voisinage.isVivantHautDroite(grille,coordonnees));
    }

    @Test
    public void isVivantGauche() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, true); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La cellule voisine à gauche est morte.", Voisinage.isVivantGauche(grille,coordonnees));
    }

    @Test
    public void isMortGauche() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine à gauche est vivante.", Voisinage.isVivantGauche(grille,coordonnees));
    }

    @Test
    public void isVivantDroite() {
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
        assertTrue("La cellule voisine  à droite est morte.", Voisinage.isVivantDroite(grille,coordonnees));
    }

    @Test
    public void isMortDroite() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine  à droite est vivante.", Voisinage.isVivantDroite(grille,coordonnees));
    }

    @Test
    public void isVivantBasGauche() {
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
        assertTrue("La cellule voisine en bas à gauche est morte.", Voisinage.isVivantBasGauche(grille,coordonnees));
    }

    @Test
    public void isMortBasGauche() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine en bas à gauche est vivant.", Voisinage.isVivantBasGauche(grille,coordonnees));
    }

    @Test
    public void isVivantBas() {
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
        assertTrue("La cellule voisine en bas est morte.", Voisinage.isVivantBas(grille,coordonnees));
    }

    @Test
    public void isMortBas() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine en bas est vivante.", Voisinage.isVivantBas(grille,coordonnees));
    }

    @Test
    public void isVivantBasDroite() {
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
        assertTrue("La cellule voisine en haut à droite est morte.", Voisinage.isVivantBasDroite(grille,coordonnees));
    }

    @Test
    public void isMortBasDroite() {
        Grille grille = new Grille(3);
        grille.setCellule(0, 0, false); // haut gauche
        grille.setCellule(0, 1, false); // gauche
        grille.setCellule(0, 2, false); // bas gauche
        grille.setCellule(1, 0, false); // haut
        grille.setCellule(1, 1, false); // milieu
        grille.setCellule(1, 2, false); // bas
        grille.setCellule(2, 0, false); // haut droit
        grille.setCellule(2, 1, false); // droit
        grille.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine en haut à droite est vivante.", Voisinage.isVivantBasDroite(grille,coordonnees));
    }
}