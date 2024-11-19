package org.example;

import org.example.operation.BaseOperation;

import java.util.stream.IntStream;

public class MarsRover {

    private int x;
    private int y;
    private String direction;
    private BaseOperation operation;

    public MarsRover(){
        this.x = 0;
        this.y = 0;
        setDirection("N");
    }

    public MarsRover(int x, int y, String direction){
        this.x = x;
        this.y = y;
        setDirection(direction);
    }

    public String showStatus() {
        return String.format("%d:%d:%s", x, y, direction);
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
        this.operation = BaseOperation.getCommand(this.direction);
    }

    public BaseOperation getOperation() {
        return operation;
    }

    public void setOperation(BaseOperation operation) {
        this.operation = operation;
    }
}
