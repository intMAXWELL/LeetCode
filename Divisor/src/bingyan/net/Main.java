package bingyan.net;

import java.util.Scanner;

/**
 * 
 * @author Demon
 * Greatest Common Divisor
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int r = 1;
		while (r != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		System.out.println(a);
		scanner.close();
	}

}
