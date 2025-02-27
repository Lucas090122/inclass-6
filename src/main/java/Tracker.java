import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Tracker {
    private double totalDuration;
    private ArrayList<Session> sessions;

    public Tracker() {
        totalDuration = 0;
        sessions = new ArrayList<>();
    }

    public void addSession(String date, double duration) {
        Session session = new Session(date, duration);
        sessions.add(session);
        totalDuration += duration;
    }

    public double getTotalDuration() {
        return totalDuration;
    }

    public boolean isEligibleForGraduation() {
        if (sessions.size() >= 100) {
            return true;
        }

        LocalDate firstSessionDate = LocalDate.parse(sessions.getFirst().getDate());
        LocalDate currentDate = LocalDate.now();
        long monthsElapsed = ChronoUnit.MONTHS.between(firstSessionDate, currentDate);

        return monthsElapsed >= 6;
    }
}

class Session {
    private String date;
    private double duration;

    public Session(String date, double duration) {
        this.date = date;
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }
}
