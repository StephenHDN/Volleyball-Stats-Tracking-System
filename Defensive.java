public class Defensive extends VolleyballPlayer {
    private String defRole;
    private int totalBlocks;
    private int totalReceives;
    private int totalBallErrors;

    /**
     * initializes the defensive player object
     * @param studentNum player's student number
     * @param firstName first name of player
     * @param lastName last name of player
     * @param grade grade of player
     * @param practiceMissed practice missed of player
     * @param totalServes total serves of player
     * @param totalAces total aces of player
     * @param games games played of player
     * @param defRole defensive role of player
     * @param totalBlocks total blocks of player
     * @param totalReceives total receives of player
     * @param totalBallErrors total ball errors of player
     */
    public Defensive( String studentNum, String firstName, String lastName, int grade, int practiceMissed, int totalServes, int totalAces, int games, String defRole, int totalBlocks, int totalReceives, int totalBallErrors) {
        super(studentNum,firstName, lastName, grade, practiceMissed, totalServes, totalAces, games);
        this.defRole = defRole;
        this.totalBlocks = totalBlocks;
        this.totalReceives = totalReceives;
        this.totalBallErrors = totalBallErrors;
    }

    /**
     * returns defensive role of player
     * @return defensive role of player
     */
    public String getDefRole() {
        return defRole;
    }

    /**
     * returns total blocks of player
     * @return  total blocks of player
     */
    public int getTotalBlocks() {
        return totalBlocks;
    }

    /**
     * returns total receives
     * @return total receives
     */
    public int getTotalReceives() {
        return totalReceives;
    }

    /**
     * returns total ball errors
     * @return total ball errors
     */
    public int getTotalBallErrors() {
        return totalBallErrors;
    }

    /**
     * adds additional blocks
     * @param blocks additional blocks
     */
    public void addBlocks(int blocks) {
        totalBlocks += blocks;
    }

    /**
     * adds additional receives
     * @param receives additional receives
     */
    public void addReceives(int receives){
        totalReceives += receives;
    }

    /**
     * adds additional ball errors
     * @param ballErrors additional ball errors
     */
    public void addBallErrors(int ballErrors){
        totalBallErrors += ballErrors;
    }

    /**
     * calculates average blocks per game
     * @return blocks per game
     */
    public double avgBlocksPerGame() {
        return ((double) totalBlocks / games);
    }

    /**
     * calculate average receives per game
     * @return average receives per game
     */
    public double avgReceivesPerGame() {
        return ((double) totalReceives / games);
    }

    /**
     * calculate ball error percentage
     * @return ball error percentage
     */
    public double ballErrorPercentage() {
        return (((double) totalBallErrors / totalReceives) * 100);
    }

    /**
     * calculate average ball errors per game
     * @return  average ball errors per game
     */
    public double avgBallErrorsPerGame() {
        return ((double) totalBallErrors / games);
    }

    /**
     * calculate serve ace percentage
     * @return serve ace percentage
     */
    public double serveAcePercentage() {
        return ((double) totalAces / totalServes) * 100;
    }

    /**
     * calculate aces per game
     * @return aces per game
     */
    public double acePerGame() {
        return ((double) totalAces / games);
    }

    /**
     * reset defensive players stats
     */
    public void reset() {
        totalBlocks = 0;
        totalReceives = 0;
        totalBallErrors = 0;
        totalServes = 0;
        totalAces = 0;
        games = 0;
        practiceMissed = 0;
    }

    /**
     * prints defensive stats
     */
    public void printStats() {
        System.out.println("\n[<=>]============================================[<=>]");
        System.out.println(this);
        System.out.println(" Defensive Role: " + defRole);
        System.out.println(" Practices Missed: " + practiceMissed);
        System.out.println(" games: " + games);
        System.out.println("[<=>]===================== STATS ================[<=>]");
        System.out.println("Total Blocks: " + totalBlocks);
        System.out.println("Total Receives: " + totalReceives);
        System.out.println("Total Ball Errors: " + totalBallErrors);
        System.out.printf("Average Blocks per Game: %.2f\n", avgBlocksPerGame());
        System.out.printf("Average Receives per Game: %.2f\n", avgReceivesPerGame());
        System.out.printf("Ball Error Percentage: %.2f%%\n", ballErrorPercentage());
        System.out.printf("Average Ball Errors Per Game: %.2f\n", avgBallErrorsPerGame());
        System.out.println("[<=>]===================== SERVES ================[<=>]");
        System.out.println("Total Serves: " + totalServes);
        System.out.println("Total Aces: " + totalAces);
        System.out.printf("Serve Ace percentage: %.2f%%\n", serveAcePercentage());
        System.out.printf("Aces per game: %.2f\n", acePerGame());
        System.out.println("[<=>]============================================[<=>]\n");

    }

    /**
     * Returns the string representation of the object.
     * @return The player's information
     */
    @Override
    public String toString(){
        return super.toString() + ",Defensive"  ;
    }
}
