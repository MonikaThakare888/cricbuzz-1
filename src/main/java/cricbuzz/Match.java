package cricbuzz;

import cricbuzz.models.Team;

public class Match {
    private Team battingTeam;
    private Team bowlingTeam;

    public Match() {
    }

    public void toss(Team team1, Team team2){
        if(Math.random() > 0.5 ) {
            battingTeam = team1;
        }
        else {
            bowlingTeam = team2;
        }
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }
}
