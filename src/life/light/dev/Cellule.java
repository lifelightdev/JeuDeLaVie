package life.light.dev;

public class Cellule {
    Boolean valeur;

    Cellule(){
        valeur = false;
    }

    public Boolean getValeur() {
        return valeur;
    }

    public void setValeur(Boolean valeur) {
        this.valeur = valeur;
    }

    public Boolean isVivant(){
        return valeur;
    }

    public Boolean isMort(){
        return !valeur;
    }
}
