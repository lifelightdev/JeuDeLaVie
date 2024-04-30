package life.light.dev;

import java.awt.*;
import javax.swing.JPanel;

public class Panel extends JPanel {
  private static final int CELL_SIZE = 10;

  private World world;

  public Panel(World world) {
    super();
    this.world = world;
    setPreferredSize(
        new Dimension(
            world.getSize() * CELL_SIZE,
            world.getSize() * CELL_SIZE
        )
    );
  }


  public void paintComponent(Graphics g){
        //On choisit une couleur de fond pour le rectangle
        g.setColor(Color.white);
        //On le dessine de sorte qu'il occupe toute la surface
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);

        for (Cell cell : world.getCellsAlive()) {
            g.fillRect(cell.x*CELL_SIZE, cell.y*CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
