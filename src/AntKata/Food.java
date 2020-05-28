package AntKata;

import java.awt.*;

public class Food {
    private Point position;
    private int life_cycles;
    // TODO Attributs à rajouter pour gérer le cycle de vie

    public Point getPosition() {
        return position;
    }

    public Food(int x, int y) {
        // TODO
        this.position = new Point(x,y);
        this.life_cycles = 0;
    }

    public boolean isAlive() {
        // TODO
        return this.life_cycles < 1800;
    }

    public void nextTurn() {
        // TODO
        this.life_cycles ++;
    }
}
