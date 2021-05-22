package cricbuzz;

import cricbuzz.db.Repository;
import cricbuzz.models.inning.Inning;

import java.io.FileNotFoundException;
import java.util.List;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Repository repository = new Repository();
        List<Inning> innings = repository.getBothInnings();
        System.out.println(innings.get(0).toString());
    }
}
