import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
 * The program implements the Diffie-Hellman protocol. The user is side A, side B is the
 * computer. Enter your choice of p and g (p is a large positive prime number, g is a small
 * positive number). Then enter the secret key a. The secret key b on side B is randomly
 * generated. After that, the program will calculate your symmetric secret key C.
 */

public class Main {

	public static void main(String[] args) {
		
		System.out.println("|__labwork_001_Diffie-Hellman_protocol__|");
		Scanner scanner = new Scanner (System.in);
		int warn = 0;
		int p = 0, g = 0;
		try {
			System.out.println("|Input a module p                       |");
			System.out.printf("|>> ");
			p = scanner.nextInt();
			System.out.println("|Input a base g                         |");
			System.out.printf("|>> ");
			g = scanner.nextInt();
		}
		catch (InputMismatchException x) {
			System.out.println("|You can input only integer             |");
			warn = 1;
			scanner.close();
		}
		finally {
			System.out.println("|Input a secret key a                   |");
		}
		while (warn!=1) {
			System.out.printf("|>> ");
			int secretKeyA = scanner.nextInt();
			Random random = new Random ();
			int secretKeyB = 3 + random.nextInt(6)+1;
			int publicKeyA = (int) Math.pow(g, secretKeyA) % p;
			System.out.println("|Your public key A is equal to " + publicKeyA);
			int publicKeyB = (int) Math.pow(g, secretKeyB) % p;
			System.out.println("|You have received the public key B equal " + publicKeyB);
			int symmetricKeyS1 = (int) Math.pow(publicKeyB, secretKeyA) % p;
			int symmetricKeyS2 = (int) Math.pow(publicKeyA, secretKeyB) % p;
			if (symmetricKeyS1 == symmetricKeyS2) {
				System.out.println("|Symmetric key S is equal to " + symmetricKeyS1);
			}
			else System.out.println("|Symmetric key S was not found          |");
			warn = 1;
		}
		System.out.println("|______________________Made_by_MarconiNN|");
	}

}
