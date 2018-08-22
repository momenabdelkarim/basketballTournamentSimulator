// Description: This class is the object for the user interface (UI) for the game/tournament.

import java.util.Scanner;

public class TeamUI {

    /* This method asks the user prompts the user to either use the default teams input into the system or if they would
    * would like to provide their own teams and statistics. The former is for ease of testing for the TA's. Either way,
    * the new team objects are created and added to the TeamCollection array.*/
    public void prompt(TeamCollection teams){
        System.out.println("Do you want to use the default 8 teams in the system right now (easy for testing)?" + '\n' +
                        "If not, you will have to add 8 teams with their respective info as prompted on your own. (Y/N)");
        Scanner in = new Scanner(System.in);

        if(in.next().equalsIgnoreCase("y")){
            Team newTeam1 = new Team("Suns", 1, true, .7);
            Team newTeam2 = new Team("Lakers", 2, false, .5);
            Team newTeam3 = new Team("Warriors", 3, true, .8);
            Team newTeam4 = new Team("Blazers", 4, false, .6);
            Team newTeam5 = new Team("Pelicans", 5, false, .92);
            Team newTeam6 = new Team("Rockets", 6, true, .56);
            Team newTeam7 = new Team("Heat", 7, false, .48);
            Team newTeam8 = new Team("Sixers", 8, true, .74);

            teams.add(newTeam1);
            teams.add(newTeam2);
            teams.add(newTeam3);
            teams.add(newTeam4);
            teams.add(newTeam5);
            teams.add(newTeam6);
            teams.add(newTeam7);
            teams.add(newTeam8);
        }

        else{
            for (int x = 0; x < 8; x++) {
                System.out.println("Team " + (x+1) + "\'s name (spelling matters): ");
                String name = in.next();
                System.out.println(name + "\'s seeding into the playoffs (1-8, no duplicates): ");
                int seed = in.nextInt();
                System.out.println("Are the " + name + " usually cursed coming into the playoffs (true/false)?:");
                boolean cursed = false;
                if(in.next().equalsIgnoreCase("y")){
                    cursed = in.nextBoolean();
                }
                System.out.println("What is the " + name + "\'s shooting % during the regular season (ex: .9)");
                double shootingPCT = in.nextDouble();
                Team newTeam = new Team(name, seed, cursed, shootingPCT);
                teams.add(newTeam);
            }
        }

    }

    /*This method prompts the user to begin or wait on beginning the tournament after all the teams have been added.
    * If the user does not want to start, the method recursively asks the user to begin the tournament.
    * Once the tournament begins, a new Game object is created, which calls the play method. The teams that play are the
     * first and second teams in the list, in that order, every time, until only one team remains. Then that winning
     * team's information and statistics are announced and printed.*/
    public void beginGamePrompt(TeamCollection teams){
        System.out.println("Would you like to begin the tournament? (Y/N)");
        Scanner in = new Scanner(System.in);
        if(in.next().equalsIgnoreCase("y")){
            while(teams.getNumberOfTeamsLeft() > 1){
                Game newGame = new Game();
                System.out.println(newGame.play(teams.getByIndex(0),
                        teams.getByIndex(1), teams));
            }

            System.out.println('\n'+ "The 2018 CSE 205 Playoffs Champion Team is the " + teams.printRemainingTeams() + " who "
                    + "came into the tournament with the following information: " + '\n' + teams.getByIndex(0).toString());

        }
        else{
            beginGamePrompt(teams);
        }
    }

}
