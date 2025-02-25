package Controls;

import java.io.Serializable;

public class Player implements Serializable  {
    String name, country, club, position;
    int age, number = -1, salary;
    double height;
    boolean exist;
    String previous = null;


    public Player(String name, String country, int age, double height, String club, String position, int number, int salary, boolean exist)
    {
        this.name = name;
        this.country = country;
        this.age = age;
        this.height = height;
        this.club = club;
        this.position = position;
        this.number = number;
        this.salary = salary;
        this.exist = exist;
    }

    public Player(String name)
    {
        this.name = name;
        this.country = "";
        this.age = -1;
        this.height = -1;
        this.club = "";
        this.position = "";
        this.number = -1;
        this.salary = -1;
        this.exist = false;
    }

    public String getName()
    {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getClub() {
        return club;
    }
    public void setClub(String club) {
        this.club = club;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getJersey() {
        return number;
    }
    public void setJersey(int number) {
        this.number = number;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public boolean isExist() {
        return exist;
    }
    public void setExist(boolean exist) {
        this.exist = exist;
    }
    public String getPrevious() {
        return previous;
    }
    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
