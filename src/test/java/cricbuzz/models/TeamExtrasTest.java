package cricbuzz.models;

import cricbuzz.event.ExtraRunEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamExtrasTest {

    TeamExtras teamExtras = new TeamExtras();
    ExtraRunEvent extraRunEvent = ExtraRunEvent.BYE;

    @Test
    public void should_update_extra_runs_received(){
        teamExtras.updateExtraRunsReceived(extraRunEvent);
        assertEquals(1,teamExtras.getExtraRunsReceived().get(ExtraRunEvent.BYE));
    }

    @Test
    public void should_update_extra_runs_given(){
        teamExtras.updateExtraRunsGiven(extraRunEvent);
        assertEquals(1,teamExtras.getExtraRunsGiven().get(ExtraRunEvent.BYE));
    }
}
