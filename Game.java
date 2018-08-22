/* Description: This class is the Game object that tracks the properties of the current basketball game and outputs a
* winner.*/

public class Game {

    private int homeScore = 0;
    private int awayScore = 0;
    private int homeBlockCount = 0;
    private int awayBlockCount = 0;

    //Default constructor... could be removed.
    public Game(){
    }

    /* Method that begins the game itself, like a referee blowing the whistle for the players to jump for the ball at
    the beginning of the game. The teams play until one of the teams scores at least 101 points. The home team will
    always possess the ball first, home-team advantage! The play method will call on the scoring and blocking methods
    from the Team class. Again, if the ball isn't blocked, then the team will score. Every time, however, the scoring
    team will steal the ball on the inbounding pass! So the ball only changes possession on blocks. This method is
    recursive in order to continue scoring until the game is over. Then, once the game is over, the winner is announced
    with their respective info by calling the toString method and the loser is removed from the tournament.*/
    public String play(Team homeTeam, Team awayTeam, TeamCollection teams){
        while(homeScore < 100 && awayScore < 100){
            if(awayTeam.blockBall() == false){
                homeScore += homeTeam.shootBall();
            }
            else{
                awayBlockCount++;
                if(homeTeam.blockBall() == false){
                    awayScore += awayTeam.shootBall();
                }
                else{
                    homeBlockCount++;
                    play(homeTeam, awayTeam, teams);
                }
            }

        }
        if(homeScore >= awayScore){
            teams.remove(awayTeam);
            return toString(homeTeam, awayTeam, homeScore, awayScore, homeBlockCount, awayBlockCount);
        }
        else{
            teams.remove(homeTeam);
            return toString(awayTeam, homeTeam, awayScore, homeScore, awayBlockCount, homeBlockCount);
        }
    }

    /* This toString method takes in who the winning and losing team are, their stats, and the stats of the game and
    prints them out in a cleanly formatted way.*/
    public String toString(Team winningTeam, Team losingTeam, int winningScore, int losingScore, int winningBlocks,
                           int losingBlocks){
        return "Game score: " + winningScore + "-" + losingScore + ", " + winningTeam.getTeamName() + " won with " +
        winningBlocks + " blocks to the " + losingBlocks + " blocks from the losing " + losingTeam.getTeamName() + ".";
    }

}
