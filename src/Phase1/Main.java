package Phase1;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main{
    // function to print main menu
    static Scanner scanner = new Scanner(System.in);
    static String FILE_NAME = "src/Phase1/players.txt";
    static String dummy;
    // Main menu
    public static void mainMenu()
    {
        System.out.println("Main Menu:");
        System.out.println("(1)Search Players");
        System.out.println("(2)Search Clubs");
        System.out.println("(3)Add Player");
        System.out.println("(4)Exit System");
    }
    // Option(1) - Search Players Menu
    public static void searchPlayersMenu()
    {
        System.out.println("Player Searching Options:");
        System.out.println("(1)By Player Name");
        System.out.println("(2)By Club and Country");
        System.out.println("(3)By Position");
        System.out.println("(4)By Salary Range");
        System.out.println("(5)Country-wise player count");
        System.out.println("(6)Back to Main Menu");
    }
    // Option(1) - Search Players
    public static void searchPlayers()
    {
        while(true)
        {
            searchPlayersMenu();
            int choice = scanner.nextInt();
            dummy = scanner.nextLine();
            // by player name
            if(choice == 1)
            {
                System.out.print("Enter a player name: ");
                String name = scanner.nextLine();
                PlayerList.searchByName(name);
            }
            // by country and club name
            else if(choice == 2)
            {
                System.out.print("Enter the name of the country to search: ");
                String country = scanner.nextLine();
                System.out.print("Enter the name of the club to search/ Or type Any to search all clubs of this country: ");
                String club = scanner.nextLine();
                PlayerList.searchByClubAndCountry(country, club);
            }
            // By position
            else if(choice == 3)
            {
                System.out.print("Enter the name of the position to search: ");
                String position = scanner.nextLine();
                PlayerList.searchByPosition(position);

            }
            // by weekly salary
            else if(choice == 4)
            {
                System.out.print("Enter the minimum weekly salary to search: ");
                int min = scanner.nextInt();
                System.out.print("Enter the maximum weekly salary to search: ");
                int max = scanner.nextInt();
                dummy = scanner.nextLine();
                PlayerList.searchBySalary(min, max);
            }
            else if(choice == 5)
            {
                PlayerList.countryWisePlayerCount();
            }
            else if(choice == 6)
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice");
            }
        }
    }
    // option(2) - Search Club Menu
    public static void searchClubsMenu()
    {
        System.out.println("(1)Player(s) with the maximum salary of a club");
        System.out.println("(2)Player(s) with the maximum age of a club");
        System.out.println("(3)Player(s) with the maximum height of a club");
        System.out.println("(4)Total yearly salary of a club");
        System.out.println("(5)Back to Main Menu");
    }
    // option(2) - Search clubs
    public static void searchByClub()
    {
        while(true)
        {
            searchClubsMenu();
            int choice = scanner.nextInt();
            dummy = scanner.nextLine();
            if(choice == 1)
            {
                System.out.print("Enter the club name: ");
                String club = scanner.nextLine();
                PlayerList.getMaxSalaryPlayer(club);
            }
            else if(choice == 2)
            {
                System.out.print("Enter the club name: ");
                String club = scanner.nextLine();
                PlayerList.getMaxAgePlayer(club);
            }
            else if(choice == 3)
            {
                System.out.print("Enter the club name: ");
                String club = scanner.nextLine();
                PlayerList.getMaxHeightPlayer(club);
            }
            else if(choice == 4)
            {
                System.out.print("Enter the club name: ");
                String club = scanner.nextLine();
                PlayerList.printTotalSalary(club);
            }
            else if(choice == 5)
            {
                break;
            }
            else
                System.out.println("Invalid choice");
        }
    }
    // option(3) - add player
    public static void addPlayer()
    {
        System.out.println("Enter the name of the player: ");
        String name = scanner.nextLine();
        if(PlayerList.isPlayerPresent(name))
        {
            System.out.println("Player with this name already exists");
            return;
        }
        System.out.print("Enter the country of the player: ");
        String country = scanner.nextLine();
        System.out.print("Enter the age in years: ");
        int age = scanner.nextInt();
        dummy = scanner.nextLine();
        System.out.print("Enter the height in meters : ");
        double height = scanner.nextDouble();
        dummy = scanner.nextLine();
        System.out.print("Enter the club of the player: ");
        String club = scanner.nextLine();
        System.out.print("Enter the position of the player: ");
        String position = scanner.nextLine();
        System.out.print("Enter the jersey number of the player: ");
        int number = scanner.nextInt();
        System.out.print("Enter the weekly salary of the player: ");
        int salary = scanner.nextInt();
        dummy = scanner.nextLine();
        PlayerList.addPlayer(name, country, age, height, club, position, number, salary, false);
    }
    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while((line = br.readLine()) != null)
        {
            String[] parts = line.split(",");
            String name = parts[0];
            String country = parts[1];
            int age = Integer.parseInt(parts[2]);
            double height = Double.parseDouble(parts[3]);
            String club = parts[4];
            String position = parts[5];
            int number = -1;
            if(!parts[6].isEmpty())
                number = Integer.parseInt(parts[6]);
            int salary = Integer.parseInt(parts[7]);
            PlayerList.addPlayer(name, country, age, height, club, position, number, salary, true);
        }
        br.close();
        while(true)
        {
            mainMenu();// displays main menu
            int choice;
            choice = scanner.nextInt();
            dummy = scanner.nextLine();
            // Search Player
            if(choice == 1)
            {
                searchPlayers();
            }
            // Search Club
            else if(choice == 2)
            {
                searchByClub();
            }
            // Add Player
            else if(choice == 3)
            {
                addPlayer();
            }
            else if(choice == 4)
                break;
            else
                System.out.println("Invalid choice");
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
        PlayerList.appendPlayer(bw);
        bw.close();
    }
}