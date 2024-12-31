package Controls;
import DTO.*;

import Controllers.*;
import javafx.application.Platform;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReadThread implements Runnable {
    private final Thread thr;
    private final Main main;

    public ReadThread(Main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Client is running");
                Object o = main.getSocketWrapper().read();
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        System.out.println(loginDTO.getUserName());
                        System.out.println(loginDTO.isStatus());
                        String clubName = (String) main.socketWrapper.read();
                        ArrayList<Player> playerList = (ArrayList<Player>) main.getSocketWrapper().read();
                        // the following is necessary to update JavaFX UI components from user created threads
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if (loginDTO.isStatus()) {
                                    try {
                                        main.setClubName(clubName);
                                        System.out.println("club name: " + main.getClubName());
                                        main.showUserHomePage(loginDTO.getUserName(), playerList);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    main.showInvalidLoginAlert();
                                }

                            }
                        });
                    }
                    else if(o instanceof String)
                    {
                        String s = (String) o;
                        if(s.equals("Player"))
                        {
                            Player player = (Player) main.getSocketWrapper().read();
                            if(player == null)
                            {
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            main.showAlert("Invalid Player", "No player found with this name.");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                            else
                            {
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            main.showPlayerDetails(player);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        }
                        else if(s.equals("List"))
                        {
                            System.out.println("client list paise");
                            ArrayList<Player> playerList = (ArrayList<Player>) main.getSocketWrapper().read();
                            String searchType = (String) main.getSocketWrapper().read();
                            if(playerList == null || playerList.isEmpty())
                            {
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            main.showAlert("Error", "No players found");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                            else
                            {
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            main.showClubListDetails(playerList, searchType);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        }
                        else if(s.equals("showTotalSalary"))
                        {
                            String club = (String) main.getSocketWrapper().read();
                            int total = (int) main.getSocketWrapper().read();
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        main.showTotalSalary(club, total);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        else if(s.equals("buyPlayerList"))
                        {
                            ArrayList<Player> playerList = (ArrayList<Player>) main.getSocketWrapper().read();
                            System.out.println("client list paise");
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        main.showBuyPlayerList(playerList);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        else if(s.equals("backToClubList"))
                        {
                            ArrayList<Player> playerList = (ArrayList<Player>) main.getSocketWrapper().read();
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        main.showUserHomePage(main.getClubName(), playerList);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                main.getSocketWrapper().closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



