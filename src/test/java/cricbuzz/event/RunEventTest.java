package cricbuzz.event;

import org.junit.jupiter.api.Test;

import static cricbuzz.event.RunEvent.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunEventTest {

    @Test
    void should_get_runs() {
        assertAll(
                () -> assertEquals(0, DOT.getRuns()),
                () -> assertEquals(1, ONE.getRuns()),
                () -> assertEquals(2, TWO.getRuns()),
                () -> assertEquals(3, THREE.getRuns()),
                () -> assertEquals(4, FOUR.getRuns()),
                () -> assertEquals(6, SIX.getRuns())
        );
    }
}
