package test.life.light.dev;


import life.light.dev.Cell;
import life.light.dev.World;
import life.light.dev.WorldGenerationForAllCell;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class GenerationTest {

    @Test
    public void newGenerationForAllCell() {
        Set<Cell> oldCellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0, 0);
        oldCellsAlive.add(cellOne);
        Cell cellTwo = new Cell(0, 1);
        oldCellsAlive.add(cellTwo);
        Cell cellTree = new Cell(0, 2);
        oldCellsAlive.add(cellTree);
        Cell cellFour = new Cell(2, 1);
        oldCellsAlive.add(cellFour);
        World oldWorld = new World(oldCellsAlive, 3);
        Set<Cell> newCellsAlive = new HashSet<>();
        Cell cellResultOne = new Cell(1,0);
        newCellsAlive.add(cellResultOne);
        Cell cellResultTwo = new Cell(0, 1);
        newCellsAlive.add(cellResultTwo);
        Cell cellResultTree = new Cell(1, 2);
        newCellsAlive.add(cellResultTree);
        World newGeneration = new WorldGenerationForAllCell(oldWorld).newGeneration();
        World resultNexGeneration = new World(newCellsAlive, 3);
        Assert.assertEquals(newGeneration, resultNexGeneration);
    }
}
