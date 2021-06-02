package cricbuzz.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OversBowledTest {

    OversBowled oversBowled = new OversBowled();

    @Test
    public void should_increment_balls()
    {
        oversBowled.increment();
        assertEquals(1,oversBowled.getBalls());
    }
    @Test
    public void should_increment_over()
    {
        oversBowled.setBalls(5);
        oversBowled.increment();
        assertEquals(1,oversBowled.getOvers());
    }

}
