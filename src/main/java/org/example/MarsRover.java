package org.example;

import org.example.operation.BaseOperation;

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
        return x + ":" + y + ":" + direction;
    }

    public String executeCommand(String command) {
        for (int i = 0; i < command.length(); i++) {
            String c = command.substring(i, i + 1);
            BaseOperation operation = BaseOperation.getCommand(this.getDirection());
            assert operation != null;
            operation.execute(this, c);
        }
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
