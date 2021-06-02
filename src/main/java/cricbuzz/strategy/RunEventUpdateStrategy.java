package cricbuzz.strategy;

import cricbuzz.models.*;
import cricbuzz.event.Event;
import cricbuzz.event.RunEvent;

public class RunEventUpdateStrategy implements UpdateStrategy {

    @Override
    public void updateBattingStats(BattingStats battingStats, Event event) {
        if(battingStats.isStrikeBatsman()) {
            RunEvent runEvent = (RunEvent) event;
            int runs = (runEvent).getRuns();
            battingStats.incrementRuns(runs);
            battingStats.incrementBalls();
            battingStats.updateRunDistribution(runEvent);
        }
    }

    @Override
    public void updateBowlingStats(BowlingStats bowlingStats, Event event) {
        if (bowlingStats.isBowling()) {
            RunEvent runEvent = (RunEvent) event;
            int runs = (runEvent).getRuns();
            bowlingStats.incrementRuns(runs);
            bowlingStats.incrementOversBowled();
        }
    }

    @Override
    public void updateTeam(Team team, Event event) {
    }
}
