import java.util.Scanner;
public class InputReader {
	private static final Scanner reader = new Scanner(System.in);

	public String readLine(String question) {
		System.out.print(question + "> ");
		System.out.flush();
		return reader.nextLine().trim();
	}

	public String getText(String question) {
		while (true) {
			String text = readLine(question);
			if (!text.isEmpty()) return text;
			System.out.println("Please type something.");
		}
	}

	public char getCharacter(String question) {
		return getText(question).charAt(0);
	}

	public int getIntegerNumber(String question) {
		while (true) {
			try { return Integer.parseInt(readLine(question)); }
			catch (NumberFormatException e)
			{ System.out.println("Please type a whole number."); }
		}
	}

	public int getIntegerNumber(String question, int min, int max) {
		while (true) {
			int number = getIntegerNumber(question);
			if (number >= min && number <= max) return number;
			System.out.println("Please type a number from " + min + " to " + max + ".");
		}
	}

	public double getDecimalNumber(String question) {
		while (true) {
			try {
				double number = Double.parseDouble(readLine(question).replace(',', '.'));
				if (Double.isFinite(number)) return number;
			} catch (NumberFormatException e) { }
			System.out.println("Please type a number.");
		}
	}

	public double getDecimalNumber(String question, double min, double max) {
		while (true) {
			double number = getDecimalNumber(question);
			if (number >= min && number <= max) return number;
			System.out.println("Please type a number from " + min + " to " + max + ".");
		}
	}
}