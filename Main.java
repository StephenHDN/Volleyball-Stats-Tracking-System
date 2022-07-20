import java.util.Scanner;

public class Main {
    static final String FILE_PATH = "src/";
    static Scanner INPUT = new Scanner(System.in);
    static Volleyball volleyball = null;

    public static void main(String[] args) {
        String file = "";
        String option;
        boolean success;
        boolean program = true;

        while (program) {
            printMenu();

            if (volleyball != null) {
                System.out.print("=> ");
                option = INPUT.nextLine();
            } else {
                System.out.println("Please load a file");
                option = "1";
            }

            switch (option) {
                // Exiting Program
                case "0": {
                    System.out.println("Now Exiting Program...\n");
                    program = false;
                    break;
                }

                // Load Player List from file
                case "1": {
                    boolean loaded;
                    volleyball = new Volleyball();
                    do {
                        System.out.printf("Enter the file name to load (default location: %s): ", FILE_PATH);
                        file = INPUT.nextLine();
                        loaded = volleyball.loadPlayers(FILE_PATH + file);
                        if (loaded) {
                            System.out.println("Player list in file \'" + file + "\' has been loaded.");
                            System.out.println();
                        } else {
                            System.out.println("Players not loaded!");
                        }
                    }
                    while (!loaded);
                    break;
                }

                // Save Player List to a file
                case "2": {
                    System.out.print("Do you want to use the same file name (" + file + ")? (yes/no) ");
                    option = INPUT.nextLine();
                    if (!option.equals("yes")) {
                        System.out.print("Enter a filename to save: ");
                        file = INPUT.nextLine();
                    }
                    System.out.println("Saving file...");
                    volleyball.savePlayersList(FILE_PATH + file);
                    System.out.println();
                    break;
                }

                // Add or Remove Players
                case "3": {
                    int option2 = 0;
                    boolean run = true;

                    while (run == true) {
                        System.out.println("(1)Add or (2)Remove Players?");
                        option2 = Integer.parseInt(INPUT.nextLine());

                        switch (option2) {
                            // Add Player
                            case 1: {
                                volleyball.addPlayer(INPUT);
                                run = false;
                                break;
                            }
                            // Remove Player
                            case 2: {
                                success = false;
                                String studentNum;
                                do {
                                    System.out.print("Enter a student number to remove from team: ");
                                    studentNum = INPUT.nextLine();
                                    if (volleyball.getPlayer(studentNum) != null) {
                                        success = true;
                                    } else {
                                        System.out.println("\nInvalid Student number. Please try again.\n");
                                    }
                                }
                                while (!success);
                                volleyball.removePlayer(studentNum);
                                System.out.println("Player removed.\n");
                                run = false;
                                break;
                            }
                            default: {
                                System.out.println("\n[<=>] Invalid option! [<=>] \n");
                            }
                        }
                    }
                    break;
                }

                // Update a Volleyball Player Stats
                case "4": {
                    int option2 = 0;
                    boolean run = true;

                    while (run == true) {
                        System.out.println("Update a (1)Offensive or (2)Defensive Player?");
                        option2 = Integer.parseInt(INPUT.nextLine());

                        switch (option2) {
                            // Offensive Players
                            case 1: {
                                System.out.println("[<=>]===========================[<=>]");
                                System.out.println("[<=>] Update Offensive Players Stats");
                                System.out.println("[<=>] Please note that this will add on to the following stats.");
                                System.out.println("[<=>] If a mistake is made, add a negative");
                                System.out.println("[<=>] Stats will reset when season has reset");
                                System.out.println("[<=>]===========================[<=>]");
                                System.out.print("[<=>] Enter the Student Number: ");
                                String studentNum = INPUT.nextLine();

                                System.out.print("Enter Hits: ");
                                int newHits = Integer.parseInt(INPUT.nextLine());

                                System.out.print("Enter Kills: ");
                                int newKills = Integer.parseInt(INPUT.nextLine());

                                System.out.print("Enter Points: ");
                                int newPoints = Integer.parseInt(INPUT.nextLine());

                                System.out.print("Enter the Practices Missed: ");
                                int newPracticeMissed = Integer.parseInt(INPUT.nextLine());

                                System.out.print("Enter Serves: ");
                                int newServes = Integer.parseInt(INPUT.nextLine());

                                System.out.print("Enter Serve Aces: ");
                                int newAces = Integer.parseInt(INPUT.nextLine());

                                System.out.print("Enter games played: ");
                                int newGames = Integer.parseInt(INPUT.nextLine());

                                volleyball.updateOffensivePlayer(studentNum, newHits, newKills, newPoints, newServes, newAces, newGames, newPracticeMissed);
                                run = false;
                                break;
                            }
                            // Defensive Players
                            case 2: {
                                System.out.println("[<=>]===========================[<=>]");
                                System.out.println("Update Defensive Players Stats");
                                System.out.println("Please note that this will add on to the following stats.");
                                System.out.println("If a mistake is made, add a negative");
                                System.out.println("Stats will reset when season has reset");
                                System.out.println("[<=>]===========================[<=>]");
                                System.out.print("Enter the Student Number: ");
                                String studentNum = INPUT.nextLine();

                                System.out.print("Enter Blocks: ");
                                int newBlocks = Integer.parseInt(INPUT.nextLine());

                                System.out.print("Enter Receives: ");
                                int newReceives = Integer.parseInt(INPUT.nextLine());

                                System.out.print("Enter Ball Errors: ");
                                int newBallErrors = Integer.parseInt(INPUT.nextLine());

                                System.out.print("Enter the Practices Missed: ");
                                int newPracticeMissed = Integer.parseInt(INPUT.nextLine());

                                System.out.print("Enter Serves: ");
                                int newServes = Integer.parseInt(INPUT.nextLine());

                                System.out.print("Enter Serve Aces: ");
                                int newAces = Integer.parseInt(INPUT.nextLine());

                                System.out.print("Enter games played: ");
                                int newGames = Integer.parseInt(INPUT.nextLine());

                                volleyball.updateDefensivePlayer(studentNum, newBlocks, newReceives, newBallErrors, newServes, newAces, newGames, newPracticeMissed);
                                run = false;
                                break;
                            } default: {
                                System.out.println("\n[<=>] Invalid option! [<=>] \n");
                            }
                        }
                    }
                    break;
                }

                // Display Player options
                case "5": {
                    int option2 = 0;
                    boolean run = true;

                    while (run == true) {
                        System.out.println("(1) List All Players\n" +
                                "(2) List Stats for a Player\n" +
                                "(3) List Stats for all Players");
                        option2 = Integer.parseInt(INPUT.nextLine());

                        switch (option2) {
                            // List All Players
                            case 1 : {
                                volleyball.showPlayers();
                                run = false;
                                break;
                            }
                            // List Stats for a Player, given student number
                            case 2 : {
                                System.out.println("[<=>]================================================[<=>]");
                                System.out.println("[<=>]========== Information of the Player ===========[<=>]");
                                System.out.print("Enter Student Number: ");
                                String studentNum = INPUT.nextLine();
                                volleyball.printPlayer(studentNum);
                                run = false;
                                break;
                            }
                            // List Stats for all Players on PlayerList
                            case 3 :  {
                                System.out.println("Information of all Players");
                                volleyball.printAllPlayers();
                                run = false;
                                break;
                            }
                            default: {
                                System.out.println("\n[<=>] Invalid option! [<=>] \n");
                            }
                        }
                    }
                    break;
                }

                // Search Player Options
                case "6": {
                    int option2 = 0;
                    boolean run = true;

                    while (run == true) {
                        System.out.println("(1) Search Players by Name");
                        System.out.println("(2) Search Players by Student Number");
                        option2 = Integer.parseInt(INPUT.nextLine());

                        switch (option2) {
                            // Search Player by Name, First and last Name
                            case 1: {
                                System.out.print("Enter Last Name: ");
                                String lastName = INPUT.nextLine();

                                System.out.print("Enter First Name: ");
                                String firstName = INPUT.nextLine();

                                System.out.println("Results:");
                                volleyball.searchName(lastName,firstName);
                                System.out.println();
                                run = false;
                                break;

                            }
                            // Search Player by Student Number
                            case 2: {
                                System.out.print("Enter Student Number: ");
                                String studentNum = INPUT.nextLine();

                                System.out.println("Results:");
                                volleyball.searchStudenNum(studentNum);
                                System.out.println();
                                run = false;
                                break;

                            }
                            default:{
                                System.out.println("\n[<=>] Invalid option! [<=>] \n");
                            }
                        }
                    }
                    break;
                }

                // Sort Players
                case "7": {
                    int option2 = 0;
                    boolean run = true;

                    while (run == true) {
                        System.out.println("(1) Sort Players by grade, ascending order");
                        System.out.println("(2) Sort Players by first name, A-Z");
                        option2 = Integer.parseInt(INPUT.nextLine());

                        switch (option2) {
                            // Sort Players by grade in ascending order
                            case 1: {
                                System.out.println("Sort by grade, ascending order");
                                System.out.println("Sorting...");
                                volleyball.sortGrade();
                                System.out.println("Sorting Complete\n");
                                run = false;
                                break;
                            }

                            // Sort Players by First name , A-Z
                            case 2: {
                                System.out.println("Sort by first name, A-Z");
                                System.out.println("Sorting...");
                                volleyball.sortFirstName();
                                System.out.println("Sorting Complete\n");
                                run = false;
                                break;
                            }
                                default: {
                                    System.out.println("\n[<=>] Invalid option! [<=>] \n");
                                }
                            }
                        }
                        break;
                    }

                // Reset Options
                case "8": {
                    int option2 = 0 ;
                    boolean run = true;
                    while (run == true) {
                        System.out.println("(1) Reset All Offensive Players Stats");
                        System.out.println("(2) Reset All Defensive Players Stats");
                        System.out.println("(3) Reset All Players");
                        System.out.print("=>");
                        option2 = Integer.parseInt(INPUT.nextLine());

                        switch (option2) {
                            // Reset All Offensive Player Stats
                            case 1: {
                                System.out.println("Resetting All Offensive Players Stats...");
                                volleyball.resetOffensivePlayer();
                                System.out.println("Reset Complete! \n");
                                run = false;
                                break;
                            }
                            // Reset All Defensive Player Stats
                            case 2: {
                                System.out.println("Resetting All Defensive Players Stats...");
                                volleyball.resetDefensivePlayer();
                                System.out.println("Reset Complete! \n");
                                run = false;
                                break;
                            }
                            // Reset All Player Stats
                            case 3: {
                                System.out.println("Resetting All Players");
                                volleyball.resetDefensivePlayer();
                                volleyball.resetOffensivePlayer();
                                System.out.println("Reset Complete \n");
                                run = false;
                                break;
                            }
                            default: {
                                System.out.println("\n[<=>] Invalid option! [<=>] \n");
                            }
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("\n[<=>] Invalid option! [<=>] \n");
                }
            }
            System.out.println("[<=>]================================================[<=>]");
            System.out.println("[<=>]             Press Enter to continue            [<=>]");
            System.out.println("[<=>]================================================[<=>]");
            INPUT.nextLine();
            System.out.println();
        }
    }

    public static void printMenu(){
        System.out.println("[<=>]================================================[<=>]");
        System.out.println("[<=>]========= Volleyball Player Statistics =========[<=>]");
        System.out.println("[<=>]================================================[<=>]");
        System.out.println("[<=>]     Choose an option from the menu:            [<=>]");
        System.out.println("[<=>]     [1] Load  Players from a file              [<=>]");
        System.out.println("[<=>]     [2] Save Players from a file               [<=>]");
        System.out.println("[<=>]     [3] Add or Remove a Player from the team   [<=>] ");
        System.out.println("[<=>]     [4] Update A Players Stats                 [<=>]");
        System.out.println("[<=>]     [5] Display Players/Player Information     [<=>]");
        System.out.println("[<=>]     [6] Search a Player                        [<=>]");
        System.out.println("[<=>]     [7] Sort a Players                         [<=>]");
        System.out.println("[<=>]     [8] Reset Players                          [<=>]");
        System.out.println("[<=>]     [0] Exit                                   [<=>]");
        System.out.println("[<=>]================================================[<=>]");
    }
}


