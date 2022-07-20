public class Offensive extends VolleyballPlayer{
    private String offRole;
    private int totalHits;
    private int totalPoints;
    private int totalKills;

    /**
     * initializes the offensive player object
     * @param studentNum player's student number
     * @param firstName first name of player
     * @param lastName last name of player
     * @param grade grade of player
     * @param practiceMissed practice missed of player
     * @param totalServes total serves of player
     * @param totalAces total aces of player
     * @param games games played of player
     * @param offRole offensive role of player
     * @param totalHits total hits of player
     * @param totalKills total kills of player
     * @param totalPoints total points of player
     */
    public Offensive(String studentNum, String firstName, String lastName, int grade, int practiceMissed, int totalServes, int totalAces, int games, String offRole, int totalHits, int totalKills, int totalPoints){
        super(studentNum, firstName, lastName, grade, practiceMissed, totalServes, totalAces,games);
        this.offRole = offRole;
        this.totalHits = totalHits;
        this.totalKills = totalKills;
        this.totalPoints = totalPoints;
    }

    /**
     * returns offensive role of player
     * @return offensive role of player
     */
    public String getOffRole() {return offRole;}

    /**
     * returns total hits of player
     * @return total hits of player
     */
    public int getTotalHits() {return  totalHits;}

    /**
     * returns total kills of player
     * @return total kills of player
     */
    public int getTotalKills() {return totalKills;}

    /**
     * returns total points of player
     * @return total points of player
     */
    public int getTotalPoints() {return totalPoints;}

    /**
     * adds additional hits of player
     * @param hits additional hits of player
     */
    public void addHits(int hits) {totalHits += hits;}

    /**
     * adds additional kills of player
     * @param kills additional kills of player
     */
    public void addKills(int kills) {totalKills += kills;}

    /**
     * adds additional points of player
     * @param points additional points of player
     */
    public void addPoints(int points) {totalPoints += points; }

    /**
     * calculates average hits per game of player
     * @return average hits per game of player
     */
    public double avgHitsPerGame() {
        return ((double) totalHits/games);
    }

    /**
     * calculates average points per game of player
     * @return average points per game of player
     */
    public double avgPPG() {
        return ((double) totalPoints/games);
    }

    /**
     * calculates kill accuracy percentage of player
     * @return kill accuracy percentage of player
     */
    public double killAccuracy() {return ((double) totalKills/totalHits) * 100;}

    /**
     * calculates serve ace percentage of player
     * @return serve ace percentage of player
     */
    public double serveAcePercentage() {
        return ((double) totalAces/totalServes)  * 100;
    }

    /**
     * calculates aces per game of player
     * @return aces per game of player
     */
    public double acePerGame() {
        return ((double) totalAces / games);
    }

    /**
     * resets offensive player's stats
     */
    public void reset() {
        totalHits = 0;
        totalKills = 0;
        totalPoints = 0;
        totalServes = 0;
        totalAces = 0;
        games = 0;
        practiceMissed = 0;
    }

    /**
     * print offensive player's stats
     */
    public void printStats(){
        System.out.println();
        System.out.println("\n[<=>]========== Information of the Player ===========[<=>]");
        System.out.println(this);
        System.out.println(" Offensive Role: " + offRole);
        System.out.println(" Practices Missed: " + practiceMissed);
        System.out.println(" games: " + games);
        System.out.println("[<=>]===================== STATS ====================[<=>]");
        System.out.println("Total Hits: " + totalHits );
        System.out.println("Total Kills: " + totalKills );
        System.out.println("Total Points: " +  totalPoints );
        System.out.printf("Average Hits per game: %.2f\n", avgHitsPerGame());
        System.out.printf("Average Points per game: %.2f\n", avgPPG());
        System.out.printf("Kills Percentage: %.2f%%\n", killAccuracy());
        System.out.println("[<=>]===================== SERVES ===================[<=>]");
        System.out.println("Total Serves: " + totalServes );
        System.out.println("Total Aces: " + totalAces);
        System.out.printf("Serve Ace percentage: %.2f%%\n", serveAcePercentage() );
        System.out.printf("Aces per game: %.2f\n", acePerGame()  );
        System.out.println("[<=>]================================================[<=>]\n");
        System.out.println();

    }

    /**
     * Returns the string representation of object
     * @return the players information
     */
    @Override
    public String toString(){ return super.toString() + ",Offensive" ;
    }

}
