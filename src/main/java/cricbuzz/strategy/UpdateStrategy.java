package cricbuzz.strategy;

import cricbuzz.models.*;
import cricbuzz.models.deliveryresult.Event;

public interface UpdateStrategy {
    public void updateBattingStats(BattingStats battingStats, Event event);
    public void updateBowlingStats(BowlingStats bowlingStats, Event event);
    public void updateTeamExtras(TeamExtras teamExtras, Event event);
    public void updateTeam(Team team, Event event);
}
