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
                        listOperations.showAllPlayers(listOperations.getClubPlayerList(Server.playerList, clubName));
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
                            listOperations.showDetails(player);
                            socketWrapper.write(player);
                            socketWrapper.flush();
                        }
                        // else if(s.equals("getPlayersByPosition"))
                        // {
                        //     String position = (String) socketWrapper.read();
                        //     socketWrapper.write(listOperations.getSearchByPosition(Server.playerList,position));
                        // }
                        // else if(s.equals("getPlayersBySalary"))
                        // {
                        //     int min = (int) socketWrapper.read();
                        //     int max = (int) socketWrapper.read();
                        //     socketWrapper.write(listOperations.getPlayersBySalary(Server.playerList,min,max));
                        // }
                        // else if(s.equals("getPlayersByClubAndCountry"))
                        // {
                        //     String club = (String) socketWrapper.read();
                        //     String country = (String) socketWrapper.read();
                        //     socketWrapper.write(listOperations.getPlayersByClubCountry(Server.playerList,club,country));
                        // }
                        // else if(s.equals("getClubPlayerList"))
                        // {
                        //     String club = (String) socketWrapper.read();
                        //     socketWrapper.write(listOperations.getClubPlayerList(Server.playerList,club));
                        // }
                        // else if(s.equals("getPlayersWithMaxSalary"))
                        // {
                        //     String club = (String) socketWrapper.read();
                        //     socketWrapper.write(listOperations.getMaxSalaryPlayerList(Server.playerList,club));
                        // }
                        // else if(s.equals("getPlayersWithMaxAge"))
                        // {
                        //     String club = (String) socketWrapper.read();
                        //     socketWrapper.write(listOperations.getMaxAgePlayerList(Server.playerList,club));
                        // }
                        // else if(s.equals("getPlayersWithMaxHeight"))
                        // {
                        //     String club = (String) socketWrapper.read();
                        //     socketWrapper.write(listOperations.getMaxHeightPlayerList(Server.playerList,club));
                        // }
                        else if(s.equals("getFreePlayers"))
                        {
                            ArrayList <Player> freePlayers = listOperations.getFreePlayers(Server.playerList);
                            socketWrapper.write("List");
                            socketWrapper.write(freePlayers);
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



