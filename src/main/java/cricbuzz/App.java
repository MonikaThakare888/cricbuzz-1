package cricbuzz;

import cricbuzz.db.Repository;
import cricbuzz.models.Player;
import cricbuzz.models.Team;
import cricbuzz.models.event.EndEvent;
import cricbuzz.models.inning.Inning;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Team team1 = Database.getTeams().get(0);
        Team team2 = Database.getTeams().get(1);

        EventManager manager = new EventManager();

        manager.addSubscriber(team1);
        manager.addSubscriber(team2);

        manager.addSubscriber(team1.getPlayers().stream().map(Player::getBattingStats).collect(Collectors.toList()));
        manager.addSubscriber(team1.getPlayers().stream().map(Player::getBowlingStats).collect(Collectors.toList()));
        manager.addSubscriber(team1.getTeamExtras());

        manager.addSubscriber(team2.getPlayers().stream().map(Player::getBattingStats).collect(Collectors.toList()));
        manager.addSubscriber(team2.getPlayers().stream().map(Player::getBowlingStats).collect(Collectors.toList()));
        manager.addSubscriber(team2.getTeamExtras());

        Repository repository = new Repository();
        List<Inning> innings = repository.getBothInnings();
        Inning firstInning = innings.get(0);
        Inning secondInning = innings.get(1);

        firstInning.getOvers().forEach( over -> {
            over.getDeliveries().forEach(manager::notifySubscribers);
            manager.notifySubscribers(EndEvent.OVER_END);
        });
        manager.notifySubscribers(EndEvent.INNING_END);
        secondInning.getOvers().forEach( over -> {
            over.getDeliveries().forEach(manager::notifySubscribers);
            manager.notifySubscribers(EndEvent.OVER_END);
        });
        manager.notifySubscribers(EndEvent.INNING_END);
    }
}
