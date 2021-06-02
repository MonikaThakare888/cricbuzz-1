package cricbuzz.event;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    @Test
     void should_get_event() {
        assertAll(
                () -> assertEquals(ExtraRunEvent.WIDE, Event.from("WD")),
                () -> assertEquals(ExtraRunEvent.NO_BALL, Event.from("NB")),
                () -> assertEquals(ExtraRunEvent.BYE, Event.from("B")),
                () -> assertEquals(ExtraRunEvent.LEG_BYE, Event.from("LB")),
                () -> assertEquals(OutEvent.CATCH_OUT, Event.from("CO")),
                () -> assertEquals(OutEvent.RUN_OUT, Event.from("RO")),
                () -> assertEquals(OutEvent.LBW, Event.from("LBW")),
                () -> assertEquals(OutEvent.BOWLED, Event.from("W")),
                () -> assertEquals(RunEvent.DOT, Event.from("0")),
                () -> assertEquals(RunEvent.ONE, Event.from("1")),
                () -> assertEquals(RunEvent.TWO, Event.from("2")),
                () -> assertEquals(RunEvent.THREE, Event.from("3")),
                () -> assertEquals(RunEvent.FOUR, Event.from("4")),
                () -> assertEquals(RunEvent.SIX, Event.from("6"))
        );
    }
}
