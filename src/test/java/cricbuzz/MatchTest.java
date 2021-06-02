package cricbuzz;

import cricbuzz.models.Team;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    Match match = new Match();
    TeamsTestData teamsTestData = new TeamsTestData();

    @Test
    public void test_initialize()
    {
        List<Team> teams = teamsTestData.getData();
        match.initialize(teams);
        teams.forEach(team -> {
            assertNotNull(team.getTeamExtras());
            team.getPlayers().forEach(player -> {
                assertNotNull(player.getBattingStats());
                assertNotNull(player.getBowlingStats());
            });
        });
    }

    @Test
    public void should_setBatting_if_mathRandom_is_greater_than_given_value(){
        // how to pass Math.random value in if condition
        double value =  0.8;
        List<Team> teams = teamsTestData.getData();
        match.toss(teams);
        assertTrue(teams.get(0).isBatting());
        assertFalse(teams.get(1).isBatting());
    }
    @Test
    public void should_setBatting_if_mathRandom_is_smaller_than_given_value(){
        List<Team> teams = teamsTestData.getData();
        match.toss(teams);
        assertFalse(teams.get(0).isBatting());
        assertTrue(teams.get(1).isBatting());
    }
}
