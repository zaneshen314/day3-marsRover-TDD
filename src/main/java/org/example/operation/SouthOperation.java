package org.example.operation;

import org.example.MarsRover;
import org.example.Position;
import org.example.constant.Direction;

public class SouthOperation extends BaseOperation {

    @Override
    public Direction getDirection() {
        return Direction.S;
    }

    @Override
    public void turnLeft(MarsRover marsRover) {
        marsRover.setOperation(new EastOperation());
    }

    @Override
    public void turnRight(MarsRover marsRover) {
        marsRover.setOperation(new WestOperation());
    }

    @Override
    public void forward(MarsRover marsRover) {
        Position position = marsRover.getPosition();
        marsRover.updatePosition(position.getX(), position.getY() - 1);
    }
    @Override
    public void backward(MarsRover marsRover) {
        Position position = marsRover.getPosition();
        marsRover.updatePosition(position.getX(), position.getY() + 1);
    }
}
