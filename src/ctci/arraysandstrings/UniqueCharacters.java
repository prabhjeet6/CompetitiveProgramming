package ctci.arraysandstrings;

import java.util.Scanner;

/**
 * Implement an algorithm to determine if a String has all unique Characters.
 * What if you can not use additional data structures.
 **/
public class UniqueCharacters {

	public static void main(String asd[]) {

		Scanner scanner = new Scanner(System.in);
		System.out.println(solution3(scanner));

	}

	/**
	 * Assuming user input is ASCII String 0-127 Time Complexity for this code is
	 * O(n) and space complexity is 0(1)
	 **/
	public static boolean solution3(Scanner scanner) {
		System.out.println("Enter Input String :");
		String input = scanner.nextLine();
		if (input.length() > 128)
			return false;
		boolean charset[] = new boolean[128];
		for (int i = 0; i < input.length(); i++) {
			char value = input.charAt(i);

			// Already found character value
			if (charset[value])
				return false;
			else
				charset[value] = true;

		}
		return true;

	}

	public static void solution2(Scanner scanner) {
		System.out.println("Enter Input String :");
		String input = scanner.nextLine();
		int i = 0, j = 1, flag = 0;
		while (i < input.length() - 1) {
			if (input.charAt(i) == input.charAt(j)) {
				flag = 1;
				System.out.println("Duplicate Character found." + "\n" + "Aborting...");
				break;
			} else {

				if (j < input.length() - 1) {
					j++;
				} else {
					i++;
					j = i + 1;
				}
			}
		}
		if (flag == 0) {
			System.out.println(" All Unique Characters");
		}
		scanner.close();
	}

	/** O(n^2) Time Complexity **/
	public static void solution1(Scanner scanner) {
		System.out.println("Enter Input String :");
		String input = scanner.nextLine();
		int flag = 0;
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					flag = 1;
					System.out.println("Duplicate Character found." + "\n " + "Aborting...");
					break;
				}
			}
		}
		if (flag == 0) {
			System.out.println(" All Unique Characters");
		}
		scanner.close();
	}
}
