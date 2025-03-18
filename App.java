import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Welcome to Number Guessing Game:");

            while (true) {

                try {
                    System.out.println("\n1. Start Game");
                    System.out.println("2. Exit Game");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1 -> {
                            int trials = 0;
                            int randomNumber = generateRandomNumber();
                            // System.out.println("Random number: " + randomNumber);

                            while (trials < 3) {
                                try {
                                    System.out.print("Enter your guess: ");
                                    int guess = scanner.nextInt();
                                    System.out.println("You have entered: " + guess);

                                    if (guess == randomNumber) {
                                        System.out.println("Congratulations! You have guessed the number correctly.\n");
                                        break;
                                    } else if (guess < randomNumber) {
                                        System.out.println("Your guess is too low.\n");
                                    } else {
                                        System.out.println("Your guess is too high.\n");
                                    }

                                    trials++;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input! Please enter a valid number.\n");
                                    scanner.nextLine();
                                } catch (Exception e) {
                                    System.out.println("An error occurred: " + e.getMessage() + "\n");
                                    scanner.nextLine();
                                }

                                if (trials == 3) {
                                    System.out.println("You have exhausted all your trials. The correct number was: "
                                            + randomNumber + "\n");
                                }
                            }
                        }

                        case 2 -> {
                            System.out.println("Exiting the game...\n");
                            System.exit(0);
                        }
                        default -> {
                            System.out.println("Invalid choice! Please enter a valid choice.\n");
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number (1 or 2).\n");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage() + "\n");
                    scanner.nextLine();
                }

            }
        }

    }

    public static int generateRandomNumber() {
        return new Random().nextInt(100) + 1;
    }
}