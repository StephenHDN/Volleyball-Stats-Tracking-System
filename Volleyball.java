import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Volleyball {
    private ArrayList<VolleyballPlayer> playerList;

    /**
     * Initializes the playerList array
     */
    public Volleyball() { playerList = new ArrayList<>();}

    /**
     * Loads the team from the file that is given
     * @param file The name of the file
     * @return returns if loading was succesful
     */
    public boolean loadPlayers(String file ){
        BufferedReader read;
        String line;
        try{
            read = new BufferedReader(new FileReader(file));
            line = read.readLine();
            while (line != null){
                String[] stats = line.split(",");
                if (stats[8].equals("Offensive")){
                    playerList.add(new Offensive(stats[0], stats[1], stats[2], Integer.parseInt(stats[3]),
                            Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), Integer.parseInt(stats[6]),
                            Integer.parseInt(stats[7]), stats[9], Integer.parseInt(stats[10]), Integer.parseInt(stats[11]),
                            Integer.parseInt(stats[12])));
                }
                else if (stats[8].equals("Defensive")){
                    playerList.add(new Defensive(stats[0], stats[1], stats[2], Integer.parseInt(stats[3]),
                            Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), Integer.parseInt(stats[6]),
                            Integer.parseInt(stats[7]), stats[9], Integer.parseInt(stats[10]), Integer.parseInt(stats[11]),
                            Integer.parseInt(stats[12])));
                }
                else{
                    throw new IOException();
                }
                line = read.readLine();
            }
            read.close();
            return true;
        }
        catch (IOException iox){
            System.out.println("Problem with reading the file.");
            return false;
        }
    }

    /**
     * Saves the playerlist to the same file or a new file
     * @param filename the filename that the playerList is saved too
     * @return If saving the team is successful
     */
    public boolean savePlayersList(String filename){
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            for (VolleyballPlayer temp : playerList){
                out.write(temp.studentNum + "," + temp.firstName + "," + temp.lastName + "," + temp.grade + "," + temp.practiceMissed + "," + temp.totalAces + "," + temp.totalServes + "," + temp.games );
                if (temp instanceof Offensive){
                    out.write(",Offensive," + ((Offensive) temp).getOffRole() + "," + ((Offensive) temp).getTotalHits() + "," + ((Offensive) temp).getTotalKills() + "," + ((Offensive) temp).getTotalPoints() + "\n");
                }
                else{
                    out.write(",Defensive," + ((Defensive) temp).getDefRole() + "," + ((Defensive) temp).getTotalBlocks() + "," + ((Defensive) temp).getTotalReceives() + "," + ((Defensive) temp).getTotalBallErrors() + "\n");
                }
            }
            out.close();
            return true;
        }
        catch (IOException iox){
            System.out.println("Problem writing " + filename);
            return false;
        }
    }

    /**
     * Prints the list of players basic information
     */
    public void showPlayers() {
        System.out.println("All Team Members:");
        for (VolleyballPlayer temp : playerList) {
            System.out.println(temp);
            System.out.println("[<=>]================================================[<=>]");
        }
        System.out.println();
    }

    /**
     * Returns a specific player given the student number
     * @param studentNum the student number of the player
     * @return The player if given a correct student number
     */
    public VolleyballPlayer getPlayer(String studentNum) {
        for (VolleyballPlayer temp : playerList) {
            if (temp.getStudentNum().equals(studentNum)) {
                return temp;
            }
        }
        return null;
    }

    /**
     * Adds a player to playerList
     * @param input the information of the player
     */
    public void addPlayer(Scanner input){
        String option;
        String[] stats = new String[12];
        boolean matches;
        boolean success = true;

        while(success){
            System.out.println("\nChoose an option to add:");
            System.out.println("  1. Add a new Defensive Player");
            System.out.println("  2. Add a new Offensive Player ");
            System.out.print("> ");
            option = input.nextLine();

            switch (option){
                // Adding Offensive Player if chooses to
                case "1":{
                    System.out.println("Please enter the following details:");
                    do{
                        matches = false;
                        System.out.print("Student Number: ");
                        stats[0] = input.nextLine();
                        // Checks if the student number exist among the players
                        for (VolleyballPlayer temp : playerList){
                            if (temp.studentNum.equals(stats[0])){
                                matches = true;
                                System.out.println("Player already exist. Please try again.");
                            }
                        }
                    } while(matches);
                    System.out.print("First Name: ");
                    stats[1] = input.nextLine();
                    System.out.print("Last Name: ");
                    stats[2] = input.nextLine();
                    System.out.print("grade: ");
                    stats[3] = input.nextLine();
                    System.out.print("Practice Missed: ");
                    stats[4] = input.nextLine();
                    System.out.print("Total Serves: ");
                    stats[5] = input.nextLine();
                    System.out.print("Total Aces: ");
                    stats[6] = input.nextLine();
                    System.out.print("games: ");
                    stats[7] = input.nextLine();
                    System.out.println("Please choose the following Defensive roles: Blocker Specialist, Middle Blocker, Defense Specialist, Libero, Setter");
                    System.out.print("Defensive Role: ");
                    stats[8] = input.nextLine();
                    System.out.print("Total Blocks: ");
                    stats[9] = input.nextLine();
                    System.out.print("Total Receives: ");
                    stats[10] = input.nextLine();
                    System.out.print("Total Ball Errors: ");
                    stats[11] = input.nextLine();

                    playerList.add(new Defensive(stats[0], stats[1], stats[2], Integer.parseInt(stats[3]),
                            Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), Integer.parseInt(stats[6]),
                            Integer.parseInt(stats[7]), stats[8], Integer.parseInt(stats[9]), Integer.parseInt(stats[10]),
                            Integer.parseInt(stats[11])));
                    System.out.println("\n new Defensive Player added to the team.\n");
                    success = false;
                    break;
                }
                case "2":{
                    System.out.println("Please enter the following details:");
                    do{
                        matches = false;
                        System.out.print("Student Number : ");
                        stats[0] = input.nextLine();
                        for (VolleyballPlayer temp : playerList){
                            if (temp.studentNum.equals(stats[0])){
                                matches = true;
                                System.out.println("Player already exist. Please try again.");
                            }
                        }
                    } while(matches);
                    System.out.print("First Name: ");
                    stats[1] = input.nextLine();
                    System.out.print("Last Name: ");
                    stats[2] = input.nextLine();
                    System.out.print("Grade: ");
                    stats[3] = input.nextLine();
                    System.out.print("Practiced Missed: ");
                    stats[4] = input.nextLine();
                    System.out.print("Total Serves: ");
                    stats[5] = input.nextLine();
                    System.out.print("Total Aces: ");
                    stats[6] = input.nextLine();
                    System.out.print("games: ");
                    stats[7] = input.nextLine();
                    System.out.println("Please choose the following Offensive Roles: Opposite Hitter, Outside Hitter, Middle Hitter, Serving Specialist");
                    System.out.print("Offensive Role: ");
                    stats[8] = input.nextLine();
                    System.out.print("Total Hits: ");
                    stats[9] = input.nextLine();
                    System.out.print("Total Kills ");
                    stats[10] = input.nextLine();
                    System.out.print("Total Points ");
                    stats[11] = input.nextLine();

                    playerList.add(new Offensive(stats[0], stats[1], stats[2], Integer.parseInt(stats[3]),
                            Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), Integer.parseInt(stats[6]),
                            Integer.parseInt(stats[7]), stats[8], Integer.parseInt(stats[9]), Integer.parseInt(stats[10]),
                            Integer.parseInt(stats[11])));
                    System.out.println("\n new Offensive Player has been added to the team! \n");
                    success = false;
                    break;
                }
                default:{
                    System.out.println("\n Invalid ");
                }
            }
        }
    }

    /**
     * removes a player with the given student number
     * @param studentNum student number given
     */
    public void removePlayer(String studentNum){
        VolleyballPlayer temp = getPlayer(studentNum);
        if (temp != null){
            playerList.remove(temp);
        }
    }

    /**
     * searches a player given the name
     * @param lastName last name of player
     * @param firstName first name of player
     */
    public void searchName(String lastName, String firstName){
        for (VolleyballPlayer temp : playerList){
            if (temp.getLastName().equals(lastName) && (temp.getFirstName().equals(firstName))){
                System.out.println(temp);
            }
        }
    }

    /**
     * search a player given student number
     * @param studentNum student number given
     */
    public void searchStudenNum(String studentNum){
        for (VolleyballPlayer temp : playerList){
            if (temp.getStudentNum().equals(studentNum)){
                System.out.println(temp);
            }
        }
    }

    /**
     * sort players by grade in ascending order
     */
    public void sortGrade(){
        // sorting by Insertion Sort method
        int position;
        VolleyballPlayer current;

        for (int i = 1; i < playerList.size(); i++) {
            position = i;
            current = playerList.get(i);
            while (position > 0 && (current.grade < playerList.get(position - 1).grade)) {
                playerList.set(position, playerList.get(position - 1));
                position--;
            }
            playerList.set(position, current);
        }
    }

    /**
     * sort players by first name, A-Z
     */
    public void sortFirstName(){
        Collections.sort(playerList);
    }

    /**
     * Print Player given student number
     * @param studentNum student number given
     */
    public void printPlayer(String studentNum){
        if (getPlayer(studentNum) == null){
            System.out.println("Player with the student number [" + studentNum + "] is not found!\n");
        }
        else{
            getPlayer(studentNum).printStats();
        }
    }

    /**
     * print all players information
     */
    public void printAllPlayers(){
        System.out.println("Teams Information:");
        for (VolleyballPlayer temp : playerList) {
            temp.printStats();
        }
    }

    /**
     * updates the offensive player stats given the required stats
     * @param studentNum student number given
     * @param hits additional hits
     * @param kills additional kills
     * @param points additional points
     * @param serves additional serves
     * @param aces additional aces
     * @param gamesPlayed additional gamesPlayed
     * @param practiceMissed additional practice missed
     */
    public void updateOffensivePlayer(String studentNum, int hits, int kills, int points, int serves, int aces, int gamesPlayed, int practiceMissed){
        if (getPlayer(studentNum) != null){
            ((Offensive) getPlayer(studentNum)).addHits(hits);
            ((Offensive) getPlayer(studentNum)).addKills(kills);
            ((Offensive) getPlayer(studentNum)).addPoints(points);
            ((Offensive) getPlayer(studentNum)).addServes(serves);
            ((Offensive) getPlayer(studentNum)).addAces(aces);
            ((Offensive) getPlayer(studentNum)).addGames(gamesPlayed);
            ((Offensive) getPlayer(studentNum)).addMissedPractices(practiceMissed);

            System.out.println("Offensive Player's Information has been Updated.");
            System.out.println();
        }
        else{
            System.out.println("Player with the student number [" + studentNum + "] is not found!\n");
        }
    }

    /**
     * updates the defensive player stats, given the student number and the stats
     * @param studentNum student number given
     * @param blocks additional blocks
     * @param receives additional receives
     * @param ballErrors additional ball errors
     * @param serves additional serves
     * @param aces additional aces
     * @param gamesPlayed additional games played
     * @param practiceMissed additional practice missed
     */
    public void updateDefensivePlayer(String studentNum, int blocks, int receives, int ballErrors, int serves, int aces, int gamesPlayed, int practiceMissed){
        if (getPlayer(studentNum) != null){
            ((Defensive) getPlayer(studentNum)).addBlocks(blocks);
            ((Defensive) getPlayer(studentNum)).addReceives(receives);
            ((Defensive) getPlayer(studentNum)).addBallErrors(ballErrors);
            ((Defensive) getPlayer(studentNum)).addServes(serves);
            ((Defensive) getPlayer(studentNum)).addAces(aces);
            ((Defensive) getPlayer(studentNum)).addGames(gamesPlayed);
            ((Defensive) getPlayer(studentNum)).addMissedPractices(practiceMissed);

            System.out.println("Defensive Player's Information has been Updated.");
            System.out.println();
        }
        else{
            System.out.println("Player with the student number [" + studentNum + "] is not found!\n");
        }
    }

    /**
     * reset all offensive player stats
     */
    public void resetOffensivePlayer(){
        for (VolleyballPlayer temp : playerList){
            // If the team member is a player
            if (temp instanceof Offensive){
                temp.reset();
            }
        }
    }

    /**
     * reset all defensive player stats
     */
    public void resetDefensivePlayer(){
        for (VolleyballPlayer temp : playerList){
            // If the team member is a player
            if (temp instanceof Defensive){
                temp.reset();
            }
        }
    }



}
