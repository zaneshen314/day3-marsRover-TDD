package org.example;

import org.example.constant.Direction;
import org.example.operation.BaseOperation;
import org.example.operation.NorthOperation;

import java.util.stream.IntStream;

public class MarsRover {

    private Position position;
    private BaseOperation operation;

    public MarsRover(){
        this.position = new Position();
        setOperation(new NorthOperation());
    }

    public MarsRover(int x, int y, Direction direction){
        this.position = new Position(x, y);
        setOperation(BaseOperation.getOperation(direction));
    }

    public String showStatus() {
        return String.format("%d:%d:%s", position.getX(), position.getY(), operation.getDirection().name());
    }

    public String executeCommand(String command) {
        StringBuilder numberBuffer = new StringBuilder();
        command.chars()
                .forEach(c -> {
                    handlerCommandChar(1,numberBuffer,(char) c);
                });

        return showStatus();
    }

    public void handlerCommandChar(int repeatCount,StringBuilder numberBuffer,char currentChar){
        if (Character.isDigit(currentChar)) {
            numberBuffer.append(currentChar);
        } else {
            if (!numberBuffer.isEmpty()) {
                repeatCount = Integer.parseInt(numberBuffer.toString());
                numberBuffer.setLength(0);
            }
            IntStream.range(0, repeatCount)
                    .forEach(i -> {
                        operation.execute(this, String.valueOf(currentChar));
                    });
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public BaseOperation getOperation() {
        return operation;
    }

    public void setOperation(BaseOperation operation) {
        this.operation = operation;
    }
}
