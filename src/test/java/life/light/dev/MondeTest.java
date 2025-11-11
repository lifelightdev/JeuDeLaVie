package life.light.dev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

 class MondeTest {
    @Test
    void initialise_le_monde_avec_0_cellules_vivante_alors_le_monde_est_vide() {
        Monde monde = new Monde(10);
        Set<Cellule> listeDesCellulesEnVieDansLeMonde = monde.initialiseLeMondeAvec(0);
        assertThat(listeDesCellulesEnVieDansLeMonde).isEmpty();
    }

    @Test
    void initialise_le_monde_avec_1_cellules_vivante_alors_il_y_a_une_cellule_vivante_dans_le_monde() {
        Monde monde = new Monde(10);
        Set<Cellule> listeDesCellulesEnVieDansLeMonde = monde.initialiseLeMondeAvec(1);
        assertThat(listeDesCellulesEnVieDansLeMonde.size()).isEqualTo(1);
    }

    static Stream<Arguments> configurationsNombreVoisineVivante() {
        return Stream.of(
                Arguments.of(Set.of(new Cellule(0, 0)), 1),
                Arguments.of(Set.of(new Cellule(0, 0), new Cellule(0, 1)), 2),
                Arguments.of(Set.of(new Cellule(0, 0), new Cellule(1, 1)), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("configurationsNombreVoisineVivante")
    void compte_le_nombre_de_cellule_voisine_vivante(Set<Cellule> cellulesVivantes, int nombreCellulesVoisineVivante) {
        Monde monde = new Monde(3);
        int nombreDeVoisinesVivantes = monde.nombreDeCellulesVoisinesVivantes(new Cellule(1, 1), cellulesVivantes);
        assertThat(nombreDeVoisinesVivantes).isEqualTo(nombreCellulesVoisineVivante);
    }

    static Stream<Arguments> configurationsNombreVoisineVivanteDansLeMonde() {
        return Stream.of(
                Arguments.of(5, new Cellule(1, 1),
                        Set.of(new Cellule(0, 0), new Cellule(4, 4)), 1),
                Arguments.of(5, new Cellule(1, 1),
                        Set.of(new Cellule(0, 0), new Cellule(0, 1)), 2),
                Arguments.of(5, new Cellule(1, 1),
                        Set.of(new Cellule(0, 0), new Cellule(1, 1)), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("configurationsNombreVoisineVivanteDansLeMonde")
    void compte_le_nombre_de_cellule_voisine_vivante(int tailleDuMonde, Cellule cellule, Set<Cellule> cellulesVivantes, int nombreCellulesVoisineVivante) {
        Monde monde = new Monde(tailleDuMonde);
        int nombreDeVoisinesVivantes = monde.nombreDeCellulesVoisinesVivantes(cellule, cellulesVivantes);
        assertThat(nombreDeVoisinesVivantes).isEqualTo(nombreCellulesVoisineVivante);
    }

    static Stream<Arguments> configurationsNaissance() {
        return Stream.of(
                Arguments.of(3,
                        Set.of(new Cellule(0, 1),
                                new Cellule(1, 2),
                                new Cellule(2, 0)),
                        Set.of(new Cellule(1, 1))),
                Arguments.of(5,
                        Set.of(new Cellule(1, 2),
                                new Cellule(2, 3),
                                new Cellule(3, 1)),
                        Set.of(new Cellule(2, 2)))
        );
    }

    @ParameterizedTest
    @MethodSource("configurationsNaissance")
    void une_cellule_morte_avec_3_voisines_vivante_nait(int tailleDuMonde,
                                                        Set<Cellule> cellulesVivanteAvantGeneration,
                                                        Set<Cellule> cellulesVivanteApresGeneration) {
        Monde monde = new Monde(tailleDuMonde);
        Set<Cellule> listeDesCellulesEnVieDansLeMondeApresGeneration =
                monde.nouvelleGeneration(cellulesVivanteAvantGeneration);
        assertThat(listeDesCellulesEnVieDansLeMondeApresGeneration.size()).isEqualTo(1);
        assertThat(listeDesCellulesEnVieDansLeMondeApresGeneration).containsAll(cellulesVivanteApresGeneration);
    }

    @Test
    void une_cellule_vivante_avec_2_ou_3_voisines_vivante_reste_vivante() {
        Monde monde = new Monde(3);
        Set<Cellule> cellulesVivanteAvantGeneration = Set.of(new Cellule(0, 0),
                new Cellule(0, 1),
                new Cellule(1, 0),
                new Cellule(1, 1));
        Set<Cellule> cellulesVivanteApresGeneration = Set.of(new Cellule(0, 0),
                new Cellule(0, 1),
                new Cellule(1, 0),
                new Cellule(1, 1));
        Set<Cellule> listeDesCellulesEnVieDansLeMondeApresGeneration =
                monde.nouvelleGeneration(cellulesVivanteAvantGeneration);
        assertThat(listeDesCellulesEnVieDansLeMondeApresGeneration).containsAll(cellulesVivanteApresGeneration);
    }

    static Stream<Arguments> configurationsCroix() {
        return Stream.of(
                Arguments.of(
                        Set.of(new Cellule(0, 1),
                                new Cellule(1, 1),
                                new Cellule(2, 1)),

                        Set.of(new Cellule(1, 0),
                                new Cellule(1, 1),
                                new Cellule(1, 2))),
                Arguments.of(
                        Set.of(new Cellule(1, 0),
                                new Cellule(1, 1),
                                new Cellule(1, 2)),

                        Set.of(new Cellule(0, 1),
                                new Cellule(1, 1),
                                new Cellule(2, 1)))
        );
    }

    @ParameterizedTest
    @MethodSource("configurationsCroix")
    void afficher_de_la_croix(
            Set<Cellule> cellulesVivanteAvantGeneration,
            Set<Cellule> cellulesVivanteApresGeneration) {
        Monde monde = new Monde(3);
        Set<Cellule> listeDesCellulesEnVieDansLeMondeApresGeneration =
                monde.nouvelleGeneration(cellulesVivanteAvantGeneration);
        assertThat(listeDesCellulesEnVieDansLeMondeApresGeneration).containsAll(cellulesVivanteApresGeneration);
    }
}
