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
        World world = new World(cellsAlive);
        Assertions.assertThat(world.neighbor(cell)).as("0 neighbor").isEqualTo(0);
    }

    @Test
    public void one_neighbour(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        World world = new World(cellsAlive);
        Assertions.assertThat(world.neighbor(cell)).as("1 voisin").isEqualTo(1);
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
        Assertions.assertThat(world.neighbor(cell)).as("2 voisins").isEqualTo(2);
    }

    @Test
    public void death_by_loneliness_with_no_neighbour(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        World world = new World(cellsAlive);
        Assertions.assertThat(world.isAlive(cell)).as("Mort par solitude").isFalse();
    }

    @Test
    public void death_by_loneliness_with_one_neighbour(){
        Cell cell = new Cell(0,0);
        Set<Cell> cellsAlive = new HashSet<>();
        Cell cellOne = new Cell(0,1);
        cellsAlive.add(cellOne);
        World world = new World(cellsAlive);
        Assertions.assertThat(world.isAlive(cell)).as("Mort par solitude").isFalse();
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
        Assertions.assertThat(world.isAlive(cell)).as("Reste morte").isFalse();
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
        Assertions.assertThat(world.isAlive(cellThree)).as("Reste vivante").isTrue();
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
        Assertions.assertThat(world.isAlive(cell)).as("Naissance").isTrue();
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
        Assertions.assertThat(world.isAlive(cell)).as("Mort par sur population").isFalse();
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
        Assertions.assertThat(world.cellsAlive.size()).as("Il y a une morte").isEqualTo(3);
    }

    @Test
    @Disabled
    public void world_initialization(){
        World world = new World(Tools.initWorld(3*8, 3));
        Assertions.assertThat(world.cellsAlive.size()).as("Initialisation du monde").isEqualTo(9);
    }
}
