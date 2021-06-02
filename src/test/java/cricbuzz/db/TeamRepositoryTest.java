package cricbuzz.db;

import cricbuzz.models.Team;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TeamRepositoryTest {

    TeamRepository repository = new TeamRepository();
    @Test
    void should_read_all_teams_from_file() {
        List<Team> teams = assertDoesNotThrow(() -> repository.getBothTeams());
        String[] teamsNames = teams.stream().map(Team ::getName).toArray(String[]::new);
        String[] expectedTeamsNamesArray = new String[] {"Mumbai Indians","Chennai Super Kings"};
        assertArrayEquals(expectedTeamsNamesArray, teamsNames);
    }
}
