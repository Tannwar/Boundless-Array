import java.util.Scanner;

public class Program4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome!");
		boolean done = false;
		while(!done) {
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
		System.out.println("War");
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
	
	public static void topMenu() {
		System.out.println("\n"
				+ "(1) Test the Tools\r\n" + 
				"(2) Play a Card Game\r\n" + 
				"(3) Quit");
		System.out.print("\nWhat would you like to do? ");
	}
}
