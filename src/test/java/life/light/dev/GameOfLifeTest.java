package life.light.dev;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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
        World world = new World(cellsAlive, 90);
        Assertions.assertThat(world.neighbor(cell)).as("0 neighbor").isEqualTo(0);
    }

    @Test
    public void one_neighbour(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        World world = new World(cellsAlive, 90);
        Assertions.assertThat(world.neighbor(cell)).as("one neighbor").isEqualTo(1);
    }

    @Test
    public void two_neighbour(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        World world = new World(cellsAlive, 90);
        Assertions.assertThat(world.neighbor(cell)).as("two neighbors").isEqualTo(2);
    }

    @Test
    public void death_by_loneliness_with_no_neighbour(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        World world = new World(cellsAlive, 90);
        Assertions.assertThat(world.isAlive(cell)).as("Death by loneliness").isFalse();
    }

    @Test
    public void death_by_loneliness_with_one_neighbour(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        World world = new World(cellsAlive, 90);
        Assertions.assertThat(world.isAlive(cell)).as("Death by loneliness").isFalse();
    }

    @Test
    public void stay_dead(){
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        Cell cellTwo = new Cell(1,0);
        cellsAlive.add(cellTwo);
        World world = new World(cellsAlive, 90);
        Cell cell = new Cell(0,0);
        Assertions.assertThat(world.isAlive(cell)).as("Stay dead").isFalse();
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
        World world = new World(cellsAlive, 90);
        Assertions.assertThat(world.isAlive(cellThree)).as("Stay alive").isTrue();
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
        World world = new World(cellsAlive, 90);
        Cell cell = new Cell(1,1);
        Assertions.assertThat(world.isAlive(cell)).as("Birth").isTrue();
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
        World world = new World(cellsAlive, 90);
        Cell cell = new Cell(0,0);
        Assertions.assertThat(world.isAlive(cell)).as("Death by over population").isFalse();
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
        World world = new World(cellsAlive, 90);
        world = world.newGeneration();
        Assertions.assertThat(world.getCellsAlive().size()).as("There is a dead cell").isEqualTo(3);
    }

    @Test
    @Disabled
    public void world_initialization(){
        World world = Tools.initWorld(3*8, 3);
        Assertions.assertThat(world.getCellsAlive().size()).as("Initialisation du monde").isEqualTo(9);
    }
}
