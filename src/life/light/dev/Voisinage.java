package life.light.dev;

public class Voisinage {

    public static Boolean isVivantHautGauche(Grille grille, Coordonnees coordonnees) {
        Coordonnees coordonneesHautGauche = new Coordonnees();
        coordonneesHautGauche.setColonne( coordonnees.getColonne() - 1);
        coordonneesHautGauche.setLigne( coordonnees.getLigne() - 1);
        return getCellule(grille, coordonneesHautGauche);
    }

    public static Boolean isVivantHaut (Grille grille, Coordonnees coordonnees) {
        Coordonnees coordonneesHaut = new Coordonnees();
        coordonneesHaut.setColonne( coordonnees.getColonne() );
        coordonneesHaut.setLigne( coordonnees.getLigne() - 1);
        return getCellule(grille, coordonneesHaut);
    }

    public static Boolean isVivantHautDroite (Grille grille, Coordonnees coordonnees) {
        Coordonnees coordonneesHautDroite = new Coordonnees();
        coordonneesHautDroite.setColonne( coordonnees.getColonne() + 1);
        coordonneesHautDroite.setLigne( coordonnees.getLigne() - 1);
        return getCellule(grille, coordonneesHautDroite);
    }

    public static Boolean isVivantGauche (Grille grille, Coordonnees coordonnees) {
        Coordonnees coordonneesGauche = new Coordonnees();
        coordonneesGauche.setColonne( coordonnees.getColonne() - 1);
        coordonneesGauche.setLigne( coordonnees.getLigne());
        return getCellule(grille, coordonneesGauche);
    }

    public static Boolean isVivantDroite (Grille grille, Coordonnees coordonnees) {
        Coordonnees coordonneesDroite = new Coordonnees();
        coordonneesDroite.setColonne( coordonnees.getColonne() + 1);
        coordonneesDroite.setLigne( coordonnees.getLigne());
        return getCellule(grille, coordonneesDroite);
    }

    public static Boolean isVivantBasGauche (Grille grille, Coordonnees coordonnees) {
        Coordonnees coordonneesBasGauche = new Coordonnees();
        coordonneesBasGauche.setColonne( coordonnees.getColonne() - 1);
        coordonneesBasGauche.setLigne( coordonnees.getLigne() + 1);
        return getCellule(grille, coordonneesBasGauche);
    }

    public static Boolean isVivantBas(Grille grille, Coordonnees coordonnees) {
        Coordonnees coordonneesBas = new Coordonnees();
        coordonneesBas.setColonne( coordonnees.getColonne());
        coordonneesBas.setLigne( coordonnees.getLigne() + 1);
        return getCellule(grille, coordonneesBas);
    }

    public static Boolean isVivantBasDroite(Grille grille, Coordonnees coordonnees) {
        Coordonnees coordonneesBasDroite = new Coordonnees();
        coordonneesBasDroite.setColonne( coordonnees.getColonne() + 1);
        coordonneesBasDroite.setLigne( coordonnees.getLigne() + 1);
        return getCellule(grille, coordonneesBasDroite);
    }

    private static Boolean getCellule (Grille grille, Coordonnees coordonnees) {
        if (grille.isDansGrille(coordonnees)){
            return grille.getCellule(coordonnees);
        } else {
            return false;
        }
    }
}
