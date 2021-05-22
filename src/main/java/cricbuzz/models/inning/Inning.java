package cricbuzz.models.inning;

import java.util.List;

public class Inning {
    private final InningName name;
    private final List<Over> overs;

    public Inning(InningName name, List<Over> overs) {
        this.name = name;
        this.overs = overs;
    }

    public InningName getName() {
        return name;
    }

    public List<Over> getOvers() {
        return overs;
    }

    @Override
    public String toString() {
        return "Inning{" +
                "name=" + name +
                ", overs=" + overs.toString() +
                '}';
    }
}
