package Controls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class listOperations {


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

    public static Player getPlayerByName(ArrayList<Player> playerList, String name)
    {
        System.out.println("Searching for player with name: " + name);
        for(int i = 0; i < playerList.size(); i++)
        {
            if(playerList.get(i).getName().equals(name))
            {
                return playerList.get(i);
            }
        }
        return null;
    }

    public static ArrayList <Player> getPlayersByClubCountry(ArrayList<Player> playerList, String club, String country)
    {
        ArrayList<Player> clubPlayers = new ArrayList<>();
        for(int i = 0; i < playerList.size(); i++)
        {
            if((playerList.get(i).getClub().equals(club) || club.equals("Any")) && playerList.get(i).getCountry().equals(country))
            {
                clubPlayers.add(playerList.get(i));
            }
        }
        return clubPlayers;
    }

    public static ArrayList<Player> getClubPlayerList(ArrayList<Player> playerList, String club)
    {
        ArrayList<Player> clubPlayers = new ArrayList<>();
        for(int i = 0; i < playerList.size(); i++)
        {
            if(playerList.get(i).getClub().equals(club))
            {
                clubPlayers.add(playerList.get(i));
            }
        }
        return clubPlayers;
    }

    public static ArrayList<Player> getSearchByPosition(ArrayList<Player> playerList,String position)
    {
        ArrayList <Player> temp = new ArrayList<>();
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

    static public ArrayList<Player> getPlayersBySalary(ArrayList<Player> playerList, int min, int max)
    {
        ArrayList <Player> temp = new ArrayList<>();
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

    public static HashMap<String, Integer> getCountryWisePlayerCountMap(ArrayList<Player> playerList)
    {
        HashMap <String, Integer> map = new HashMap<>();
        for(int i = 0;i < playerList.size();i++)
        {
            Player p = playerList.get(i);
            map.put(p.country, map.getOrDefault(p.country, 0) + 1);
        }
        return map;
    }

    public static ArrayList<Player> getMaxSalaryPlayerList(ArrayList<Player> playerList, String club)
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
        ArrayList<Player> temp = new ArrayList<>();
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

    public static ArrayList<Player> getMaxAgePlayerList(ArrayList <Player> playerList, String club)
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
        ArrayList <Player> temp = new ArrayList<>();
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

    public static ArrayList<Player> getMaxHeightPlayerList(ArrayList<Player> playerList, String club)
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
        ArrayList<Player> temp = new ArrayList<>();
        if(max < 0)
        {
            return temp;
        }
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

    public static void sellPlayer(ArrayList<Player> playerList, Player player)
    {
        for(int i = 0;i < playerList.size();i++)
        {
            if(playerList.get(i).getName().equals(player.getName()))
            {
                playerList.get(i).setClub("Free Agent");
                break;
            }
        }
    }

    public static ArrayList<Player> getFreePlayers(ArrayList<Player> playerList)
    {
        ArrayList<Player> freePlayers = new ArrayList<>();
        for(Player player: playerList)
        {
            if(player.club.equals("Free Agent"))
            {
                freePlayers.add(player);
            }
        }
        return freePlayers;
    }

    public static void buyPlayer(ArrayList<Player> playerList, Player player, String club)
    {
        for(int i = 0;i < playerList.size();i++)
        {
            if(playerList.get(i).getName().equals(player.getName()))
            {
                playerList.get(i).setClub(club);
                break;
            }
        }
    }

    public static int getTotalSalary(ArrayList<Player> playerList, String club)
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

    // public static int getClubNetWorth(ArrayList<Player> playerList, String clubName)
    // {
    //     int netWorth = 0;
    //     for(Player player: playerList)
    //     {
    //         if(player.club.equals(clubName))
    //         {
    //             netWorth += player.salary;
    //         }
    //     }
    //     return netWorth;
    // }
}
