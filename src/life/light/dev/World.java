package life.light.dev;

import java.util.*;
import java.util.function.Function;

public class World {

    Set<Cell> cellsAlive;
    int size;
    Map<Integer, Function<Cell, Boolean>> cellState = new HashMap<>();

    public World(Set<Cell> cellsAlive, int size) {
        this.cellsAlive = cellsAlive;
        state();
        this.size = size;
    }

    // zero ou un voisin vivant → mort par solitude
    // deux voisins vivant → ne change pas d'état
    // trois voisins vivant → naissance
    // quatre et plus de voisin vivant → mort par sur population

    public boolean isAliveNextGeneration(Cell cell) {
        if (neighbor(cell) == 2) {
            if (cellsAlive.contains(cell)) {
                return true;
            }
        }
        return neighbor(cell) == 3;
    }

    public void state() {
        // On ajoute le nombre de voisins et la fonction qui determine l'état de la cellule
        cellState.put(0, isDead);
        cellState.put(1, isDead);
        cellState.put(2, isSame);
        cellState.put(3, isAlive);
        cellState.put(4, isDead);
        cellState.put(5, isDead);
    }

    private Function<Cell, Boolean> isAlive = cell -> true;
    private Function<Cell, Boolean> isDead = cell -> false;
    private Function<Cell, Boolean> isSame = this::isAliveNextGeneration;

    public boolean addAsAlive(Cell cell) {
        return cellState.get(neighbor(cell)).apply(cell);
    }

    // -1,-1|-1,0|-1,1
    //  0,-1| 0,0| 0,1
    //  1,-1| 1,0| 1,1

    public int neighbor(Cell cell) {
        int nbNeighbor = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if ((x != 0) || (y != 0)) {
                    Cell findCell = new Cell(cell.x + x, cell.y + y);
                    if (cellsAlive.contains(findCell)) {
                        nbNeighbor++;
                    }
                }
            }
        }
        return nbNeighbor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellsAlive, size);
    }

    @Override
    public boolean equals(Object world) {
        if (world instanceof World) {
            return ((World) world).cellsAlive.equals(this.cellsAlive)
                    && ((World) world).size == this.size;
        }
        return false;
    }

    @Override
    public String toString() {
        return "size of world = " + size + " et cellsAlive.size() = " + cellsAlive.size();
    }
}
