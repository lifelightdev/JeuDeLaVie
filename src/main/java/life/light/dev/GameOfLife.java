package life.light.dev;

import javax.swing.*;

public class GameOfLife {

    public static void main (String[] arg){
        int size = 90;
        if (arg.length == 1) {
            size = Integer.parseInt(arg[0]);
        }
        World world = new World(Tools.initWorld(size*8, size));

        //Affichage
        JFrame window = new JFrame();
        Panel pan = new Panel(world);
        window.setContentPane(pan);

        //Définit un titre de la fenêtre
        window.setTitle("Le jeu de la vie");
        //Positionne la fenêtre au centre
        window.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Et enfin, la rendre visible
        window.setVisible(true);
        window.setContentPane(pan);

        for( int nbGeneration = 0; nbGeneration < 10000; nbGeneration ++){
            pan.setWorld(world);
            pan.revalidate();
            pan.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            world = world.newGeneration(size);
        }
    }

}
