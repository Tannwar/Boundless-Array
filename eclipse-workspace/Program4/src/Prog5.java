/*
 * Tanner Ward
 * CSC 205
 * Description: This program is going to help and assist a user in playing vs a computer in a tactical game of warship!
 */

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Prog5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome!");
		boolean done = false;
		while (!done) {
			topMenu();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				test(scan);
				break;
			case 2:
				playGame(scan);
				break;
			case 3:
				done = true;
				break;
			default:
				break;
			}
		}

		System.out.println("Goodbye!");
	}

	private static void playGame(Scanner scan) {
		
		Queue q1 = new Queue();
		Queue q2 = new Queue();
		Queue q3 = new Queue();
		WarshipArray wa = new WarshipArray();
		Warship[] cards = wa.getCards();
		Random rand = new Random();
		// shuffle cards
		for (int i = cards.length - 1; i > 0; i--) {
			Warship temp = cards[i];
			int randomIndex = rand.nextInt(i + 1);
			cards[i] = cards[randomIndex];
			cards[randomIndex] = temp;
		}
		int numPlayers = 2;
		int cardsPerPlayer = cards.length / numPlayers;
		// deal equal number of cards to each player
		for (int i = 0; i < cardsPerPlayer; i++) {
			q1.insert(cards[2 * i]);
			q2.insert(cards[2 * i + 1]);
		}
		boolean humanTurn = true;
		boolean done = false;
		System.out.println("You have " + q1.size() + " cards, and the computer has " + q2.size() + " cards.");
		while (!done) {
			Warship ship1 = (Warship) q1.delete();
			Warship ship2 = (Warship) q2.delete();
			q3.insert(ship1);
			q3.insert(ship2);
			int choice = 0;
			int delta = 0;
			
			if (humanTurn) {
				//
				System.out.println("Your card: " + ship1);
				displayWarMenu();
				choice = scan.nextInt();
				System.out.println("Computer Card: " + ship2);
				
			} else {
				// computer's turn
				System.out.println("Your card: " + ship1);
				System.out.println("Computer Card: " + ship2);
				choice = rand.nextInt(6) + 1;
			}
			
			switch (choice) {
			case 1:
				delta = ship1.get_length() - ship2.get_length();
				break;
			case 2:
				delta = ship1.get_maneuverability() - ship2.get_maneuverability();
				break;
			case 3:
				delta = ship1.get_displacement() - ship2.get_displacement();
				break;
			case 4:
				delta = ship1.get_crew() - ship2.get_crew();
				break;
			case 5:
				delta = ship1.get_speed() - ship2.get_speed();
				break;
			case 6:
				delta = ship1.get_combatRating() - ship2.get_combatRating();
			default:
				break;
			}

			if (delta > 0) {
				// human won
				while (!q3.isEmpty()) {
					q1.insert(q3.delete());
				}
				humanTurn = true;
			} else if (delta < 0) {
				// computer won
				humanTurn = false;
				while (!q3.isEmpty()) {
					q2.insert(q3.delete());
				}
			} else {
				// tie, leave cards in center and play another round
			}
			
			System.out.println("You have " + q1.size() + " cards, and the computer has " + q2.size() + " cards.");
			done = q1.isEmpty() || q2.isEmpty();
		}

		if (q1.isEmpty()) {
			System.out.println("Computer Wins!");
		} else {
			System.out.println("Human Wins!");
		}
	}
public static void test(Scanner scan) {
		

		/*
		 * Write a simple test program to exercise all these operations on two instances of Queues. Construct an empty 
			instance of each of these, then allow the user to repeatedly perform selected operations on either of the two, in 
			any order, until they choose to quit. For each action, let the user select which Queue to manipulate, then allow 
			them to choose from a menu of the available operations. For input to a Queue, ask the user to enter a name 
			(with no spaces). Display results of each operation (or a simple message acknowledging completion if there is 
			no result).
		 */
		Queue q1 = new Queue();
		Queue q2 = new Queue();
		Queue q;
		while (true) {
			displayMenu();
			int choice = scan.nextInt();
			if (choice == 6) {
				break;
			}
		
			System.out.print("To which queue would you like to perform this operation? (1 or 2) ");
			int num = scan.nextInt();
			if (num == 1) {
				q = q1;
			} else {
				q = q2;
			}
			
			switch (choice) {
			case 1:
				System.out.println(q.delete());
				break;
			case 2:
				System.out.print("What name would you like to add? ");
				q.insert(scan.next());
				break;
			case 3:
				System.out.println(q.isEmpty());
				break;
			case 4:
				System.out.println(q);
				break;
			case 5:
				System.out.println(q.toStore());
				break;
			default:
				break;
			}
		}
	}

private static void displayMenu() {
	System.out.println("Options: \n"
			+ "1) delete - return (and delete) the Object extracted from the front of the queue.\r\n" + 
			"2) insert - insert a given Object on the back of the queue.\r\n" + 
			"3) isEmpty - return true if the queue is empty, and false otherwise.\r\n" + 
			"4) toString - return a String summarizing the entire contents of the queue (from front to back).\r\n" + 
			"5) toStore - return a String summarizing the entire contents of queue storage (from array index 0 to length-1). \n" + 
			"6) quit");
	System.out.print("\nWhat would you like to do? ");
}

	private static void displayWarMenu() {
		System.out.println("Categories: \n" + "1) Length\n" + "2) Maneuverability\r\n" + "3) Displacement\r\n"
				+ "4) Crew\r\n" + "5) Speed\n" + "6) CombatRating");
		System.out.print("\nWhat category do you want to use? ");
	}

	public static void topMenu() {
		System.out.println("\n" + "(1) Test the Tools\r\n" + "(2) Play a Card Game\r\n" + "(3) Quit");
		System.out.print("\nWhat would you like to do? ");
	}
}
