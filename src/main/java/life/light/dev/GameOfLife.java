package life.light.dev;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class GameOfLife extends JFrame {

  private final int worldSize;
  private Panel panel;

  public static void main (String[] arg) {
        int size = 90;
        if (arg.length == 1) {
            size = Integer.parseInt(arg[0]);
        }
        new GameOfLife(size).run();
    }

    public GameOfLife(int worldSize) {
      super("Le jeu de la vie");
      this.worldSize = worldSize;
      init();
    }
    public void run() {
      setVisible(true);
      do {
        panel.nextGeneration();
        try {
          TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      } while(true);
    }

  private void init() {
    World world = Tools.initWorld(worldSize * 8, worldSize);
    panel = new Panel(world);
    setContentPane(panel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
  }

}
