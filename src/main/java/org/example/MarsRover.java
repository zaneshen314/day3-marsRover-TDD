package org.example;

import org.example.operation.BaseOperation;

import java.util.stream.IntStream;

public class MarsRover {

    private int x;
    private int y;
    private String direction;

    public MarsRover(){
        this.x = 0;
        this.y = 0;
        this.direction = "N";
    }

    public MarsRover(int x, int y, String direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String showStatus() {
        return String.format("%d:%d:%s", x, y, direction);
    }

    public String executeCommand(String command) {
        int[] repeatCount = {1};
        StringBuilder numberBuffer = new StringBuilder();
        command.chars()
                .forEach(c -> {
                    char currentChar = (char) c;
                    if (Character.isDigit(currentChar)) {
                        numberBuffer.append(currentChar);
                    } else {
                        if (!numberBuffer.isEmpty()) {
                            repeatCount[0] = Integer.parseInt(numberBuffer.toString());
                            numberBuffer.setLength(0);
                        }
                        IntStream.range(0, repeatCount[0])
                                .forEach(i -> {
                                    BaseOperation operation = BaseOperation.getCommand(this.direction);
                                    if (operation != null) {
                                        operation.execute(this, String.valueOf(currentChar));
                                    }
                                });
                        repeatCount[0] = 1;
                    }
                });

        return showStatus();
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
    }
}
