package life.light.dev;

public class Voisinage {

    public static Boolean isVivantHautGauche(Monde monde, Coordonnees coordonnees) {
        Coordonnees coordonneesHautGauche = new Coordonnees();
        coordonneesHautGauche.setColonne( coordonnees.getColonne() - 1);
        coordonneesHautGauche.setLigne( coordonnees.getLigne() - 1);
        return getCelluleDansGrille(monde, coordonneesHautGauche);
    }

    public static Boolean isVivantHaut (Monde monde, Coordonnees coordonnees) {
        Coordonnees coordonneesHaut = new Coordonnees();
        coordonneesHaut.setColonne( coordonnees.getColonne() );
        coordonneesHaut.setLigne( coordonnees.getLigne() - 1);
        return getCelluleDansGrille(monde, coordonneesHaut);
    }

    public static Boolean isVivantHautDroite (Monde monde, Coordonnees coordonnees) {
        Coordonnees coordonneesHautDroite = new Coordonnees();
        coordonneesHautDroite.setColonne( coordonnees.getColonne() + 1);
        coordonneesHautDroite.setLigne( coordonnees.getLigne() - 1);
        return getCelluleDansGrille(monde, coordonneesHautDroite);
    }

    public static Boolean isVivantGauche (Monde monde, Coordonnees coordonnees) {
        Coordonnees coordonneesGauche = new Coordonnees();
        coordonneesGauche.setColonne( coordonnees.getColonne() - 1);
        coordonneesGauche.setLigne( coordonnees.getLigne());
        return getCelluleDansGrille(monde, coordonneesGauche);
    }

    public static Boolean isVivantDroite (Monde monde, Coordonnees coordonnees) {
        Coordonnees coordonneesDroite = new Coordonnees();
        coordonneesDroite.setColonne( coordonnees.getColonne() + 1);
        coordonneesDroite.setLigne( coordonnees.getLigne());
        return getCelluleDansGrille(monde, coordonneesDroite);
    }

    public static Boolean isVivantBasGauche (Monde monde, Coordonnees coordonnees) {
        Coordonnees coordonneesBasGauche = new Coordonnees();
        coordonneesBasGauche.setColonne( coordonnees.getColonne() - 1);
        coordonneesBasGauche.setLigne( coordonnees.getLigne() + 1);
        return getCelluleDansGrille(monde, coordonneesBasGauche);
    }

    public static Boolean isVivantBas(Monde monde, Coordonnees coordonnees) {
        Coordonnees coordonneesBas = new Coordonnees();
        coordonneesBas.setColonne( coordonnees.getColonne());
        coordonneesBas.setLigne( coordonnees.getLigne() + 1);
        return getCelluleDansGrille(monde, coordonneesBas);
    }

    public static Boolean isVivantBasDroite(Monde monde, Coordonnees coordonnees) {
        Coordonnees coordonneesBasDroite = new Coordonnees();
        coordonneesBasDroite.setColonne( coordonnees.getColonne() + 1);
        coordonneesBasDroite.setLigne( coordonnees.getLigne() + 1);
        return getCelluleDansGrille(monde, coordonneesBasDroite);
    }

    private static Boolean getCelluleDansGrille (Monde monde, Coordonnees coordonnees) {
        if (monde.isDansGrille(coordonnees)){
            return monde.getCellule(coordonnees).getValeur();
        } else {
            return false;
        }
    }
}
