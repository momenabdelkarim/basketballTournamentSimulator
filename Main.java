/* Description: This driver class creates a new object of collection/array of teams, creates a new object/instance of the
* game's UI, begins the prompt for adding teams, and then prompts for beginning the tournament.
*
* Overall, this program simulates the NBA playoffs except with a "king of the court" play-style. The first team entered
* into the game will continue to play until they are either eliminated or win the tournament. This is shown in code
* comment in the other classes. Blocking is random and the points scored are also randomly distributed between 0-3. 0
* points made is a miss, 1 point is a successful free throw attempt, 2 points is a normal "field goal," and 3 is a
* three-pointer from behind the arc.*/
public class Main {

    public static void main(String[] args) throws Exception {

        TeamCollection teams = new TeamCollection();
        TeamUI teamFrontEnd = new TeamUI();
        teamFrontEnd.prompt(teams);
        teamFrontEnd.beginGamePrompt(teams);
    }
}
