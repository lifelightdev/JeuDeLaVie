package life.light.dev;

public class Coordonnees {

    private int colonne = 0;
    private int ligne = 0;

    Coordonnees (){
        colonne = 0;
        ligne = 0;
    }

    Coordonnees(int colonne, int ligne){
        this.colonne = colonne;
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setCoordonnees(int colonne, int ligne){
        this.colonne = colonne;
        this.ligne = ligne;
    }
}
