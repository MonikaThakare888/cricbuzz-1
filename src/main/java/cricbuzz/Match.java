package cricbuzz;

import cricbuzz.models.Team;

public class Match {

    public Match() {
    }

    public void toss(Team team1, Team team2){
        if(Math.random() > 0.5 ) {
            team1.setBatting(true);
        }
        else {
            team2.setBatting(true);
        }
    }

}
