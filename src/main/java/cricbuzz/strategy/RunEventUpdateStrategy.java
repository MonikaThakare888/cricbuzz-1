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
            battingStats.setRuns(battingStats.getRuns() + runs);
            battingStats.setBalls(battingStats.getBalls() + 1);
            Map<RunEvent, Integer> runDistribution = battingStats.getRunsDistribution();
            runDistribution.put((runEvent), runDistribution.get(runEvent) + 1);
            battingStats.setRunsDistribution(runDistribution);
        }
    }

    @Override
    public void updateBowlingStats(BowlingStats bowlingStats, Event event) {
        if (bowlingStats.isBowling()) {
            bowlingStats.getOversBowled().setBalls(bowlingStats.getOversBowled().getBalls() +1);
            bowlingStats.setRuns(bowlingStats.getRuns() + 1);
        }
    }

    @Override
    public void updateTeamExtras(TeamExtras teamExtras, Event event) {
    }

    @Override
    public void updateTeam(Team team, Event event) {
    }
}
