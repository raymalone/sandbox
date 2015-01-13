import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	private static final String DELIM = " ";

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer;
		ArrayList<ArrayList<Integer>> inputValues = new ArrayList<ArrayList<Integer>>();

		buffer = new BufferedReader(new FileReader(file));

		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			ArrayList<Integer> lineList = new ArrayList<Integer>();
			for (String number : line.split(DELIM)) {
				lineList.add(Integer.valueOf(number));
			}
			inputValues.add(lineList);
		}
		buffer.close();

		ArrayList<Integer> weights = (ArrayList<Integer>) inputValues.get(
				inputValues.size() - 1).clone();

		for (int row = inputValues.size() - 2; row >= 0; row--) {
			ArrayList<Integer> nextRow = inputValues.get(row);
			for (int column = 0; column < nextRow.size(); column++) {
				int heaviest = Math.max(weights.get(column), weights.get(column + 1));
				weights.set(column, nextRow.get(column) + heaviest);
			}
			weights.remove(weights.size() - 1);
		}
		System.out.println(weights.get(0));
	}

}
