package life.light.dev;

import javax.swing.*;

public class GameOfLife extends JFrame {

  private final int worldSize;
  private World world;
  private Panel panel;

  public static void main (String[] arg){
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
        world = world.newGeneration();
        panel.setWorld(world);
        panel.revalidate();
        panel.repaint();
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } while(true);
    }

  private void init() {
    world = Tools.initWorld(worldSize * 8, worldSize);
    panel = new Panel(world);
    setContentPane(panel);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
  }


}
