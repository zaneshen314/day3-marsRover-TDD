package org.example;

public class MarsRover {

    private int x;
    private int y;
    private String direction;

    public enum Direction {
        N, E, S, W;
    }

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
        switch (command){
            case "M": move(); break;
            case "L": left(); break;
            case "r": right(); break;
        }
        return showStatus();
    }

    // 左转
    public void left() {
        switch (direction) {
            case "N": this.direction = Direction.W.name(); break;
            case "W": this.direction = Direction.S.name(); break;
            case "S": this.direction = Direction.E.name(); break;
            case "E": this.direction = Direction.N.name(); break;
        }
    }

    // 右转
    public void right() {
        switch (direction) {
            case "N": this.direction = Direction.E.name(); break;
            case "E": this.direction = Direction.S.name(); break;
            case "S": this.direction = Direction.W.name(); break;
            case "W": this.direction = Direction.N.name(); break;
        }
    }
    // 前进
    public void move() {
        switch (direction) {
            case "N": y++; break;
            case "E": x++; break;
            case "S": y--; break;
            case "W": x--; break;
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
    }
}
