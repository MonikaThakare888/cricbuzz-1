package cricbuzz.strategy;

import cricbuzz.models.BattingStats;
import cricbuzz.models.BowlingStats;
import cricbuzz.models.Team;
import cricbuzz.models.event.Event;
import cricbuzz.models.event.OutEvent;

public class OutEventUpdateStrategy implements UpdateStrategy {

    @Override
    public void updateBattingStats(BattingStats battingStats, Event event) {
        if(battingStats.isStrikeBatsman()){
            battingStats.setOutEvent((OutEvent) event);
            battingStats.setIsStrikeBatsman(false);
        }
    }

    @Override
    public void updateBowlingStats(BowlingStats bowlingStats, Event event) {
        if (bowlingStats.isBowling()) {
            bowlingStats.incrementOversBowled();
            bowlingStats.incrementWickets();
        }
    }

    @Override
    public void updateTeam(Team team, Event event) {
        int currentBatsmanOrder = team.getPlayers().stream()
                .filter( player -> player.getBattingStats().isStrikeBatsman())
                .findFirst()
                .get().getBattingOrder();

        team.getPlayers().stream()
                .filter(player -> player.getBattingOrder() == currentBatsmanOrder +1)
                .findFirst()
                .get().getBattingStats()
                .setIsStrikeBatsman(true);
    }
}
