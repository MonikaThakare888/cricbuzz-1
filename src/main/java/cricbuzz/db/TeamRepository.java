package cricbuzz.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import cricbuzz.models.Team;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class TeamRepository {
    public List<Team> getBothTeams() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader inningJson = new JsonReader(new FileReader("src/main/resources/teams.json"));
        Type listType = new TypeToken<List<Team>>() {}.getType();
        return gson.fromJson(inningJson, listType);
    }
}
