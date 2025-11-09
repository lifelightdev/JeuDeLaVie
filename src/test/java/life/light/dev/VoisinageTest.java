package life.light.dev;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VoisinageTest {

    @Test
    public void isVivantHautGauche() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, true); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La cellule voisine en haut à gauche est morte.", Voisinage.isVivantHautGauche(monde, coordonnees));
    }

    @Test
    public void isMortHautGauche() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine en haut à gauche est vivante.", Voisinage.isVivantHautGauche(monde, coordonnees));
    }

    @Test
    public void isVivantHaut() {
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
        assertTrue("La cellule voisine en haut  est morte.", Voisinage.isVivantHaut(monde, coordonnees));
    }

    @Test
    public void isMortHaut() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine en haut  est vivant.", Voisinage.isVivantHaut(monde, coordonnees));
    }

    @Test
    public void isVivantHautDroite() {
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
        assertTrue("La cellule voisine en haut à droite est morte.", Voisinage.isVivantHautDroite(monde, coordonnees));
    }

    @Test
    public void isMortHautDroite() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine en haut à droite est vivante.", Voisinage.isVivantHautDroite(monde, coordonnees));
    }

    @Test
    public void isVivantGauche() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, true); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertTrue("La cellule voisine à gauche est morte.", Voisinage.isVivantGauche(monde, coordonnees));
    }

    @Test
    public void isMortGauche() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine à gauche est vivante.", Voisinage.isVivantGauche(monde, coordonnees));
    }

    @Test
    public void isVivantDroite() {
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
        assertTrue("La cellule voisine  à droite est morte.", Voisinage.isVivantDroite(monde, coordonnees));
    }

    @Test
    public void isMortDroite() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine  à droite est vivante.", Voisinage.isVivantDroite(monde, coordonnees));
    }

    @Test
    public void isVivantBasGauche() {
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
        assertTrue("La cellule voisine en bas à gauche est morte.", Voisinage.isVivantBasGauche(monde, coordonnees));
    }

    @Test
    public void isMortBasGauche() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine en bas à gauche est vivant.", Voisinage.isVivantBasGauche(monde, coordonnees));
    }

    @Test
    public void isVivantBas() {
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
        assertTrue("La cellule voisine en bas est morte.", Voisinage.isVivantBas(monde, coordonnees));
    }

    @Test
    public void isMortBas() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine en bas est vivante.", Voisinage.isVivantBas(monde, coordonnees));
    }

    @Test
    public void isVivantBasDroite() {
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
        assertTrue("La cellule voisine en haut à droite est morte.", Voisinage.isVivantBasDroite(monde, coordonnees));
    }

    @Test
    public void isMortBasDroite() {
        Monde monde = new Monde(3);
        monde.setCellule(0, 0, false); // haut gauche
        monde.setCellule(0, 1, false); // gauche
        monde.setCellule(0, 2, false); // bas gauche
        monde.setCellule(1, 0, false); // haut
        monde.setCellule(1, 1, false); // milieu
        monde.setCellule(1, 2, false); // bas
        monde.setCellule(2, 0, false); // haut droit
        monde.setCellule(2, 1, false); // droit
        monde.setCellule(2, 2, false); // bas droit
        Coordonnees coordonnees = new Coordonnees(1, 1);
        assertFalse("La cellule voisine en haut à droite est vivante.", Voisinage.isVivantBasDroite(monde, coordonnees));
    }
}