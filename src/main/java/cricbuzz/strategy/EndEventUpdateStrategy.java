package cricbuzz.strategy;

import cricbuzz.models.BattingStats;
import cricbuzz.models.BowlingStats;
import cricbuzz.models.Team;
import cricbuzz.event.Event;

import static cricbuzz.event.EndEvent.INNING_END;
import static cricbuzz.event.EndEvent.OVER_END;

public class EndEventUpdateStrategy implements UpdateStrategy{
    @Override
    public void updateBattingStats(BattingStats battingStats, Event event) {
        if(event.equals(OVER_END)) {
            if(battingStats.isStrikeBatsman()) {
                battingStats.setIsNonStrikeBatsman(true);
                battingStats.setIsStrikeBatsman(false);
                return;
            }
            if(battingStats.isNonStrikeBatsman()) {
                battingStats.setIsStrikeBatsman(true);
                battingStats.setIsNonStrikeBatsman(false);
            }
        }
    }

    @Override
    public void updateBowlingStats(BowlingStats bowlingStats, Event event) {
    }

    @Override
    public void updateTeam(Team team, Event event) {
        if(event.equals(OVER_END) && !team.isBatting()) {
            int currentBowlingOrder = team.getPlayers()
                    .stream()
                    .filter(player -> player.getBowlingStats().isBowling())
                    .findFirst().get()
                    .getBowlingOrder();
            team.getPlayers().stream()
                    .filter(player -> player.getBowlingOrder() == currentBowlingOrder)
                    .findFirst().get()
                    .getBowlingStats()
                    .setBowling(false);
            if (currentBowlingOrder < 5) {
                team.getPlayers().stream()
                        .filter(player -> player.getBowlingOrder() == currentBowlingOrder + 1)
                        .findFirst().get()
                        .getBowlingStats()
                        .setBowling(true);
            }
        }
        if(event.equals(INNING_END)) {
            team.setBatting(!team.isBatting());
        }
    }
}
