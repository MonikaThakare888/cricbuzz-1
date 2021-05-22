package cricbuzz;

import cricbuzz.db.Repository;
import cricbuzz.models.Observer;
import cricbuzz.models.Player;
import cricbuzz.models.Team;
import cricbuzz.models.deliveryresult.Event;
import cricbuzz.models.inning.Inning;
import cricbuzz.strategy.UpdateStrategy;
import cricbuzz.strategy.UpdateStrategyFactory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Team team1 = Database.getTeams().get(0);
        Team team2 = Database.getTeams().get(1);

        public void update(Event event){
            this.subscribers.addAll(players.stream().map(Player::getBowlingStats).collect(Collectors.toList()));
            this.subscribers.addAll(players.stream().map(Player::getBowlingStats).collect(Collectors.toList()));
            this.subscribers.add(teamState);
            this.subscribers.add(teamExtras);

            UpdateStrategyFactory factory = new UpdateStrategyFactory();
            UpdateStrategy strategy = factory.getStrategy(event);
            subscribers.forEach(subscriber ->  subscriber.update(strategy, event));
        }


        Repository repository = new Repository();
        List<Inning> innings = repository.getBothInnings();
        Inning firstInning = innings.get(0);





        firstInning.getOvers().forEach( over -> {
            over.getDeliveries().forEach(team1::update);
        });
    }
}
