package org.example;

public class MarsRover {

    private int x;
    private int y;
    private String direction;

    public String showStatus() {
        return x + ":" + y + ":" + direction;
    }

    public String executeCommand(String command) {
        String direction = this.direction;
        if (command.equals("L")) {
            direction = "W";

        } else if (command.equals("R")) {
            direction = "E";
        }
        this.direction = direction;
        return showStatus();
    }
}
