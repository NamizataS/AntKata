package AntKata;

import java.awt.*;

public class Food {
    private Point position;
    private int life_cycle; //the life cycle of a food
    // TODO Attributs à rajouter pour gérer le cycle de vie

    public Point getPosition() {
        return position;
    }

    public Food(int x, int y) {
        // TODO
        this.position = new Point(x,y); //the food is going to have a position given by the parameters
        this.life_cycle = 0; //the life cycle starts at 0
    }

    public boolean isAlive() {
        // TODO
        return this.life_cycle < 1800; //a food stay while his life cycle hasn't reach 1800
    }

    public void nextTurn() {
        // TODO
        this.life_cycle ++;
    }

    public int getLife_cycle() {
        return life_cycle;
    }

    public void setLife_cycle(int life_cycle) {
        this.life_cycle = life_cycle;
    }
}
