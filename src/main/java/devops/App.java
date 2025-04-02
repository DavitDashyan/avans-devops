package devops;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sprint sprint = new ReviewSprint();
        boolean running = true;

        System.out.println("Welkom bij het DevOps CLI-systeem!");
        while (running) {
            System.out.println("\nKies een optie:");
            System.out.println("1. Start Sprint");
            System.out.println("2. Finish Sprint");
            System.out.println("3. Cancel Sprint");
            System.out.println("4. Lock Sprint");
            System.out.println("5. Close Sprint");
            System.out.println("6. Genereer Rapport");
            System.out.println("7. Exit");

            System.out.print("Uw keuze: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    sprint.startSprint();
                    break;
                case 2:
                    sprint.finishSprint();
                    break;
                case 3:
                    sprint.cancelSprint();
                    break;
                case 4:
                    sprint.lockSprint();
                    break;
                case 5:
                    sprint.closeSprint();
                    break;
                case 6:
                    System.out.print("Voer rapporttype in (burndownchart, effortpoints, teamsamenstelling): ");
                    String reportType = scanner.nextLine();
                    System.out.print("Voer formaat in (pdf, png): ");
                    String format = scanner.nextLine();
                    try {
                        Report report = sprint.generateReport(reportType, format);
                        report.display();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Fout: " + e.getMessage());
                    }
                    break;
                case 7:
                    running = false;
                    System.out.println("Afsluiten...");
                    break;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
        }

        scanner.close();
    }
}
