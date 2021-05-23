package cricbuzz.strategy;

import cricbuzz.event.Event;
import cricbuzz.models.BattingStats;
import cricbuzz.models.BowlingStats;
import cricbuzz.models.Team;

public class MatchEventUpdateStrategy implements UpdateStrategy{

    @Override
    public void updateBattingStats(BattingStats battingStats, Event event) {
    }

    @Override
    public void updateBowlingStats(BowlingStats bowlingStats, Event event) {
    }

    @Override
    public void updateTeam(Team team, Event event) {
        if(team.isBatting()) {
            team.getPlayers().stream()
                    .filter(player -> player.getBattingOrder() == 1)
                    .findFirst().get()
                    .getBattingStats()
                    .setIsStrikeBatsman(true);
            team.getPlayers().stream()
                    .filter(player -> player.getBattingOrder() == 2)
                    .findFirst().get()
                    .getBattingStats()
                    .setIsNonStrikeBatsman(true);
        }
        else {
            team.getPlayers().stream()
                    .filter(player -> player.getBowlingOrder() == 1)
                    .findFirst().get()
                    .getBowlingStats()
                    .setBowling(true);
        }
    }
}
