package Phase1;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.IOException;


public class PlayerList {
    static List <Player> playerList = new ArrayList<>();

    public static void addPlayer(String name, String country, int age, double height, String club, String position, int number, int salary, boolean exist)
    {
        Player p = new Player(name, country, age, height, club, position, number, salary, exist);
        playerList.add(p);
    }

    public static void showDetails(Player x)
    {
        System.out.println("-----------------------------");
        System.out.println("Name: " + x.name);
        System.out.println("Country: " + x.country);
        System.out.println("Age: " + x.age);
        System.out.println("Height: " + x.height);
        System.out.println("Club: " + x.club);
        System.out.println("Position: " + x.position);
        if(x.number != -1)
            System.out.println("Jersey Number: " + x.number);
        System.out.println("Weekly Salary: " + x.salary);
        System.out.println("-----------------------------");
    }

    public static void showAllPlayers(List<Player> list)
    {
        if(list == null || list.size() == 0)
            return;
        System.out.println("*****************************");
        for(int i = 0;i < list.size();i++)
        {
            showDetails(list.get(i));
        }
        System.out.println("*****************************");
    }

    public static boolean isPlayerPresent(String str)
    {
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if((p.name).equals(str))
            {
                return true;
            }
        }
        return false;
    }

    public static Player getSearchByNamePlayer(String name)
    {
        Player temp = null;
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if((p.name).equals(name))
            {
                temp = p;
                return temp;
            }
        }
        return null;
    }

    public static void searchByName(String name)
    {
        Player player = getSearchByNamePlayer(name);
        if(player == null)
        {
            System.out.println("No such player with this name");
            return;
        }
        showDetails(player);
    }

    public static List<Player> getSearchByClubAndCountryList(String country, String club)
    {
        List <Player> temp = new ArrayList<>();
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if((p.country).equals(country) && ((p.club).equals(club) || club.equals("Any")))
            {
                temp.add(p);
            }
        }
        return temp;
    }

    public static void searchByClubAndCountry(String country, String club)
    {
        List<Player> list = getSearchByClubAndCountryList(country, club);
        if(list == null)
        {
            System.out.println("No such player with this country and club");
            return;
        }
        System.out.println("Player(s) with country " + country + " and club " + club + " are: ");
        showAllPlayers(list);
    }

    public static List<Player> getSearchByPosition(String position)
    {
        List <Player> temp = new ArrayList<>();
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if((p.position).equals(position))
            {
                temp.add(p);
            }
        }
        if(temp.size() == 0)
        {
            return null;
        }
        return temp;
    }

    public static void searchByPosition(String position)
    {
        List<Player> list = getSearchByPosition(position);
        if(list == null)
        {
            System.out.println("No such player with this position");
            return;
        }
        System.out.println("Player(s) with position " + position + " are: ");
        showAllPlayers(list);
    }

    static public List<Player> getSearchBySalary(int min, int max)
    {
        List <Player> temp = new ArrayList<>();
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if((p.salary) >= min && (p.salary) <= max)
            {
                temp.add(p);
            }
        }
        return temp;
    }

    static public void searchBySalary(int min, int max)
    {
        List<Player> list = getSearchBySalary(min, max);
        if(list == null)
        {
            System.out.println("No such player with this salary range");
            return;
        }
        System.out.println("Player(s) with salary range " + min + " to " + max + " are: ");
        showAllPlayers(list);
    }

    public static Map<String, Integer> getCountryWisePlayerCountMap()
    {
        Map <String, Integer> map = new HashMap<>();
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            map.put(p.country, map.getOrDefault(p.country, 0) + 1);
        }
        return map;
    }

    public static void countryWisePlayerCount()
    {
        Map <String, Integer> map = getCountryWisePlayerCountMap();
        System.out.println("Showing country wise player count: ");
        System.out.println("--------------------------------------");
        System.out.println("Country || Player Count");
        for(Map.Entry<String, Integer> entry:map.entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("--------------------------------------");
    }

    public static List<Player> getMaxSalaryPlayerList(String club)
    {
        int max = -1;
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if((p.club).equals(club))
            {
                max = Math.max(max, p.salary);
            }
        }
        List<Player> temp = new ArrayList<>();
        if(max == -1)
        {
            return temp;
        }
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if(p.salary == max && (p.club).equals(club))
            {
                temp.add(p);
            }
        }
        return temp;
    }

    public static void getMaxSalaryPlayer(String club)
    {
        List<Player> list = getMaxSalaryPlayerList(club);
        if(list == null || list.size() == 0)
        {
            System.out.println("No such club with this name");
            return;
        }
        System.out.println("Player(s) with maximum salary of " + club + " are: ");
        showAllPlayers(list);
    }

    public static List<Player> getMaxAgePlayerList(String club)
    {
        int max = -1;
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if((p.club).equals(club))
            {
                max = Math.max(max, p.age);
            }
        }
        List <Player> temp = new ArrayList<>();
        if(max == -1)
        {
            return temp;
        }
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if(p.age == max && (p.club).equals(club))
            {
                temp.add(p);
            }
        }
        return temp;
    }

    public static void getMaxAgePlayer(String club)
    {
        List<Player> list = getMaxAgePlayerList(club);
        if(list == null || list.size() == 0)
        {
            System.out.println("No such club with this name");
            return;
        }
        System.out.println("Player(s) with maximum age of " + club + " are: ");
        showAllPlayers(list);
    }

    public static List<Player> getMaxHeightPlayerList(String club)
    {
        double max = -1;
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if((p.club).equals(club))
            {
                max = Math.max(max, p.height);
            }
        }
        if(max < 0)
        {
            return null;
        }
        List<Player> temp = new ArrayList<>();
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if(p.height == max && (p.club).equals(club))
            {
                temp.add(p);
            }
        }
        return temp;
    }

    public static void getMaxHeightPlayer(String club)
    {
        List<Player> list = getMaxHeightPlayerList(club);
        if(list == null)
        {
            System.out.println("No such club with this name");
            return;
        }
        System.err.println("Player(s) with maximum height of " + club + " are: ");
        showAllPlayers(list);
    }

    public static int getTotalSalary(String club)
    {
        int total = -1;
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if((p.club).equals(club))
            {
                if(total == -1)
                    total = p.salary;
                else
                    total += p.salary;
            }
        }
        return total;
    }

    public static void printTotalSalary(String club)
    {
        int total = getTotalSalary(club);
        if(total == -1)
        {
            System.out.println("No such club with this name");
            return;
        }
        System.out.println("Total yearly salary of " + club + " is: " + total);
    }

    public static void appendPlayer(BufferedWriter bw) throws IOException
    {
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            if(!p.exist)
            {
                bw.write(p.name + "," +  p.country + "," + Integer.toString(p.age) + "," + Double.toString(p.height) + "," + p.club + "," + p.position + ",");
                if(p.number != -1)
                    bw.write(Integer.toString(p.number) + ",");
                bw.write(Integer.toString(p.salary));
                bw.newLine();
            }
        }
    }
}
