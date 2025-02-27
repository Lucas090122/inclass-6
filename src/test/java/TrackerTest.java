import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TrackerTest {
    private Tracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new Tracker();
    }

    @Test
    void testAddSession() {
        tracker.addSession("2024-02-27", 1.5);
        assertEquals(1.5, tracker.getTotalDuration(), "Total duration should be 1.5 hours after one session");
    }

    @Test
    void testTotalDuration() {
        tracker.addSession("2024-02-27", 2.0);
        tracker.addSession("2024-02-28", 1.5);
        assertEquals(3.5, tracker.getTotalDuration(), "Total duration should be the sum of all session durations");
    }

    @Test
    void testGraduationBySessions() {
        for (int i = 0; i < 100; i++) {
            tracker.addSession("2024-02-27", 1.0);
        }
        assertTrue(tracker.isEligibleForGraduation(), "Should be eligible for graduation after 100 sessions");
    }

    @Test
    void testGraduationByTime() {
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        String date = sixMonthsAgo.format(DateTimeFormatter.ISO_DATE);
        tracker.addSession(date, 1.0);

        assertTrue(tracker.isEligibleForGraduation(), "Should be eligible for graduation after 6 months");
    }

    @Test
    void testNotEligibleForGraduation() {
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(5);
        String date = sixMonthsAgo.format(DateTimeFormatter.ISO_DATE);
        tracker.addSession(date, 1.0);

        assertFalse(tracker.isEligibleForGraduation(), "Should not be eligible for graduation with less than 100 sessions and 6 months");
    }
}
