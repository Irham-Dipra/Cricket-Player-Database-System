package DataModels;

import java.util.ArrayList;
import Phase1.*;

public class club {
    private String clubName;
    private int netWorth;
    private ArrayList<Player> playerList;
    private String clubLogo;


    public club(String clubName, ArrayList<Player> playerList, int netWorth, String clubLogo) {
        this.clubName = clubName;
        this.playerList = playerList;
        this.netWorth = netWorth;
        this.clubLogo = clubLogo;
    }
    // Getter and Setter for clubName
    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    // Getter and Setter for netWorth
    public int getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(int netWorth) {
        this.netWorth = netWorth;
    }

    // Getter and Setter for playerList
    public ArrayList<String> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<String> playerList) {
        this.playerList = playerList;
    }

    // Getter and Setter for clubLogo
    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo;
    }
}