package cricbuzz;

import cricbuzz.models.Player;
import cricbuzz.models.Team;

import java.util.Arrays;
import java.util.List;

public class TeamsTestData {

    public List<Team> getData()
    {
        return Arrays.asList(
                new Team(
                        "Mumbai Indians",
                                Arrays.asList(
                                new Player( 1,"Rohit Sharma",1,1),
                                new Player( 2,"Quinton De Cock",2,2),
                                new Player( 3,"Kiron Pollard",3,3),
                                new Player( 4,"Trent Boult",4,4),
                                new Player( 5,"Trent Boult",5,5)
                        )

                ),
                new Team(
                        "Chennai Super Kings",
                        Arrays.asList(
                                new Player( 1,"Mahendra Singh Dhoni",1,1),
                                new Player( 2,"Faf Du Plesis",2,2),
                                new Player( 3,"Ravindra Jadeja",3,3),
                                new Player( 4,"Sam Curran",4,4),
                                new Player( 5,"Dwayne Bravo",5,5)
                        )

                ));
    }
}
