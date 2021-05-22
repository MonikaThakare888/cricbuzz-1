package cricbuzz;

import cricbuzz.models.Player;
import cricbuzz.models.Team;

import java.util.Arrays;
import java.util.List;

public class Database {
    public static List<Team> getTeams() {
        return Arrays.asList(
                new Team(
                        "Mumbai Indians",
                        Arrays.asList(
                                new Player(1, "Rohit Sharma"),
                                new Player(2, "Quinton De Cock"),
                                new Player(3, "Kiron Pollard"),
                                new Player(4, "Jasprit Bumrah"),
                                new Player(5, "Trent Boult")
                        )
                ),
                new Team(
                        "Chennai Super Kings",
                        Arrays.asList(
                                new Player(1, "Mahendra Singh Dhoni"),
                                new Player(2, "Faf Du Plesis"),
                                new Player(3, "Ravindra Jadeja"),
                                new Player(4, "Sam Curran"),
                                new Player(5, "Dwayne Bravo")
                        )
                )
        );
    }
}
