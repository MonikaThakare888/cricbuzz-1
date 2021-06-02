package cricbuzz.strategy;

import cricbuzz.TeamsTestData;
import cricbuzz.event.Event;
import cricbuzz.models.BattingStats;
import cricbuzz.models.Team;
import org.junit.jupiter.api.Test;

import static cricbuzz.event.EndEvent.OVER_END;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EndEventUpdateStrategyTest {

    EndEventUpdateStrategy endEventUpdateStrategy = new EndEventUpdateStrategy();
    TeamsTestData teamsTestData = new TeamsTestData();
    Team team = teamsTestData.getData().get(0);
    Event event = OVER_END;

    @Test
    public void  should_updateBattingStats_if_event_is_overEnd_and_isStrikeBatsman_is_false()
    {
        BattingStats battingStats = new BattingStats();
        battingStats.setIsStrikeBatsman(true);
        endEventUpdateStrategy.updateBattingStats(battingStats,event);
        assertTrue(battingStats.isNonStrikeBatsman());
        assertFalse(battingStats.isStrikeBatsman());
    }

    @Test
    public void  should_updateBattingStats_if_isNonStrikeBatsman_is_true()
    {
        BattingStats battingStats = new BattingStats();
        battingStats.setIsNonStrikeBatsman(true);
        endEventUpdateStrategy.updateBattingStats(battingStats,event);
        assertFalse(battingStats.isNonStrikeBatsman());
        assertTrue(battingStats.isStrikeBatsman());
    }

    @Test
    public void  should_updateTeam()
    {
        System.out.println(team.isBatting());
        // no such element found
        endEventUpdateStrategy.updateTeam(team, event);
    }
}
