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
        MarsRover rover = new MarsRover(0,0,Direction.S);
        String currentStatus = rover.executeCommand("L");
        assertEquals("0:0:E", currentStatus);
    }

    @Test
    public void should_face_west_when_facing_south_and_turn_right() {
        MarsRover rover = new MarsRover(0,0,Direction.S);
        String currentStatus = rover.executeCommand("R");
        assertEquals("0:0:W", currentStatus);
    }

    @Test
    public void should_face_west_when_facing_west_and_turn_left() {
        MarsRover rover = new MarsRover(0,0,Direction.W);
        String currentStatus = rover.executeCommand("L");
        assertEquals("0:0:S", currentStatus);
    }

    @Test
    public void should_face_west_when_facing_west_and_turn_right() {
        MarsRover rover = new MarsRover(0,0,Direction.W);
        String currentStatus = rover.executeCommand("R");
        assertEquals("0:0:N", currentStatus);
    }

    @Test
    public void should_face_west_when_facing_east_and_turn_left() {
        MarsRover rover = new MarsRover(0,0,Direction.E);
        String currentStatus = rover.executeCommand("L");
        assertEquals("0:0:N", currentStatus);
    }


    @Test
    public void should_face_west_when_facing_east_and_turn_right() {
        MarsRover rover = new MarsRover(0,0,Direction.E);
        String currentStatus = rover.executeCommand("R");
        assertEquals("0:0:S", currentStatus);
    }

    @Test
    public void should_forward_facing_north() {
        MarsRover rover = new MarsRover(0, 0, Direction.N);
        String currentStatus = rover.executeCommand("M");
        assertEquals("0:1:N", currentStatus);
    }

    @Test
    public void should_forward_facing_east() {
        MarsRover rover = new MarsRover(0, 0, Direction.E);
        String currentStatus = rover.executeCommand("M");
        assertEquals("1:0:E", currentStatus);

    }

    @Test
    public void should_forward_facing_south() {
        MarsRover rover = new MarsRover(0, 0, Direction.S);
        String currentStatus = rover.executeCommand("M");
        assertEquals("0:-1:S", currentStatus);
    }

    @Test
    public void should_forward_facing_west() {
        MarsRover rover = new MarsRover(0, 0, Direction.W);
        String currentStatus = rover.executeCommand("M");
        assertEquals("-1:0:W", currentStatus);
    }

    @Test
    public void should_backward_facing_west() {
        MarsRover rover = new MarsRover(0, 0, Direction.W);
        String currentStatus = rover.executeCommand("B");
        assertEquals("1:0:W", currentStatus);
    }

    @Test
    public void should_backward_facing_east() {
        MarsRover rover = new MarsRover(0, 0, Direction.E);
        String currentStatus = rover.executeCommand("B");
        assertEquals("-1:0:E", currentStatus);
    }

    @Test
    public void should_backward_facing_north() {
        MarsRover rover = new MarsRover(0, 0, Direction.N);
        rover.executeCommand("B");
        String currentStatus = rover.executeCommand("N");
        assertEquals("0:-1:N", currentStatus);
    }

    @Test
    public void should_backward_facing_south() {
        MarsRover rover = new MarsRover(0, 0, Direction.S);
        String currentStatus = rover.executeCommand("B");
        assertEquals("0:1:S", currentStatus);
    }

    @Test
    public void should_move_MMLM_facing_north() {
        MarsRover rover = new MarsRover(0, 0, Direction.N);
        rover.executeCommand("MMLM");
        assertEquals("-1:2:W", rover.showStatus());
    }

    @Test
    public void should_move_2M_facing_north() {
        MarsRover rover = new MarsRover(0, 0, Direction.N);
        rover.executeCommand("2M");
        assertEquals("0:2:N", rover.showStatus());
    }

    @Test
    public void should_move_2R_facing_north() {
        MarsRover rover = new MarsRover(0, 0, Direction.N);
        rover.executeCommand("2R");
        assertEquals("0:0:S", rover.showStatus());
    }

    @Test
    public void should_move_2R21M1L1M_facing_north() {
        MarsRover rover = new MarsRover(0, 0, Direction.N);
        rover.executeCommand("2R21M1L1M");
        assertEquals("1:-21:E", rover.showStatus());
    }




}
