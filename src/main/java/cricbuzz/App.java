package cricbuzz;

import cricbuzz.db.Repository;
import cricbuzz.models.Team;
import cricbuzz.models.inning.Inning;

import java.io.FileNotFoundException;
import java.util.List;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Team team1 = Database.getTeams().get(0);
        Team team2 = Database.getTeams().get(1);
        Repository repository = new Repository();
        List<Inning> innings = repository.getBothInnings();
        Inning firstInning = innings.get(0);
        firstInning.getOvers().forEach( over -> {
            over.getDeliveries().forEach(team1::update);
        });
    }
}
