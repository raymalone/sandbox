import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
	public static final String FIZZ = "F";
	public static final String BUZZ = "B";
	public static final String FIZZBUZZ = "FB";
	public static final String DELIM = " ";

	public static void main(String[] args) throws IOException {

		List<String> lineList = Files.readAllLines(Paths.get(args[0]),
				Charset.defaultCharset());

		for (String line : lineList) {
			int x = Integer.valueOf(line.split(DELIM)[0]);
			int y = Integer.valueOf(line.split(DELIM)[1]);
			int n = Integer.valueOf(line.split(DELIM)[2]);
			StringBuilder sb = new StringBuilder();

			for (int i = 1; n >= i; i++) {
				if (i % x == 0 && i % y == 0) {
					sb.append(FIZZBUZZ).append(DELIM);
				} else if (i % x == 0) {
					sb.append(FIZZ).append(DELIM);

				} else if (i % y == 0) {
					sb.append(BUZZ).append(DELIM);
				} else {
					sb.append(i).append(DELIM);
				}
			}
			System.out.println(sb.toString().trim());
		}
	}
}
