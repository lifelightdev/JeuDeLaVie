package life.light.dev;

import java.awt.*;
import javax.swing.JPanel;

public class Panel extends JPanel {

  private static final int CELL_SIZE = 10;
  public static final Color CELL_COLOR = Color.black;
  public static final Color WORLD_BACKGROUND = Color.white;

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
    repaintBackground(g);
    paintAliveCells(g);
  }

  private void paintAliveCells(Graphics g) {
    g.setColor(CELL_COLOR);
    world.getCellsAlive()
        .stream()
        .forEach(cell -> paintCell(g, cell.x, cell.y));
  }

  private static void paintCell(Graphics g, int x, int y) {
    g.fillRect(
        x * CELL_SIZE,
        y * CELL_SIZE,
        CELL_SIZE, CELL_SIZE);
  }

  private void repaintBackground(Graphics g) {
    g.setColor(WORLD_BACKGROUND);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
  }

  public void setWorld(World world) {
        this.world = world;
    }

  public World getWorld() {
    return world;
  }

  public void nextGeneration() {
    world = world.newGeneration();
    revalidate();
    repaint();
  }
}
