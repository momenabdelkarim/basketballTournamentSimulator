/* Description: This is the class for the object known as team. Like a person, this object has properties as illustrated
* below. This object is stored in the TeamCollection object.*/

public class Team extends TeamCollection {

    private double rndm = Math.random();

    private String teamName = "";
    private int seedNumber = 0;
    private boolean cursed = false;
    private double shootingPCT = 0.0;

    //Constructor for Team object that sets team name, seed number, whether they are cursed, and their shooting percentage.
    public Team(String teamName, int seedNumber, boolean cursed, double shootingPCT){
        this.teamName = teamName;
        this.seedNumber = seedNumber;
        this.cursed = cursed;
        this.shootingPCT = shootingPCT;
    }

    /*Method simulates shooting a basketball. If the team is cursed, then they will score regularly compared to their
    regular season shooting averages only if their luck is good on that shot. If their luck is bad that shot, then they
    will miss. If the team is not cursed, then they will score regularly relative to their average season shooting. The
    points made my the respective team will be returned.*/
    public int shootBall(){
        int pointsMade = 0;
        if(cursed){
            pointsMade = (int)(4*shootingPCT);
            if(Math.random() >= .5){
                if(pointsMade > 3){
                    return 3;
                }
                else{
                    return pointsMade;
                }
            }
            else{
                return 0;
            }
        }
        else{
            pointsMade = (int)(4* shootingPCT);
            if(pointsMade > 3){
                return 3;
            }
            else{
                return pointsMade;
            }
        }

    }

    /* Randomly, a ball could be blocked depending on the luck of the defending team. If true is returned, then
    * no points are scored. If the ball is not blocked, or the return is false. Then the shot continues as normal.*/
    public boolean blockBall(){
        if(Math.random() >= .5){
           return true;
        }
        else{
            return false;
        }
    }

    // This method returns the team name.
    public String getTeamName(){
        return teamName;
    }

    // This method returns the seed # of the team.
    public int getSeedNumber(){
        return seedNumber;
    }

    // This method returns whether the team is cursed or not.
    public boolean getCursed(){
        return cursed;
    }

    // This method returns the shooting percentage of the team.
    public double getShootingPCT(){
        return shootingPCT;
    }

    // This toString method will return all information and statistics on the specified team.
    public String toString(){
        return "Team Name: " + getTeamName() + '\n' + "Seed #: " + getSeedNumber() + '\n' + "Playoff Cursed? (like the " +
                "Trailblazers): " + getCursed() + '\n' + "Avg Regular Season Team Shooting %: "+ getShootingPCT();
    }
}
