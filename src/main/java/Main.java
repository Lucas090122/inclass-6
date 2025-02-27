import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Aikido Practice Tracker =====");
            System.out.println("1. Add Practice Session");
            System.out.println("2. View Total Practice Time");
            System.out.println("3. Check Graduation Eligibility");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option (1-4)!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the date (yyyy-MM-dd): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter the duration (in hours): ");
                    try {
                        double duration = Double.parseDouble(scanner.nextLine());
                        tracker.addSession(date, duration);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number for duration!");
                    }
                    break;
                case 2:
                    System.out.println("Your total practice time are "
                            + tracker.getTotalDuration() + " hours");
                    break;
                case 3:
                    if (tracker.isEligibleForGraduation()) {
                        System.out.println("Congratulations! You are eligible for graduation");
                    } else {
                        System.out.println("Keep practicing! You are not eligible for graduation yet.");
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Please enter a valid option (1-4)!");
            }
        }
    }
}
