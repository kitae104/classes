package inhatc.cse.java.final2026.aban;

public class Student {
    String name;
    String club;
    int score;
    int volunteer;

    public Student(String name, String club, int score, int volunteer) {
        this.name = name;
        this.club = club;
        this.score = score;
        this.volunteer = volunteer;
    }

    public String getName()      { return name; }
    public String getClub()      { return club; }
    public int    getScore()     { return score; }
    public int    getVolunteer() { return volunteer; }
}