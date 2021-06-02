package cricbuzz;

import cricbuzz.db.InningRepository;
import cricbuzz.db.TeamRepository;
import cricbuzz.event.EndEvent;
import cricbuzz.models.Player;
import cricbuzz.models.Team;
import cricbuzz.models.inning.Inning;
import cricbuzz.observer.EventManager;
import cricbuzz.util.Console;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static cricbuzz.event.EndEvent.OVER_END;
import static cricbuzz.event.MatchEvent.MATCH_START;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Console console = new Console();
        TeamRepository teamRepository = new TeamRepository();
        List<Team> teams = teamRepository.getBothTeams();

        InningRepository inningRepository = new InningRepository();
        List<Inning> innings = inningRepository.getBothInnings("src/main/resources/innings.json");
        Inning firstInning = innings.get(0);
        Inning secondInning = innings.get(1);

        Match match = new Match();
        match.initialize(teams);
        match.toss(teams);

        EventManager manager = new EventManager();
        manager.addSubscriber(teams.get(0).getPlayers().stream().map(Player::getBattingStats).collect(Collectors.toList()));
        manager.addSubscriber(teams.get(1).getPlayers().stream().map(Player::getBattingStats).collect(Collectors.toList()));
        manager.addSubscriber(teams.get(0));
        manager.addSubscriber(teams.get(1));
        manager.addSubscriber(teams.get(1).getPlayers().stream().map(Player::getBowlingStats).collect(Collectors.toList()));
        manager.addSubscriber(teams.get(0).getPlayers().stream().map(Player::getBowlingStats).collect(Collectors.toList()));


        manager.notifySubscribers(MATCH_START);
        firstInning.getOvers().forEach( over -> {
            over.getDeliveries().forEach(d -> {
                manager.notifySubscribers(d);
                console.print("Delivery:" + d.toString());
                printBallByBallDelivery(teams.get(0), console);
            });
            manager.notifySubscribers(OVER_END);
            console.print("Delivery:" + OVER_END.toString());
            printBallByBallDelivery(teams.get(0), console);
        });
        manager.notifySubscribers(EndEvent.INNING_END);
        secondInning.getOvers().forEach( over -> {
            over.getDeliveries().forEach(manager::notifySubscribers);
            manager.notifySubscribers(OVER_END);
        });
        manager.notifySubscribers(EndEvent.INNING_END);
    }

    public static void printBallByBallDelivery(Team team, Console console) {
        team.getPlayers().stream().filter(p -> p.getBattingStats().isStrikeBatsman() || p.getBattingStats().isNonStrikeBatsman())
                .forEach( sp -> {
                    if(sp.getBattingStats().isStrikeBatsman()){
                        console.print("Strike: " + sp.getBattingOrder());
                    }
                    else{
                        console.print("Non-Strike: " + sp.getBattingOrder());
                    }
                });
    }

}
