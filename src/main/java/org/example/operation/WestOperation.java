package org.example.operation;

import org.example.MarsRover;
import org.example.constant.Direction;

public class WestOperation extends BaseOperation {

    @Override
    public void turnLeft(MarsRover marsRover) {
        marsRover.setDirection(Direction.S.name());
    }

    @Override
    public void turnRight(MarsRover marsRover) {
        marsRover.setDirection(Direction.N.name());
    }

    @Override
    public void forward(MarsRover marsRover) {
        marsRover.setX(marsRover.getX() - 1);
    }

    @Override
    public void backward(MarsRover marsRover) {
        marsRover.setX(marsRover.getX() + 1);
    }
}
