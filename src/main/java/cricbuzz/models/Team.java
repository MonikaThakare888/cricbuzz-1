package cricbuzz.models;

import cricbuzz.models.deliveryresult.Event;
import cricbuzz.strategy.UpdateStrategy;

import java.util.List;

public class Team implements Observer{
    private String name;
    private List<Player> players;
    private TeamExtras teamExtras;
    private TeamState teamState;
    private boolean isBatting;

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

    public TeamExtras getTeamExtras() {
        return teamExtras;
    }

    public void setTeamExtras(TeamExtras teamExtras) {
        this.teamExtras = teamExtras;
    }

    public TeamState getTeamState() {
        return teamState;
    }

    public void setTeamState(TeamState teamState) {
        this.teamState = teamState;
    }

    public boolean isBatting() {
        return isBatting;
    }

    public void setBatting(boolean batting) {
        isBatting = batting;
    }

    @Override
    public void update(UpdateStrategy strategy, Event event) {
        strategy.updateTeam(this, event);
    }
}
