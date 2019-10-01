package Project1;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static private LinkedBag<Integer> userBag = new LinkedBag<>();
    static private LinkedBag<Integer> randBag = new LinkedBag<>();
    static boolean win;
    public static int size;
    public static int range;

    public static void main(String[] args) {
        System.out.print("=== Welcome to the Guessing Numbers Game! ===");
        //states the rules of the game
        System.out.print("\n" + "Enter an amount of numbers that you want to guess out of a desired range starting from 1");
        System.out.print("\n" + "Keep guessing until you guess all numbers correctly!");
        Scanner input = new Scanner(System.in);
        String userInput = "";

        do {
            play();
            randBag.clear();
            System.out.print("\n" + "Do you want to play again? Y/N ");
            userInput = input.nextLine();

        }
        while (userInput.toLowerCase().equals("y"));

        System.out.print("Thank you for playing!");
        System.out.print("\n" + "=== Game Over! ===");
    }

    private static void play() {
        //Prints out a blank space for organization/aesthetic
        System.out.print("\n" + " ");
        //Initializes the game and asks the user for amount of numbers to guess
        System.out.println("\n" + "Enter the amount of numbers that you want to guess");
        size = sc.nextInt();
        //ask the user for a range of numbers and specifies for positive integers only
        System.out.println("What is the highest number that you would like to guess to? From 1 to _");
        System.out.println("(positive integers only!)");
        range = sc.nextInt();
        fillRandomBag(randBag);
        win = false;

        //begins the loop to guess the numbers
        while (win == false) {
            //resets the user bag
            userBag.clear();
            if (size == 1) {
                System.out.println("\n" + "Enter one number: (numbers may be duplicate) ");
            }
            else {
                System.out.println("\n" + "Enter " + size + " numbers: (numbers may be duplicate) ");
            }
            fillUserBag(userBag);

            //winning conditions to end loop
            if (userBag.equals(randBag)) {
                System.out.print("You win!");
                win = true;

            } else {
                checkIntersection(randBag, userBag);
            }
        }
    }

    static void fillRandomBag(LinkedBag<Integer> randBag){
        //creates a bag of randomly generated numbers within the range
        for (int i = 0; i < size ; i++){
            randBag.add((rand.nextInt(range)+1));
        }
    }

    static void fillUserBag(LinkedBag<Integer> userBag){
        //creates a bag of the user's input
        for(int i = 0; i < size; i++) {
            userBag.add(sc.nextInt());
        }
    }

    static int checkIntersection(LinkedBag<Integer> randBag, LinkedBag<Integer> userBag) {
        LinkedBag<Integer> intersect = userBag.intersection(randBag);
        int inter = intersect.getCurrentSize();
        System.out.print("You guessed " + inter + " out of " + size + " correct. Try again!");
        return inter;
    }
}
