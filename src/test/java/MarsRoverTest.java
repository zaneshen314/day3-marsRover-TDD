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

}
