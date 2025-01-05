package Controls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import Phase1.PlayerList;

import java.util.ArrayList;


public class fileOperations {

    public static void loadFile(ArrayList<Player> playerList) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader("src/Data/players.txt"));
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
            Player player = new Player(name, country, age, height, club, position, number, salary, true);
            playerList.add(player);
        }
        br.close();
    }

    public static void loadCredentials(HashMap<String, String> userMap) throws IOException {
        // load credentials from file
        String FILE_NAME = "src/Data/credentials.txt";
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while((line = br.readLine()) != null)
        {
            String[] parts = line.split(",");
            userMap.put(parts[0], parts[1]);
        }
        br.close();
    }

    public static void loadInitial(HashMap<String, String> initialMap) throws IOException {
        // load credentials from file
        String FILE_NAME = "src/Data/initials.txt";
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while((line = br.readLine()) != null)
        {
            String[] parts = line.split(",");
            // System.out.println(parts[0] + " " + parts[1]);
            initialMap.put(parts[0], parts[1]);
        }
        System.out.println("Initials loaded");
        br.close();
    }

    public static void loadImages(HashMap<String, String> imageMap) throws IOException {
        // load images from file
        String FILE_NAME = "src/Data/image.txt";
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while((line = br.readLine()) != null)
        {
            String[] parts = line.split(",");
            imageMap.put(parts[0], parts[1]);
        }
        br.close();
    }

    public static void appendPlayer(ArrayList<Player> playerList, BufferedWriter bw) throws IOException
    {
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            bw.write(p.name + "," +  p.country + "," + Integer.toString(p.age) + "," + Double.toString(p.height) + "," + p.club + "," + p.position + ",");
            if(p.number != -1)
                bw.write(Integer.toString(p.number) + ",");
            bw.write(Integer.toString(p.salary));
            bw.newLine();
        }
    }

    public static void saveData(ArrayList<Player> playerList) throws Exception
    {
        listOperations.showAllPlayers(playerList);
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/Data/players.txt"));
        System.out.println("Saving data");
        appendPlayer(playerList, bw);
        bw.close();
    }
}
