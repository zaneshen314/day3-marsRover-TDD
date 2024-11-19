import org.example.MarsRover;
import org.example.constant.Direction;
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
        MarsRover rover = new MarsRover(0, 0, Direction.N.name());
        rover.executeCommand("M");
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
    }

    @Test
    public void testMoveEast() {
        MarsRover rover = new MarsRover(0, 0, Direction.E.name());
        rover.executeCommand("M");
        assertEquals(1, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    public void testMoveSouth() {
        MarsRover rover = new MarsRover(0, 0, Direction.S.name());
        rover.executeCommand("M");
        assertEquals(0, rover.getX());
        assertEquals(-1, rover.getY());
    }

    @Test
    public void testMoveWest() {
        MarsRover rover = new MarsRover(0, 0, Direction.W.name());
        rover.executeCommand("M");
        assertEquals(-1, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    public void testMoveWestBackward() {
        MarsRover rover = new MarsRover(0, 0, Direction.W.name());
        rover.executeCommand("B");
        assertEquals(1, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    public void testMoveEastBackward() {
        MarsRover rover = new MarsRover(0, 0, Direction.E.name());
        rover.executeCommand("B");
        assertEquals(-1, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    public void testMoveNorthBackward() {
        MarsRover rover = new MarsRover(0, 0, Direction.N.name());
        rover.executeCommand("B");
        assertEquals(0, rover.getX());
        assertEquals(-1, rover.getY());
    }

    @Test
    public void testMoveSouthBackward() {
        MarsRover rover = new MarsRover(0, 0, Direction.S.name());
        rover.executeCommand("B");
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
    }

    @Test
    public void testMoveMMLM() {
        MarsRover rover = new MarsRover(0, 0, Direction.N.name());
        rover.executeCommand("MMLM");
        assertEquals("-1:2:W", rover.showStatus());
    }

    @Test
    public void testMove2M() {
        MarsRover rover = new MarsRover(0, 0, Direction.N.name());
        rover.executeCommand("2M");
        assertEquals("0:2:N", rover.showStatus());
    }


}
