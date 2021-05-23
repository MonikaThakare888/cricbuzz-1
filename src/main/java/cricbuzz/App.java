package cricbuzz;

import cricbuzz.db.InningRepository;
import cricbuzz.db.TeamRepository;
import cricbuzz.models.Player;
import cricbuzz.models.Team;
import cricbuzz.event.EndEvent;
import cricbuzz.models.inning.Inning;
import cricbuzz.observer.EventManager;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        TeamRepository teamRepository = new TeamRepository();
        List<Team> teams = teamRepository.getBothTeams();

        InningRepository inningRepository = new InningRepository();
        List<Inning> innings = inningRepository.getBothInnings();
        Inning firstInning = innings.get(0);
        Inning secondInning = innings.get(1);

        EventManager manager = new EventManager();
        manager.addSubscriber(teams.get(0));
        manager.addSubscriber(teams.get(1));
        manager.addSubscriber(teams.get(0).getPlayers().stream().map(Player::getBattingStats).collect(Collectors.toList()));
        manager.addSubscriber(teams.get(0).getPlayers().stream().map(Player::getBowlingStats).collect(Collectors.toList()));
        manager.addSubscriber(teams.get(1).getPlayers().stream().map(Player::getBattingStats).collect(Collectors.toList()));
        manager.addSubscriber(teams.get(1).getPlayers().stream().map(Player::getBowlingStats).collect(Collectors.toList()));

        Match match = new Match();
        match.toss(teams.get(0), teams.get(1));



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
