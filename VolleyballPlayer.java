public abstract class VolleyballPlayer implements Comparable<VolleyballPlayer>  {
    protected String studentNum;
    protected String firstName;
    protected String lastName;
    protected int grade;
    protected int practiceMissed;
    protected int totalServes;
    protected int totalAces;
    protected int games;

    /**
     * Initializes the VolleyballPlayer object.
     * @param studentNum the player's student number
     * @param firstName first name of the player
     * @param lastName last name of the player
     * @param grade grade of the player
     * @param practiceMissed the amount of practice missed of the player
     * @param totalAces total aces of the player
     * @param totalServes total serves of the player
     * @param games total games played by the player
     */
    public VolleyballPlayer(String studentNum, String firstName, String lastName, int grade, int practiceMissed, int totalAces, int totalServes, int games){
        this.studentNum = studentNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.practiceMissed = practiceMissed;
        this.totalServes = totalServes;
        this.totalAces = totalAces;
        this.games = games;
    }

    /**
     * adds additional missed practices
     * @param missedPractices additional missed practices
     */
    public void addMissedPractices(int missedPractices) {
        practiceMissed += missedPractices;
    }

    /**
     * adds additional serves
     * @param served additional serves
     */
    public void addServes(int served) {
        totalServes += served;
    }

    /**
     * adds aces serves
     * @param aced  additional serves
     */
    public void addAces(int aced){
        totalAces += aced;
    }

    /**
     * adds additional games
     * @param gamePlayed additional games
     */
    public void addGames(int gamePlayed){
        games += gamePlayed;
    }

    /**
     * returns the player student number
     * @return student number
     */
    public String getStudentNum() {return studentNum;}

    /**
     * returns the player first name
     * @return first name
     */
    public String getFirstName() {return firstName;}

    /**
     * returns the player last name
     * @return last name
     */
    public String getLastName() {return lastName;}

    /**
     * returns the player grade
     * @return grade
     */
    public int getGrade() {return grade;}

    /**
     * returns the player practices missed
     * @return practices missed
     */
    public int getPracticeMissed() {return practiceMissed;}

    /**
     * returns the player total serves
     * @return total serves
     */
    public int getTotalServes() {return totalServes;}

    /**
     * returns the player total aces
     * @return total aces
     */
    public int getTotalAces() {return totalAces;}

    /**
     * returns the player total games
     * @return games played by the player
     */
    public int getGames() {return games;}

    /**
     * returns the string representation of objects
     * @return players basic information
     */
    @Override
    public String toString() {
        return "Student Number: " + studentNum +
                "\n First Name: " + firstName +
                "\n Last Name: " + lastName +
                "\n Grade: " + grade;
    }

    /**
     * Returns if this object is less than, equal to, or greater than the other object and sorts the team list alphabetically.
     * @param other the object to compare with
     * @return greater equal or less than the other object
     */
    public int compareTo(VolleyballPlayer other){
        return this.firstName.compareTo(other.firstName);
    }

    /**
     * abstract method that prints stats
     */
    abstract void printStats();

    /**
     * abstract method to reset information
     */
    abstract void reset();

}
