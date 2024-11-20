package org.example.operation;

import org.example.MarsRover;
import org.example.Position;
import org.example.constant.Direction;

public class WestOperation extends BaseOperation {

    @Override
    public Direction getDirection() {
        return Direction.W;
    }

    @Override
    public void turnLeft(MarsRover marsRover) {
        marsRover.setOperation(new SouthOperation());
    }

    @Override
    public void turnRight(MarsRover marsRover) {
        marsRover.setOperation(new NorthOperation());
    }

    @Override
    public void forward(MarsRover marsRover) {
        Position position = marsRover.getPosition();
        marsRover.setPosition(new Position(position.getX() - 1, position.getY()));
    }

    @Override
    public void backward(MarsRover marsRover) {
        Position position = marsRover.getPosition();
        marsRover.setPosition(new Position(position.getX() + 1, position.getY()));
    }
}
