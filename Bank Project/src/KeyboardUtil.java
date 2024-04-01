import java.util.Scanner;

public class KeyboardUtil {
	public static String getString(String message) {
		System.out.println(message);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static int getInt(String message) {
		System.out.println(message);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static double getDouble(String message) {
		System.out.println(message);
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}
}
