import java.util.Scanner;

public class OnlineExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isLoggedIn = false;
        String username = "student";
        String password = "1234";

        while (true) {
            if (!isLoggedIn) {
                System.out.println("\n=== ONLINE EXAMINATION SYSTEM ===");
                System.out.println("1. Login");
                System.out.println("2. Exit");
                System.out.print("Enter choice (choose 1 or 2): ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Username: ");
                    String inputUser = sc.next();
                    System.out.print("Password: ");
                    String inputPass = sc.next();

                    if (inputUser.equals(username) && inputPass.equals(password)) {
                        isLoggedIn = true;
                        System.out.println("Login successful. Welcome!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                }
                else if (choice == 2) {
                    System.out.println("Exiting system...");
                    break;
                }
                else {
                    System.out.println("Invalid choice!");
                }
            }
            else {
                System.out.println("\n=== MAIN MENU ===");
                System.out.println("1. Update Profile");
                System.out.println("2. Start Exam");
                System.out.println("3. Logout");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter a new username: ");
                    username = sc.next();
                    System.out.print("Enter new password: ");
                    password = sc.next();
                    System.out.println("Profile updated successfully!");
                }
                else if (choice == 2) {
                    String[] questions = {
                            "Q1: A cell is a unit of ? \n1. Life\n2. Atmosphere\n3. Body",
                            "Q2: Which is the odd one out? \n1. organelles\n2. atoms\n3. spoon",
                            "Q3: Does a cell contain atoms? \n1. Yes\n2. No"
                    };

                    int[] correctAnswers = {1, 3, 1};
                    int score = 0;

                    int timeLimit = 30; // seconds
                    long startTime = System.currentTimeMillis();

                    System.out.println("\nExam Started! You have " + timeLimit + " seconds.");

                    for (int i = 0; i < questions.length; i++) {
                        long elapsed = (System.currentTimeMillis() - startTime) / 1000;

                        if (elapsed >= timeLimit) {
                            System.out.println("\n⏰ Time's up! Auto-submitting...");
                            break;
                        }

                        System.out.println("\n" + questions[i]);
                        System.out.print("Your answer: ");
                        int answer = sc.nextInt();

                        if (answer == correctAnswers[i]) {
                            score++;
                        }
                    }

                    System.out.println("\nExam Finished!");
                    System.out.println("Your score: " + score + "/" + questions.length);
                }
                else if (choice == 3) {
                    isLoggedIn = false;
                    System.out.println("You have been logged out.");
                }
                else {
                    System.out.println("Invalid choice!");
                }
            }
        }
        sc.close();
    }
}
