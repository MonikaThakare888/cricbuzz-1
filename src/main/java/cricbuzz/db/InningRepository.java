package cricbuzz.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import cricbuzz.db.models.InningEntity;
import cricbuzz.models.inning.Inning;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class InningRepository {
    public List<Inning> getBothInnings() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader inningJson = new JsonReader(new FileReader("src/main/resources/innings.json"));
        Type listType = new TypeToken<List<InningEntity>>() {}.getType();
        List<InningEntity> inningEntityArray = gson.fromJson(inningJson, listType);
        return inningEntityArray.stream().map(InningEntity::toInning).collect(Collectors.toList());
    }
}
