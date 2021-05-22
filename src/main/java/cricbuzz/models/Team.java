package cricbuzz.models;

import cricbuzz.models.deliveryresult.Event;
import cricbuzz.models.deliveryresult.ExtraRunEvent;

import java.util.List;
import java.util.Map;

public class Team {
    private String name;
    private List<Player> players;
    private Map<ExtraRunEvent, Integer> extraRunsReceived;
    private Map<ExtraRunEvent, Integer> extraRunsGiven;
    private TeamState teamState;

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    public void update(Event event){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Map<ExtraRunEvent, Integer> getExtraRunsReceived() {
        return extraRunsReceived;
    }

    public void setExtraRunsReceived(Map<ExtraRunEvent, Integer> extraRunsReceived) {
        this.extraRunsReceived = extraRunsReceived;
    }

    public Map<ExtraRunEvent, Integer> getExtraRunsGiven() {
        return extraRunsGiven;
    }

    public void setExtraRunsGiven(Map<ExtraRunEvent, Integer> extraRunsGiven) {
        this.extraRunsGiven = extraRunsGiven;
    }

    public TeamState getTeamState() {
        return teamState;
    }

    public void setTeamState(TeamState teamState) {
        this.teamState = teamState;
    }
}
