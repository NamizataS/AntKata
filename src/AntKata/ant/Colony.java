package AntKata.ant;

import AntKata.ant.Ant;
import AntKata.ant.CellType;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Colony {
    private List<Ant> ants;
    private Point position;
    private int foodCollected;

    public Colony(int nbAnts, Point position) {
        // TODO
        this.ants = new ArrayList<>();
        this.position = position;
        this.foodCollected = 0;

        for ( int i = 0; i < nbAnts; i++ ){
            ants.add( new Ant(position) ); //add an ant while the nbAnts is not reached
        }
    }

    public int next(List<Point> food) {
        // TODO
        //to communicate food location if in the same cell
        int i, j;
        for ( i = 0; i < ants.size() - 1; i++ ){
            for ( j = 1; j < ants.size(); j++ ){
                if ( ants.get(i).getPosition().equals( ants.get(j).getPosition() ) ) {
                    if ( ants.get(i).getStatus().equals(Status.FETCHING_FOOD) || ants.get(i).getStatus().equals( Status.RETURNING_COLONY)  ){ //if the first ant is fetching food or returning to colony she communicates the position of the food to the second ant
                        ants.get(j).setLastKnownFoodPosition( ants.get(i).getLastKnownFoodPosition() ); //the new lastKnownFoodPosition of j is i's one
                        ants.get(j).setStatus( Status.FETCHING_FOOD ); //the status is npw FETCHING_FOOD if the previous one wasn't
                    } else if ( ants.get(j).getStatus().equals( Status.FETCHING_FOOD ) || ants.get(j).getStatus().equals( Status.RETURNING_COLONY ) ){
                        ants.get(i).setLastKnownFoodPosition( ants.get(j).getLastKnownFoodPosition() );
                        ants.get(i).setStatus( Status.FETCHING_FOOD);
                    }
                }
            }
        }

        for ( Ant ant : new ArrayList<>(this.ants) ){
            switch ( ant.getStatus() ) {
                case WANDERING -> ant.foodPosition( food ); //if the ant is wandering and finds food
                case RETURNING_COLONY -> {
                    if( ant.antPositionColony()) { //if the ant is on colony
                        this.foodCollected ++;
                    }
                }
            }
            ant.scatter();
        }
        return foodCollected;
    }

    public List<Ant> getAnts() {
        return ants;
    }

    public int getPositionX() { return position.x; }

    public int getPositionY() {
        return position.y;
    }

    public int getFoodCollected() {
        return foodCollected;
    }
}
