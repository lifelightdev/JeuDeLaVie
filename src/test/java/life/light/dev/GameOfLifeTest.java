package test.life.light.dev;

import life.light.dev.Cell;
import life.light.dev.Tools;
import life.light.dev.World;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class GameOfLifeTest {

    // zero ou une voisine vivante = mort par solitude
    // deux voisines vivantes = ne change pas d'état
    // trois voisines vivantes = naissance
    // quatre et plus de voisine vivante = mort par surpopulation

    // -1,-1|-1,0|-1,1
    //  0,-1| 0,0| 0,1
    //  1,-1| 1,0| 1,1

    @Test
    public void no_neighbor(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        World world = new World(cellsAlive);
        assertEquals("0 voisin",0, world.neighbor(cell));
    }

    @Test
    public void one_neighbour(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        World world = new World(cellsAlive);
        assertEquals("1 voisin",1, world.neighbor(cell));
    }

    @Test
    public void two_neighbour(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        World world = new World(cellsAlive);
        assertEquals("2 voisins",2,world.neighbor(cell));
    }

    @Test
    public void death_by_loneliness_with_no_neighbour(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        World world = new World(cellsAlive);
        assertFalse("Mort par solitude",world.isAlive(cell));
    }

    @Test
    public void death_by_loneliness_with_one_neighbour(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        World world = new World(cellsAlive);
        assertFalse("Mort par solitude",world.isAlive(cell));
    }

    @Test
    public void stay_dead(){
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        World world = new World(cellsAlive);
        Cell cell = new Cell(0,0);
        assertFalse("Reste morte",world.isAlive(cell));
    }

    @Test
    public void stay_alive(){
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        Cell cellThree = new Cell(0,0);
        cellsAlive.add(cellThree);
        World world = new World(cellsAlive);
        assertTrue("Reste vivante",world.isAlive(cellThree));
    }

    @Test
    public void birth(){
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        Cell cellThree = new Cell(0,0);
        cellsAlive.add(cellThree);
        World world = new World(cellsAlive);
        Cell cell = new Cell(1,1);
        assertTrue("Naissance",world.isAlive(cell));
    }

    @Test
    public void death_by_over_population(){
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        Cell cellThree = new Cell(1,1);
        cellsAlive.add(cellThree);
        Cell cellFour = new Cell(-1,0);
        cellsAlive.add(cellFour);
        World world = new World(cellsAlive);
        Cell cell = new Cell(0,0);
        assertFalse("Mort par sur population",world.isAlive(cell));
    }

    @Test
    public void a_new_generation(){
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        Cell cellThree = new Cell(1,1);
        cellsAlive.add(cellThree);
        Cell cellFour = new Cell(-1,0);
        cellsAlive.add(cellFour);
        World world = new World(cellsAlive);
        world = world.newGeneration(3);
        assertEquals("Il y a une morte", 3, world.cellsAlive.size());
    }

    @Test
    public void world_initialization(){
        World world = new World(Tools.initWorld(3*8, 3));
        assertEquals("Initialisation du monde", 9, world.cellsAlive.size());
    }
}
