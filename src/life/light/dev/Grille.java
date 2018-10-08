package life.light.dev;

public class Grille {

    public static final int NAISSANCE = 3;
    public static final int SURVIE2VIVANTS = 2;
    public static final int SURVIE3VIVANTS = 3;

    private Boolean[][] grille = new Boolean[0][0];
    private Coordonnees coordonnees;
    private int taille;

    Grille(){
        grille = new Boolean[0][0];
        taille = 0;
    }

    Grille(int taille){
        grille = new Boolean[taille][taille];
        this.taille = taille;
    }

    public int getTaille() {
        return taille;
    }

    public Boolean getCellule(Coordonnees coordonnees){
        return grille[coordonnees.getColonne()][coordonnees.getLigne()];
    }

    public void setCellule(Coordonnees coordonnees, Boolean value){
        grille[coordonnees.getColonne()][coordonnees.getLigne()] = value;
    }

    public void setCellule(int colonne, int ligne, Boolean value){
        Coordonnees coordonnees = new Coordonnees(colonne, ligne);
        grille[coordonnees.getColonne()][coordonnees.getLigne()] = value;
    }

    public boolean isDansGrille(Coordonnees coordonnees) {
        if (!isColonneDansGrille(coordonnees)){
            return false;
        }
        if (!isLigneDansGrille(coordonnees)){
            return false;
        }
        return true;
    }

    public boolean isLigneDansGrille(Coordonnees coordonnees) {
        return coordonnees.getLigne() >= 0 && coordonnees.getLigne() < taille;
    }

    public boolean isColonneDansGrille(Coordonnees coordonnees) {
        return coordonnees.getColonne() >= 0 && coordonnees.getColonne() < taille;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public boolean equals (Object grille){
        boolean isEgale = false;
        if (grille instanceof Grille){
            if (((Grille)grille).taille == taille){
                for ( int colonne = 0 ; colonne < taille; colonne++){
                    for ( int ligne = 0 ; ligne < taille; ligne++){
                        Coordonnees coordonnees = new Coordonnees(colonne, ligne);
                        if (!(getCellule(coordonnees) == ((Grille)grille).getCellule(coordonnees))){
                            isEgale = false;
                            break;
                        } else {
                            isEgale = true;
                        }
                    }
                }
            }
        }
        return isEgale;
    }

    public int nbVivantAlentour(Coordonnees coordonnees) {
        int nbVivantAlentour = 0;
        if (Voisinage.isVivantHautGauche(this, coordonnees)) {
            nbVivantAlentour++;
        }
        if (Voisinage.isVivantHaut(this, coordonnees)) {
            nbVivantAlentour++;
        }
        if (Voisinage.isVivantHautDroite(this, coordonnees)) {
            nbVivantAlentour++;
        }
        if (Voisinage.isVivantDroite(this, coordonnees)) {
            nbVivantAlentour++;
        }
        if (Voisinage.isVivantGauche(this, coordonnees)) {
            nbVivantAlentour++;
        }
        if (Voisinage.isVivantDroite(this, coordonnees)) {
            nbVivantAlentour++;
        }
        if (Voisinage.isVivantBasGauche(this, coordonnees)) {
            nbVivantAlentour++;
        }
        if (Voisinage.isVivantBas(this, coordonnees)) {
            nbVivantAlentour++;
        }
        if (Voisinage.isVivantBasDroite(this, coordonnees)) {
            nbVivantAlentour++;
        }
        return nbVivantAlentour;
    }

    public Boolean isNaissance (Coordonnees coordonnees){
        if (!getCellule(coordonnees)) {
            if (nbVivantAlentour(coordonnees) == NAISSANCE) {
                return true;
            }
        }
        return false;
    }

    public Boolean isSurvie (Coordonnees coordonnees){
        if(getCellule(coordonnees)){
            int nbVivantAlentour = nbVivantAlentour(coordonnees);
            if ((nbVivantAlentour != SURVIE2VIVANTS) && (nbVivantAlentour != SURVIE3VIVANTS)) {
                return false;
            }
            return true;
        }
        return false;
    }

}
