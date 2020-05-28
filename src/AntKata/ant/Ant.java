package AntKata.ant;

import AntKata.Random.RNG;

import java.awt.Point;
import java.util.List;


public class Ant {
    private Point position;
    private Status status;
    private Point lastKnownFoodPosition;

    // TODO Attributs

    public Ant(Point positionColony) {
        // TODO
        this.lastKnownFoodPosition = this.position = positionColony;
        this.status = Status.WANDERING;
    }

    private void scatter() {
        int randomX = RNG.random(-1, 1);
        int randomY = RNG.random(-1, 1);

        // TODO
        switch (this.getStatus()){
            case WANDERING:
            case FETCHING_FOOD:
                this.position = new Point(this.getPositionX() + randomX, this.getPositionY() + randomY );
                break;
            case RETURNING_COLONY:
                this.position = new Point(this.getPositionX() - randomX, this.getPositionY() + randomY );
                break;
        }
    }

    // TODO Méthodes de classes

    public int getPositionX() {
        return this.position.x;
    }

    public int getPositionY() {
        return this.position.y;
    }

    public Point getPosition() {
        return this.position;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setPosition(Point point) {
        this.position = new Point(point.x, point.y);
    }

    public Point getLastKnownFoodPosition() {
        return lastKnownFoodPosition;
    }
}
