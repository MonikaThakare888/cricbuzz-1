package cricbuzz.strategy;

import cricbuzz.models.*;
import cricbuzz.models.deliveryresult.Event;
import cricbuzz.models.deliveryresult.RunEvent;

import java.util.Map;

public class RunEventUpdateStrategy implements UpdateStrategy {

    @Override
    public void updateBattingStats(BattingStats battingStats, Event event) {
        if(battingStats.isStrikeBatsman()) {
            RunEvent runEvent = (RunEvent) event;
            int runs = (runEvent).getRuns();
            battingStats.incrementRuns(runs);
            battingStats.incrementBalls();
            battingStats.incrementRunEvent(runEvent);
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
    public void updateTeamExtras(TeamExtras teamExtras, Event event) {
    }

    @Override
    public void updateTeam(Team team, Event event) {
    }
}
