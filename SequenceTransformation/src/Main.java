import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {

	private static final String DELIM = " ";
	private static final char ZERO = '0';
	private static final char ONE = '1';
	private static final Pattern ZERO_TRANSLATE_PATTERN = Pattern.compile("A+");
	private static final Pattern ONE_TRANSLATE_PATTERN = Pattern
			.compile("A+|B+");

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer;
		buffer = new BufferedReader(new FileReader(file));
		String line = null;
		// Read each input line and process
		while ((line = buffer.readLine()) != null) {
			printTransformationPossible(line);
		}

		buffer.close();

	}

	private static void printTransformationPossible(String line) {
		// Print true/false isTransormationPossible
		System.out.println(isTransformationPossible(line) ? "Yes" : "No");

	}

	private static boolean isTransformationPossible(String line) {
		boolean isPossible = false;

		String[] pair = line.split(DELIM);
		ArrayList<String> translationList = new ArrayList<>();

		// iterate text to be translated char by char
		for (int i = 0; i < pair[1].length(); i++) {

			// always add the first char to the list
			if (i == 0) {
				translationList.add(String.valueOf(pair[1].charAt(i)));
				// if the char is different than it's predecessor add it to a
				// new
				// element in the list
			} else if (i > 1 && pair[1].charAt(i) != pair[1].charAt(i - 1)) {
				translationList.add(String.valueOf(pair[1].charAt(i)));

				// if not, append it to the string already in the list
			} else {

				translationList.set(translationList.size() - 1,
						translationList.get(translationList.size() - 1)
								+ String.valueOf(pair[1].charAt(i)));
			}
		}

		// iterate text in binary representation
		for (char binChar : pair[0].toCharArray()) {
			search: for (String translationElement : translationList) {
				if (binChar == ZERO) {
					isPossible = ZERO_TRANSLATE_PATTERN.matcher(
							translationElement).matches();
					break search;
				} else if (binChar == ONE) {
					isPossible = ONE_TRANSLATE_PATTERN.matcher(
							translationElement).matches();
					break search;
				}
			}

		}

		return isPossible;
	}
}
