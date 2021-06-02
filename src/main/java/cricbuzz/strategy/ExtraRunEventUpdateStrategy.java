package cricbuzz.strategy;

import cricbuzz.models.BattingStats;
import cricbuzz.models.BowlingStats;
import cricbuzz.models.Team;
import cricbuzz.event.Event;
import cricbuzz.event.ExtraRunEvent;

import static cricbuzz.event.ExtraRunEvent.*;

public class ExtraRunEventUpdateStrategy implements UpdateStrategy{

    @Override
    public void updateBattingStats(BattingStats battingStats, Event event) {
        if(battingStats.isStrikeBatsman() && (event.equals(LEG_BYE) || event.equals(BYE))) {
            battingStats.incrementBalls();
        }
    }

    @Override
    public void updateBowlingStats(BowlingStats bowlingStats, Event event) {
        if(bowlingStats.isBowling() && (event.equals(LEG_BYE) || event.equals(BYE))) {
            bowlingStats.incrementOversBowled();
        }
        if(bowlingStats.isBowling() && (event.equals(WIDE) || event.equals(NO_BALL))) {
            bowlingStats.incrementRuns(1);
        }
    }

    @Override
    public void updateTeam(Team team, Event event) {
        if(team.isBatting()) {
            team.getTeamExtras().updateExtraRunsReceived((ExtraRunEvent) event);
        }
        else {
            team.getTeamExtras().updateExtraRunsGiven((ExtraRunEvent) event);
        }
    }
}
