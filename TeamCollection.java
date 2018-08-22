// Description: This class is Collection object that holds all the teams in an ArrayList.

import java.util.ArrayList;
import java.util.Iterator;

public class TeamCollection implements Iterable<Team> {
    private ArrayList<Team> teams = new ArrayList<Team>();

    //Adds specified team from array.
    public void add(Team team) {
        teams.add(team);
    }
    //Remove specified team from array.
    public void remove(Team team) {
        teams.remove(team);
    }


    //Method gets the team at the specified index.
    public Team getByIndex(int index) {
        return teams.get(index);
    }


    //Method prints a list of all teams remaining in the tournament.
    public String printRemainingTeams(){
        for(Team team: teams){
            return team.getTeamName();
        }
        return "your code is broken";
    }

    //Method returns the number of teams left in the tournament.
    public int getNumberOfTeamsLeft(){
        return teams.size();
    }

    //Iterator method that allows for iteration through the ArrayList of teams.
    @Override
    public Iterator<Team> iterator() {
        return teams.iterator();
    }

}