package cricbuzz.strategy;

import cricbuzz.TeamsTestData;
import cricbuzz.event.Event;
import cricbuzz.models.Team;
import org.junit.jupiter.api.Test;

import static cricbuzz.event.RunEvent.FOUR;
import static org.junit.jupiter.api.Assertions.*;

public class MatchEventUpdateStrategyTest {

    MatchEventUpdateStrategy matchEventUpdateStrategy = new MatchEventUpdateStrategy();
    TeamsTestData teamsTestData = new TeamsTestData();
    Team team = teamsTestData.getData().get(0);
    Event event = FOUR;

    @Test
    public void should_updateTeam_if_isBatting_is_true() {
        team.setBatting(true);
        matchEventUpdateStrategy.updateTeam(team, event);
        assertTrue(team.getPlayers().stream().filter(player -> player.getBattingOrder() == 1).findFirst().get()
                    .getBattingStats().isStrikeBatsman());
        assertTrue(team.getPlayers().stream().filter(player -> player.getBattingOrder() == 2).findFirst().get()
                .getBattingStats().isNonStrikeBatsman());
    }

    @Test
    public void should_updateTeam_if_isBatting_is_false() {
        matchEventUpdateStrategy.updateTeam(team, event);
        assertTrue(team.getPlayers().stream().filter(player -> player.getBowlingOrder() == 1).findFirst().get()
                .getBowlingStats().isBowling());
    }
}
