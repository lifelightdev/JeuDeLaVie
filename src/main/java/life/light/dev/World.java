package life.light.dev;

import java.util.*;

public class World {

    private Set<Cell> cellsAlive;
    private int size;

    public World(Set<Cell> cellsAlive, int size) {
        this.cellsAlive = cellsAlive;
      this.size = size;
    }

    // zero ou un voisin vivant → mort par solitude
    // deux voisins vivant → ne change pas d'état
    // trois voisins vivant → naissance
    // quatre et plus de voisin vivant → mort par sur population

    public boolean isAlive(Cell cell) {
        if (neighbor(cell) == 2) {
            if (cellsAlive.contains(cell)) {
                return true;
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
        if (cellsAlive.contains(findCell)){
            return nbNeighbor+1;
        }
        return nbNeighbor;
    }

    public World newGeneration() {
        Set<Cell> newCellsAlive = new HashSet<>();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Cell cell = new Cell(x, y);
                if (isAlive(cell)) {
                    newCellsAlive.add(cell);
                }
            }
        }
        return new World(newCellsAlive, 80);
    }

  public Set<Cell> getCellsAlive() {
    return cellsAlive;
  }

  public int getSize() {
    return size;
  }
}
