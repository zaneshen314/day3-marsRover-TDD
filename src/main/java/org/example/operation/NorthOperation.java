package org.example.operation;

import org.example.MarsRover;
import org.example.Position;
import org.example.constant.Direction;

public class NorthOperation extends BaseOperation {

    @Override
    public Direction getDirection() {
        return Direction.N;
    }

    @Override
    public void turnLeft(MarsRover marsRover) {
        marsRover.setOperation(new WestOperation());
    }

    @Override
    public void turnRight(MarsRover marsRover) {
        marsRover.setOperation(new EastOperation());
    }

    @Override
    public void forward(MarsRover marsRover) {
        Position position = marsRover.getPosition();
        marsRover.updatePosition(position.getX(), position.getY() + 1);
    }

    @Override
    public void backward(MarsRover marsRover) {
        Position position = marsRover.getPosition();
        marsRover.updatePosition(position.getX(), position.getY() - 1);
    }
}
