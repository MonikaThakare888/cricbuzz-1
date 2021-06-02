package cricbuzz.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingStatsTest {

    BowlingStats bowlingStats = new BowlingStats();

    @Test
    public void should_increment_overs_bowled() {

    }
    @Test
    public void should_increment_runs() {
        bowlingStats.incrementRuns(1);
        assertEquals(1,bowlingStats.getRuns());
    }
    @Test
    public void should_increment_wickets() {
        bowlingStats.incrementWickets();
        assertEquals(1, bowlingStats.getWickets());
    }
    @Test
    public void should_increment_noBalls() {
        bowlingStats.incrementNoBalls();
        assertEquals(1, bowlingStats.getNoBalls());
    }
    @Test
    public void should_increment_wides() {
        bowlingStats.incrementWides();
        assertEquals(1, bowlingStats.getWides());

    }
}
