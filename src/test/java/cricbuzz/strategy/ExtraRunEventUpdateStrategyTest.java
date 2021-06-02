package cricbuzz.strategy;

import cricbuzz.TeamsTestData;
import cricbuzz.models.BattingStats;
import cricbuzz.models.BowlingStats;

import cricbuzz.models.Team;
import org.junit.jupiter.api.Test;

import static cricbuzz.event.ExtraRunEvent.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtraRunEventUpdateStrategyTest {

    ExtraRunEventUpdateStrategy extraRunEventUpdateStrategy = new  ExtraRunEventUpdateStrategy();
    TeamsTestData teamsTestData = new TeamsTestData();
    Team team = teamsTestData.getData().get(0);


    @Test
    public void should_incrementBalls()
    {
        BattingStats battingStats = new BattingStats();
        battingStats.setIsStrikeBatsman(true);
        extraRunEventUpdateStrategy.updateBattingStats( battingStats,LEG_BYE);
        assertEquals(1, battingStats.getBalls());
        extraRunEventUpdateStrategy.updateBattingStats( battingStats,BYE);
        assertEquals(2, battingStats.getBalls());
    }

    @Test
    public void should_incrementOversBowled() {
        BowlingStats bowlingStats = new BowlingStats();
        bowlingStats.setBowling(true);
        extraRunEventUpdateStrategy.updateBowlingStats(bowlingStats, LEG_BYE);
        assertEquals(1,bowlingStats.getOversBowled().getBalls());
    }

    @Test
    public void should_increment_runs() {
        BowlingStats bowlingStats = new BowlingStats();
        bowlingStats.setBowling(true);
        extraRunEventUpdateStrategy.updateBowlingStats(bowlingStats, WIDE);
        assertEquals(1,bowlingStats.getRuns());
    }

    @Test
    public void should_update_team_if_isBatting_is_true() {
        team.setBatting(true);
        extraRunEventUpdateStrategy.updateTeam(team,WIDE);
        assertEquals(1,team.getTeamExtras().getExtraRunsReceived().get(WIDE));
    }

    @Test
    public void should_update_team_if_isBatting_is_false() {
        extraRunEventUpdateStrategy.updateTeam(team,WIDE);
        assertEquals(1,team.getTeamExtras().getExtraRunsReceived().get(WIDE));
    }
}
