package travelp;

import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    String name;
    String travelDate;
    double accommodationCost;
    double travelCost;
    String weather;
    
    Destination(String name, String travelDate, double accommodationCost, double travelCost, String weather) {
        this.name = name;
        this.travelDate = travelDate;
        this.accommodationCost = accommodationCost;
        this.travelCost = travelCost;
        this.weather = weather;
    }
}

public class travelplan {
    private static ArrayList<Destination> destinations = new ArrayList<>();
    private static double totalBudget = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome to the Travel Itinerary Planner");
            System.out.println("1. Add a Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Show Total Budget");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    addDestination(scanner);
                    break;
                case 2:
                    viewItinerary();
                    break;
                case 3:
                    showTotalBudget();
                    break;
                case 4:
                    System.out.println("Thank you for using the Travel Itinerary Planner!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    //*********************************** ADD DESTINATION *******************************************
    private static void addDestination(Scanner scanner) {
        System.out.print("Enter destination name: ");
        String name = scanner.nextLine();

        System.out.print("Enter travel date (DD/MM/YYYY): ");
        String travelDate = scanner.nextLine();

        System.out.print("Enter estimated accommodation cost in ₹: ");
        double accommodationCost = scanner.nextDouble();

        System.out.print("Enter estimated travel cost in ₹: ");
        double travelCost = scanner.nextDouble();
        scanner.nextLine();  // consume newline

        String weather = getSimulatedWeather();

        // Add destination
        destinations.add(new Destination(name, travelDate, accommodationCost, travelCost, weather));

        // Update budget
        totalBudget += (accommodationCost + travelCost);

        System.out.println("Destination added successfully!");
    }

    //*********************************** VIEW ITINERARY ********************************************
    private static void viewItinerary() {
        if (destinations.isEmpty()) {
            System.out.println("No destinations added yet.");
            return;
        }

        System.out.println("\nYour Travel Itinerary:");
        for (Destination d : destinations) {
            System.out.println("Destination: " + d.name);
            System.out.println("Travel Date: " + d.travelDate);
            System.out.println("Accommodation Cost: ₹" + d.accommodationCost);
            System.out.println("Travel Cost: ₹" + d.travelCost);
            System.out.println("Simulated Weather: " + d.weather);
            System.out.println("--------------------------");
        }
    }

    //*********************************** SHOW TOTAL BUDGET *****************************************
    private static void showTotalBudget() {
        System.out.println("Total estimated budget for the trip: ₹" + totalBudget);
    }

    //*********************************** SIMULATE WEATHER ******************************************
    private static String getSimulatedWeather() {
        // Just a random weather generator for simplicity
        String[] weatherOptions = {"Sunny", "Rainy", "Cloudy", "Snowy"};
        int randomIndex = (int) (Math.random() * weatherOptions.length);
        return weatherOptions[randomIndex];
    }
}

