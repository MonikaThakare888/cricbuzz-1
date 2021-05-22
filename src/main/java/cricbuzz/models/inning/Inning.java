package cricbuzz.models.inning;

import java.util.List;

public class Inning {
    private InningName name;
    private List<Over> overs;

    public Inning(InningName name, List<Over> overs) {
        this.name = name;
        this.overs = overs;
    }

    @Override
    public String toString() {
        return "Inning{" +
                "name=" + name +
                ", overs=" + overs.toString() +
                '}';
    }
}
