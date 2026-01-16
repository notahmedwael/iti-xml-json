public class Footballer {
    public String name;
    public String club;
    public int goals;

    // Default constructor is required for JSON-B
    public Footballer() {}

    public Footballer(String name, String club, int goals) {
        this.name = name;
        this.club = club;
        this.goals = goals;
    }
}