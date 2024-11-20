package org.example.operation;

import org.example.MarsRover;
import org.example.Position;
import org.example.constant.Direction;

public class EastOperation extends BaseOperation {

    @Override
    public Direction getDirection() {
        return Direction.E;
    }

    @Override
    public void turnLeft(MarsRover marsRover) {
        marsRover.setOperation(new NorthOperation());
    }

    @Override
    public void turnRight(MarsRover marsRover) {
        marsRover.setOperation(new SouthOperation());
    }

    @Override
    public void forward(MarsRover marsRover) {
        Position position = marsRover.getPosition();
        marsRover.updatePosition(position.getX() + 1, position.getY());
    }

    @Override
    public void backward(MarsRover marsRover) {
        Position position = marsRover.getPosition();
        marsRover.updatePosition(position.getX() - 1, position.getY());
    }
}
