package life.light.dev;

public class Coordonnees {

    private int colonne;
    private int ligne;

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

}
