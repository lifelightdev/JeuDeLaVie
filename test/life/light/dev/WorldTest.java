package test.life.light.dev;

import life.light.dev.Cell;
import life.light.dev.World;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

public class WorldTest {

    // zero ou une voisine vivante = mort par solitude
    // deux voisines vivante = ne change pas d'état
    // trois voisines vivante = naissance
    // quatre et plus de voisine vivante = mort par surpopulation

    // -1,-1|-1,0|-1,1
    //  0,-1| 0,0| 0,1
    //  1,-1| 1,0| 1,1

    @Test
    public void zero_neighbor(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        World world = new World(cellsAlive,1);
        assertEquals("0 neighbor",world.neighbor(cell),0);
    }

    @Test
    public void one_neighbor(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        World world = new World(cellsAlive,2);
        assertEquals("1 neighbor",world.neighbor(cell),1);
    }

    @Test
    public void two_neighbors(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        World world = new World(cellsAlive,3);
        assertEquals("2 neighbors",world.neighbor(cell),2);
    }

    @Test
    public void zero_neighbor_solitude(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        World world = new World(cellsAlive, 1);
        assertFalse("Death by loneliness",world.isAliveNextGeneration(cell));
    }

    @Test
    public void one_neighbor_solitude(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        World world = new World(cellsAlive, 1);
        assertFalse("Death by loneliness",world.isAliveNextGeneration(cell));
    }

    @Test
    public void two_dead_neighbors(){
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        World world = new World(cellsAlive, 1);
        Cell cell = new Cell(0,0);
        assertFalse("Stay dead",world.isAliveNextGeneration(cell));
    }

    @Test
    public void two_living_neighbors(){
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        Cell cellThree = new Cell(0,0);
        cellsAlive.add(cellThree);
        World world = new World(cellsAlive, 3);
        assertTrue("Stay alive",world.isAliveNextGeneration(cellThree));
    }

    @Test
    public void three_neighbors_birth(){
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        Cell cellThree = new Cell(0,0);
        cellsAlive.add(cellThree);
        World world = new World(cellsAlive, 3);
        Cell cell = new Cell(1,1);
        assertTrue("Birth",world.isAliveNextGeneration(cell));
    }

    @Test
    public void four_neighbors_death(){
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        Cell cellThree = new Cell(1,1);
        cellsAlive.add(cellThree);
        Cell cellFour = new Cell(-1,0);
        cellsAlive.add(cellFour);
        World world = new World(cellsAlive, 3);
        Cell cell = new Cell(0,0);
        assertFalse("Death by over population",world.isAliveNextGeneration(cell));
    }
}
