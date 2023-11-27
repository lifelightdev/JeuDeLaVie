package life.light.dev;

import java.util.HashSet;
import java.util.Set;

public class WorldGenerationForCellAlive extends World implements GenerationStrategie {

    public WorldGenerationForCellAlive(World newWorld) {
        super(newWorld.cellsAlive, newWorld.size);
    }

    @Override
    public World newGeneration() {
        Set<Cell> newCellsAlive = new HashSet<>();
        for (Cell cell: cellsAlive){
            if (isAliveNextGeneration(cell)) {
                newCellsAlive.add(cell);
            }
        }
        return new World(newCellsAlive, size);
    }
}
