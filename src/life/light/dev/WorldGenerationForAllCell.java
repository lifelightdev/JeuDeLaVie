package life.light.dev;

import java.util.HashSet;
import java.util.Set;

public class WorldGenerationForAllCell extends World implements GenerationStrategie {

    public WorldGenerationForAllCell(World newWorld) {
        super(newWorld.cellsAlive, newWorld.size);
    }

    @Override
    public World newGeneration() {
        Set<Cell> newCellsAlive = new HashSet<>();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Cell cell = new Cell(x, y);
                if (isAliveNextGeneration(cell)) {
                    newCellsAlive.add(cell);
                }
            }
        }
        return new World(newCellsAlive, size);
    }
}
