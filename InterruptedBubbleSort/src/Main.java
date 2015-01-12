import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static final String DELIM = " ";

	public static void main(String[] args) throws IOException {

		for (String line : Files.readAllLines(Paths.get(args[0]),
				Charset.defaultCharset())) {
			String[] lineArray = line.split("\\|");
			long iterations = Long.valueOf(lineArray[1].trim());
			lineArray = lineArray[0].split(DELIM);
			int[] intArray = new int[lineArray.length];
			for (int i = 0; i < lineArray.length; i++) {
				intArray[i] = Integer.parseInt(lineArray[i]);
			}
			bubbleSort(intArray, iterations);
			StringBuilder sb = new StringBuilder();
			for (int n : intArray) {
				sb.append(n).append(DELIM);
			}
			System.out.println(sb.toString().trim());
		}
	}

	public static void bubbleSort(int[] numArray, long iterations) {

		int temp = 0;

		for (int i = 0; i < iterations && i < numArray.length; i++) {

			for (int j = 1; j < (numArray.length - i); j++) {

				if (numArray[j - 1] > numArray[j]) {
					temp = numArray[j - 1];
					numArray[j - 1] = numArray[j];
					numArray[j] = temp;
				}
			}
		}
	}
}
