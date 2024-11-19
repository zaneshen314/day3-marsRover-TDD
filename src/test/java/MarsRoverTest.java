import org.example.MarsRover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {
    @Test
    public void should_initialize_marsRover() {
        MarsRover rover = new MarsRover();
        rover.showStatus();
        assertEquals("0:0:N", rover.showStatus());
    }
    @Test
    public void should_face_west_when_facing_north_and_turn_left() {
        MarsRover rover = new MarsRover();
        String currentStatus = rover.executeCommand("L");
        String report = rover.showStatus();
        assertEquals("0:0:W", currentStatus);
        assertEquals("0:0:W", report);
    }

    @Test
    public void should_face_west_when_facing_north_and_turn_right() {
        MarsRover rover = new MarsRover();
        String currentStatus = rover.executeCommand("R");
        assertEquals("0:0:E", currentStatus);
    }

    @Test
    public void should_face_west_when_facing_south_and_turn_left() {
        MarsRover rover = new MarsRover(0,0,"S");
        String currentStatus = rover.executeCommand("L");
        assertEquals("0:0:E", currentStatus);
    }

    @Test
    public void should_face_west_when_facing_south_and_turn_right() {
        MarsRover rover = new MarsRover(0,0,"S");
        String currentStatus = rover.executeCommand("R");
        assertEquals("0:0:W", currentStatus);
    }

    @Test
    public void should_face_west_when_facing_west_and_turn_left() {
        MarsRover rover = new MarsRover(0,0,"W");
        String currentStatus = rover.executeCommand("L");
        assertEquals("0:0:S", currentStatus);
    }

    @Test
    public void should_face_west_when_facing_west_and_turn_right() {
        MarsRover rover = new MarsRover(0,0,"W");
        String currentStatus = rover.executeCommand("R");
        assertEquals("0:0:N", currentStatus);
    }

    @Test
    public void should_face_west_when_facing_east_and_turn_left() {
        MarsRover rover = new MarsRover(0,0,"E");
        String currentStatus = rover.executeCommand("L");
        assertEquals("0:0:N", currentStatus);
    }


    @Test
    public void should_face_west_when_facing_east_and_turn_right() {
        MarsRover rover = new MarsRover(0,0,"E");
        String currentStatus = rover.executeCommand("R");
        assertEquals("0:0:S", currentStatus);
    }

    @Test
    public void testMoveNorth() {
        MarsRover rover = new MarsRover(0, 0, MarsRover.Direction.N.name());
        rover.move();
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
    }
}
