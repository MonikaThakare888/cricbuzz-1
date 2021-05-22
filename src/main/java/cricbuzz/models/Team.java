package cricbuzz.models;

import cricbuzz.models.deliveryresult.ExtraRunType;

import java.util.List;
import java.util.Map;

public class Team {
    private String name;
    private List<Player> players;
    private List<Player> battingOrder;
    private List<Player> bowlingOrder;
    private Map<ExtraRunType, Integer> extraRunsReceived;
    private Map<ExtraRunType, Integer> extraRunsGiven;

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
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

    public List<Player> getBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(List<Player> battingOrder) {
        this.battingOrder = battingOrder;
    }

    public List<Player> getBowlingOrder() {
        return bowlingOrder;
    }

    public void setBowlingOrder(List<Player> bowlingOrder) {
        this.bowlingOrder = bowlingOrder;
    }

    public Map<ExtraRunType, Integer> getExtraRunsReceived() {
        return extraRunsReceived;
    }

    public void setExtraRunsReceived(Map<ExtraRunType, Integer> extraRunsReceived) {
        this.extraRunsReceived = extraRunsReceived;
    }

    public Map<ExtraRunType, Integer> getExtraRunsGiven() {
        return extraRunsGiven;
    }

    public void setExtraRunsGiven(Map<ExtraRunType, Integer> extraRunsGiven) {
        this.extraRunsGiven = extraRunsGiven;
    }
}
