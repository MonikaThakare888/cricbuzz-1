package cricbuzz.strategy;

import cricbuzz.TeamsTestData;
import cricbuzz.event.Event;
import cricbuzz.event.OutEvent;
import cricbuzz.models.BattingStats;
import cricbuzz.models.BowlingStats;
import cricbuzz.models.Team;
import org.junit.jupiter.api.Test;

import static cricbuzz.event.OutEvent.BOWLED;
import static cricbuzz.event.OutEvent.NOT_OUT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OutEventUpdateStrategyTest {

    TeamsTestData teamsTestData = new TeamsTestData();
    Team team = teamsTestData.getData().get(0);
    OutEventUpdateStrategy outEventUpdateStrategy = new OutEventUpdateStrategy();
    BattingStats battingStats = new BattingStats();
    BowlingStats bowlingStats = new BowlingStats();
    Event event = BOWLED;

    @Test
    public void should_updateBattingStats(){
        battingStats.setIsStrikeBatsman(true);
        outEventUpdateStrategy.updateBattingStats(battingStats, event);
        assertEquals(BOWLED, battingStats.getOutEvent());
        assertFalse(battingStats.isStrikeBatsman());
    }

    @Test
    public void should_updateBowlingStats(){
        bowlingStats.setBowling(true);
        outEventUpdateStrategy.updateBowlingStats(bowlingStats, event);
        assertEquals(1, bowlingStats.getOversBowled().getBalls());
        assertEquals(1, bowlingStats.getWickets());
    }

    @Test
    public void should_updateTeam(){
        //no such element found
        team.setBatting(true);
        outEventUpdateStrategy.updateTeam(team, event);
        System.out.println(team.getPlayers().stream()
                .filter( player -> player.getBattingStats().isNonStrikeBatsman())
                .findFirst().get().getBattingOrder());
    }
}
