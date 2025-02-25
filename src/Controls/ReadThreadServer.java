package Controls;

import DTO.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;

public class ReadThreadServer implements Runnable {
    private final Thread thr;
    private final SocketWrapper socketWrapper;
    public HashMap<String, String> userMap;


    public ReadThreadServer(HashMap<String, String> map, SocketWrapper socketWrapper) {
        this.userMap = map;
        this.socketWrapper = socketWrapper;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                System.out.println("server is running");
                Object o = socketWrapper.read();
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        System.out.println("login er req ashche from club " + loginDTO.getUserName());
                        String password = userMap.get(loginDTO.getUserName());
                        loginDTO.setStatus(loginDTO.getPassword().equals(password));
                        socketWrapper.write(loginDTO);
                        String clubName = Server.initialMap.get(loginDTO.getUserName());
                        socketWrapper.write(clubName);
                        socketWrapper.write(listOperations.getClubPlayerList(Server.playerList, clubName));
                        socketWrapper.write(Server.imageMap.get(clubName));
                        System.out.println("image path: " + Server.imageMap.get(clubName));
                        socketWrapper.flush();
                    }
                    else if(o instanceof String)
                    {
                        String s = (String) o;
                        if(s.equals("getPlayerByName"))
                        {
                            System.out.println("request asche");
                            String name = (String) socketWrapper.read();
                            socketWrapper.write("Player");
                            Player player = listOperations.getPlayerByName(Server.playerList,name);
                            // listOperations.showDetails(player);
                            socketWrapper.write(player);
                            socketWrapper.write(Server.imageMap.get(player.getClub()));
                            socketWrapper.write("searchName");
                            socketWrapper.flush();
                        }
                        else if(s.equals("getPlayersByClubAndCountry"))
                        {
                            System.out.println("server e ashche getPlayersByClubAndCountry");
                            String club = (String) socketWrapper.read();
                            String country = (String) socketWrapper.read();
                            socketWrapper.write("List");
                            socketWrapper.write(listOperations.getPlayersByClubCountry(Server.playerList,club,country));
                            socketWrapper.write("searchClubCountry");
                            socketWrapper.flush();
                        }
                        else if(s.equals("getPlayersByPosition"))
                        {
                            String position = (String) socketWrapper.read();
                            socketWrapper.write("List");
                            socketWrapper.write(listOperations.getSearchByPosition(Server.playerList,position));
                            socketWrapper.write("searchPosition");
                            socketWrapper.flush();
                        }
                        else if(s.equals("getPlayersBySalary"))
                        {
                            int min = (int) socketWrapper.read();
                            int max = (int) socketWrapper.read();
                            socketWrapper.write("List");
                            socketWrapper.write(listOperations.getPlayersBySalary(Server.playerList,min,max));
                            socketWrapper.write("searchSalary");
                            socketWrapper.flush();
                        }
                        else if(s.equals("countryPlayerCount"))
                        {
                            socketWrapper.write("showCountryPlayerCount");
                            socketWrapper.write(listOperations.getCountryWisePlayerCountMap(Server.playerList));
                            socketWrapper.flush();
                        }
                        else if(s.equals("getPlayersWithMaxSalary"))
                        {
                            String club = (String) socketWrapper.read();
                            socketWrapper.write("List");
                            socketWrapper.write(listOperations.getMaxSalaryPlayerList(Server.playerList,club));
                            socketWrapper.write("searchMaxSalary");
                            socketWrapper.flush();
                        }
                        else if(s.equals("getPlayersWithMaxAge"))
                        {
                            String club = (String) socketWrapper.read();
                            socketWrapper.write("List");
                            socketWrapper.write(listOperations.getMaxAgePlayerList(Server.playerList,club));
                            socketWrapper.write("searchMaxAge");
                            socketWrapper.flush();
                        }
                        else if(s.equals("getPlayersWithMaxHeight"))
                        {
                            String club = (String) socketWrapper.read();
                            socketWrapper.write("List");
                            socketWrapper.write(listOperations.getMaxHeightPlayerList(Server.playerList,club));
                            socketWrapper.write("searchMaxHeight");
                            socketWrapper.flush();
                        }
                        else if(s.equals("getTotalSalary"))
                        {
                            String club = (String) socketWrapper.read();
                            socketWrapper.write("showTotalSalary");
                            socketWrapper.write(club);
                            socketWrapper.write(listOperations.getTotalSalary(Server.playerList,club));
                            socketWrapper.flush();
                        }
                        else if(s.equals("getMyPlayers"))
                        {
                            String clubName = (String) socketWrapper.read();
                            ArrayList <Player> myPlayers = listOperations.getClubPlayerList(Server.playerList, clubName);
                            socketWrapper.write("myClubPlayers");
                            socketWrapper.write(myPlayers);
                            socketWrapper.flush();
                        }
                        else if(s.equals("buyPlayers"))
                        {
                            String clubName = (String) socketWrapper.read();
                            String imagePath = (String) socketWrapper.read();
                            socketWrapper.write("buyPlayerList");
                            System.out.println("buy korte ashche");
                            socketWrapper.write(listOperations.getFreePlayers(Server.playerList, clubName));
                            socketWrapper.write(imagePath);
                            socketWrapper.flush();
                        }
                        else if(s.equals("sellPlayer"))
                        {
                            System.out.println("sell korte ashche");
                            Player player = (Player) socketWrapper.read();
                            String clubName = (String) socketWrapper.read();
                            listOperations.sellPlayer(Server.playerList, player, clubName);
                            System.out.println("Player sold: " + player.name);
                            listOperations.showDetails(player);
                            listOperations.showDetails(listOperations.getPlayerByName(Server.playerList, player.getName()));
                        }
                        else if(s.equals("playerBought"))
                        {
                            Player player = (Player) socketWrapper.read();
                            String clubName = (String) socketWrapper.read();
                            listOperations.buyPlayer(Server.playerList, player, clubName);
                        }
                        else if(s.equals("backToClubList"))
                        {
                            String clubName = (String) socketWrapper.read();
                            System.out.println("Server e ashche backToClubList" + clubName);
                            socketWrapper.write("backToClubList");
                            socketWrapper.write(listOperations.getClubPlayerList(Server.playerList, clubName));
                            socketWrapper.write(Server.imageMap.get(clubName));
                            System.out.println("the new list is: ");
                            socketWrapper.flush();
                        }
                        else if(s.equals("addPlayer"))
                        {
                            System.out.println("add clicked");
                            Player player = (Player) socketWrapper.read();
                            socketWrapper.write("playerAdded");
                            listOperations.addPlayer(Server.playerList, player);
                        }
                        else if(s.equals("exit"))
                        {
                            fileOperations.saveData(Server.playerList);
                            socketWrapper.write("exit");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                socketWrapper.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



