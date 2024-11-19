package org.example.operation;

import org.example.MarsRover;
import org.example.constant.Direction;

public class SouthOperation extends BaseOperation {

    @Override
    public void turnLeft(MarsRover marsRover) {
        marsRover.setDirection(Direction.E.name());
    }

    @Override
    public void turnRight(MarsRover marsRover) {
        marsRover.setDirection(Direction.W.name());
    }

    @Override
    public void forward(MarsRover marsRover) {
        marsRover.setY(marsRover.getY() - 1);
    }
    @Override
    public void backward(MarsRover marsRover) {
        marsRover.setY(marsRover.getY() + 1);
    }
}
