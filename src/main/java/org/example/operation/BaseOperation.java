package org.example.operation;

import org.example.MarsRover;
import org.example.constant.Direction;

public abstract class BaseOperation {

    public static BaseOperation getOperation(Direction direction) {
        return switch (direction) {
            case N -> new NorthOperation();
            case S -> new SouthOperation();
            case E -> new EastOperation();
            case W -> new WestOperation();
            default -> null;
        };
    }

    public void execute(MarsRover marsRover, String command){
        switch (command) {
            case "M": forward(marsRover); break;
            case "B": backward(marsRover); break;
            case "R": turnRight(marsRover); break;
            case "L": turnLeft(marsRover); break;

        }
    };

    public abstract Direction getDirection();

    public abstract void turnLeft(MarsRover marsRover);

    public abstract void turnRight(MarsRover marsRover);

    public abstract void forward(MarsRover marsRover);

    public abstract void backward(MarsRover marsRover);
}
