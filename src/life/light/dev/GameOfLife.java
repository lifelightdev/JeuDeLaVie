package life.light.dev;

import javax.swing.*;

public class GameOfLife {

    public static void main (String[] arg){
        int size = 9;
        int maxGeneration = 10000;
        int timeBetweenTheNewGeneration = 100;
        World world = new World(Tools.initWorld(size), size);

        //Affichage
        JFrame windows = new JFrame();
        windows.setContentPane(new Panel());

        //Définit un titre de la fenêtre
        windows.setTitle("The game of the life");
        //Définit sa taille
        windows.setSize(size*10+20, size*10+40);
        //Positionne la fenêtre au centre
        windows.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Et enfin, la rendre visible
        windows.setVisible(true);
        Panel pan = new Panel();
        windows.setContentPane(pan);

        for( int nbGeneration = 0; nbGeneration < maxGeneration; nbGeneration ++){
            pan.setWorld(world);
            pan.revalidate();
            pan.repaint();
            try {
                Thread.sleep(timeBetweenTheNewGeneration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            world = new WorldGenerationForAllCell(world).newGeneration();
            // world = new WorldGenerationForCellAlive(world).newGeneration();
        }
    }

}
