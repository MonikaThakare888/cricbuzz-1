package cricbuzz.strategy;

import cricbuzz.models.*;
import cricbuzz.event.Event;

public interface UpdateStrategy {
    void updateBattingStats(BattingStats battingStats, Event event);
    void updateBowlingStats(BowlingStats bowlingStats, Event event);
    void updateTeam(Team team, Event event);
}
