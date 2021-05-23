package cricbuzz.strategy;

import cricbuzz.event.Event;
import cricbuzz.event.OutEvent;
import cricbuzz.models.BattingStats;
import cricbuzz.models.BowlingStats;
import cricbuzz.models.Team;

import static cricbuzz.event.OutEvent.NOT_OUT;

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
        if(team.isBatting()) {
            int currentBatsmanOrder = team.getPlayers().stream()
                    .filter( player -> player.getBattingStats().isNonStrikeBatsman())
                    .findFirst().get().getBattingOrder();

            if(currentBatsmanOrder < 5){
                team.getPlayers().stream()
                        .filter(player -> player.getBattingStats().getOutEvent().equals(NOT_OUT) && player.getBattingOrder() > currentBatsmanOrder)
                        .findFirst().get().getBattingStats()
                        .setIsStrikeBatsman(true);
                System.out.println();
            }
        }
    }
}
