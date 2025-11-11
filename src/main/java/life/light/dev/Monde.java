package life.light.dev;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public record Monde(int tailleDuMonde) {

    Set<Cellule> initialiseLeMondeAvec(int nombreDeCelluleVivanteACreer) {
        Set<Cellule> listeDesCellulesEnVieDansLeMonde = new HashSet<>();
        Random rand = new Random();
        int nbdeCelluleVivanteEnCreation = 0;
        while (nbdeCelluleVivanteEnCreation < nombreDeCelluleVivanteACreer) {
            int colonne = rand.nextInt(tailleDuMonde);
            int ligne = rand.nextInt(tailleDuMonde);
            Cellule cellule = new Cellule(colonne, ligne);
            if (!listeDesCellulesEnVieDansLeMonde.contains(cellule)
                    && listeDesCellulesEnVieDansLeMonde.size() < (tailleDuMonde * tailleDuMonde)) {
                listeDesCellulesEnVieDansLeMonde.add(new Cellule(colonne, ligne));
                nbdeCelluleVivanteEnCreation++;
            }
        }
        return listeDesCellulesEnVieDansLeMonde;
    }

    Set<Cellule> nouvelleGeneration(Set<Cellule> celluleVivantesDeLaGenerationPrecedente) {
        Set<Cellule> cellulesVivanteDansLeNouveuMonde = new HashSet<>();
        for (int ligne = 0; ligne < tailleDuMonde; ligne++) {
            for (int colonne = 0; colonne < tailleDuMonde; colonne++) {
                Cellule cellule = new Cellule(ligne, colonne);
                int nombreDeVoisinesVivantes = nombreDeCellulesVoisinesVivantes(cellule, celluleVivantesDeLaGenerationPrecedente);
                if (laCelluleEstMortedansCeMonde(cellule, celluleVivantesDeLaGenerationPrecedente)) {
                    if (nombreDeVoisinesVivantes == 3) {
                        cellulesVivanteDansLeNouveuMonde.add(cellule);
                    }
                } else if (nombreDeVoisinesVivantes == 2 || nombreDeVoisinesVivantes == 3) {
                    cellulesVivanteDansLeNouveuMonde.add(cellule);
                }
            }
        }
        return cellulesVivanteDansLeNouveuMonde;
    }

    private static boolean laCelluleEstMortedansCeMonde(Cellule cellule, Set<Cellule> celluleVivantes) {
        return !celluleVivantes.contains(cellule);
    }


    public int nombreDeCellulesVoisinesVivantes(Cellule cellule, Set<Cellule> cellulesVivantes) {
        int voisinesVivantes = 0;
        for (int ligne = -1; ligne < 2; ligne++) {
            for (int colonne = -1; colonne < 2; colonne++) {
                Cellule celluleVoisine = new Cellule(cellule.ligne() + ligne, cellule.colonne() + colonne);
                if (cellulesVivantes.contains(celluleVoisine) && !celluleVoisine.equals(cellule)) {
                    voisinesVivantes++;
                }
            }
        }
        return voisinesVivantes;
    }
}
