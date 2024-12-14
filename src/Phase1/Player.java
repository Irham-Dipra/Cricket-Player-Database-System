package Phase1;
public class Player {
    String name, country, club, position;
    int age, number = -1, salary;
    double height;
    // number = -1;
    boolean exist;
    Player(String name, String country, int age, double height, String club, String position, int number, int salary, boolean exist)
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
}
