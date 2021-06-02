package cricbuzz.strategy;

import cricbuzz.event.Event;
import cricbuzz.event.RunEvent;
import cricbuzz.models.BattingStats;
import cricbuzz.models.BowlingStats;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunEventUpdateStrategyTest {

    RunEventUpdateStrategy runEventUpdateStrategy = new RunEventUpdateStrategy();
    BattingStats battingStats = new BattingStats();
    Event  event = RunEvent.FOUR;

    @Test
    public void should_updateBattingStats(){
        battingStats.setIsStrikeBatsman(true);
        runEventUpdateStrategy.updateBattingStats(battingStats, event);
        assertEquals(4, battingStats.getRuns());
        assertEquals(1, battingStats.getBalls());
        assertEquals(1, battingStats.getRunsDistribution().get(RunEvent.FOUR));

    }

    @Test
    public void should_updateBowlingStats(){
        BowlingStats bowlingStats = new BowlingStats();
        bowlingStats.setBowling(true);
        runEventUpdateStrategy.updateBowlingStats(bowlingStats, event);
        assertEquals(4, bowlingStats.getRuns());
        assertEquals(1, bowlingStats.getOversBowled().getBalls());

    }
}
