package cricbuzz.models;

import cricbuzz.event.RunEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattingStatsTest {

    BattingStats battingStats = new BattingStats();
    RunEvent runEvent = RunEvent.ONE;

    @Test
    public void should_increment_runs(){
        battingStats.incrementRuns(1);
        assertEquals(1,battingStats.getRuns());
    }

    @Test
    public void should_increment_balls(){
        battingStats.incrementBalls();
        assertEquals(1,battingStats.getBalls());
    }

    @Test
    public void should_update_run_distribution() {
        battingStats.updateRunDistribution(runEvent);
        assertEquals(1,battingStats.getRunsDistribution().get(RunEvent.ONE));
    }
}
