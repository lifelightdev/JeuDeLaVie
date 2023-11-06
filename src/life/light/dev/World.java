package life.light.dev;

import java.util.*;

public class World {

    Set<Cell> cellsAlive = new HashSet<>();

    public World(Set<Cell> cellsAlive) {
        this.cellsAlive = cellsAlive;
    }

    public World() {
    }

    // zero ou un voisin vivant => mort par solitude
    // deux voisin vivant => ne change pas d'état
    // trois voisin vivant => naissance
    // quatre et plus de voisin vivant => mort par sur population

    public boolean isAlive(Cell cell) {
        if (neighbor(cell) == 2) {
            for (Cell c : cellsAlive) {
                if (cell.equals(c)) return true;
            }
        }
        return neighbor(cell) == 3;
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
                    nbNeighbor = getNbNeighbor(findCell, nbNeighbor);
                }
            }
        }
        return nbNeighbor;
    }

    private int getNbNeighbor(Cell findCell, int nbNeighbor) {
        for (Cell cell : cellsAlive) {
            if (cell.equals(findCell)) {
                nbNeighbor++;
                break;
            }
        }
        return nbNeighbor;
    }

    public void initWorld(int nbAliveToCreate, int size) {
        if (cellsAlive.isEmpty()) {
            Random rand = new Random();
            for (int i = 0; i < nbAliveToCreate; i++) {
                int x = rand.nextInt(size);
                int y = rand.nextInt(size);
                Cell cell = new Cell(x, y);
                cellsAlive.add(cell);
            }
        }
    }

    public World newGeneration(int size) {
        Set<Cell> newCellsAlive = new HashSet<>();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Cell cell = new Cell(x, y);
                if (isAlive(cell)) {
                    newCellsAlive.add(cell);
                }
            }
        }
        return new World(newCellsAlive);
    }
}
