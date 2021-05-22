package cricbuzz.db.models;

import cricbuzz.models.inning.Inning;
import cricbuzz.models.inning.InningName;

import java.util.List;
import java.util.stream.Collectors;

public class InningEntity {
    private final String name;
    private final List<OverEntity> overs;

    public InningEntity(String name, List<OverEntity> overs) {
        this.name = name;
        this.overs = overs;
    }

    public Inning toInning() {
        return new Inning(
                InningName.valueOf(this.name),
                overs.stream().map(OverEntity::toOver).collect(Collectors.toList())
        );
    }
}
