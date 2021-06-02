package cricbuzz.db;


import cricbuzz.models.inning.Inning;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

//getting errors
public class InningRepositoryTest {

    InningRepository inningRepository = new InningRepository();

    @Test
    void should_read_all_innings_from_file() {
        List<Inning> innings = assertDoesNotThrow(() -> inningRepository.getBothInnings("src/test/resources/innings.json"));
        String[] inningsNames = innings.stream().map(Inning ::getName).toArray(String[]::new);
        String[] expectedUserInningsNamesArray = new String[] {"FIRST","SECOND"};
        assertArrayEquals(expectedUserInningsNamesArray, inningsNames);
    }
}
