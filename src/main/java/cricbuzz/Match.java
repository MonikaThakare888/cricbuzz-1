package cricbuzz;

import cricbuzz.models.BattingStats;
import cricbuzz.models.BowlingStats;
import cricbuzz.models.Team;
import cricbuzz.models.TeamExtras;

import java.util.List;

public class Match {

    public Match() {
    }

    public void initialize(List<Team> teams) {
        teams.forEach(team -> {
            team.setTeamExtras(new TeamExtras());
            team.getPlayers().forEach(player -> {
                player.setBattingStats(new BattingStats());
                player.setBowlingStats(new BowlingStats());
            });
        });
    }

    public void toss(List<Team> teams){
        if(1 > 0.5 ) {
            teams.get(0).setBatting(true);
            teams.get(1).setBatting(false);
        }
        else {
            teams.get(0).setBatting(false);
            teams.get(1).setBatting(true);
        }
    }

}
