import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	private static final String DELIM = " ";

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer;

		buffer = new BufferedReader(new FileReader(file));

		String line;
		while ((line = buffer.readLine()) != null) {
			Map<Integer, String> wordMap = new HashMap<>();
			String[] words = line.trim().split(";")[0].split(DELIM);
			String[] order = line.trim().split(";")[1].split(DELIM);

			// I guess there are cases where the order is not
			// modified, hence the order and words arrays won't be
			// the same size. Need to add ordering for the words that
			// were not jumbled so they can be mapped to that position.
			for (int i = 0; i < words.length; i++) {
				try {
					wordMap.put(Integer.valueOf(order[i]), words[i]);
				} catch (IndexOutOfBoundsException e) {
					// Sometimes the missing sequence number is not at the end
					// of the
					// sequence, could have 1,2,4,5 corresponding to 5 words.
					int missingNumberInSequence = getMissingNumber(order,
							words.length);
					if (missingNumberInSequence > 0) {
						wordMap.put(missingNumberInSequence, words[i]);
					} else {
						wordMap.put(Integer.valueOf(i + 1), words[i]);
					}
				}
			}

			printSortedWords(wordMap);
		}
		buffer.close();

	}

	private static int getMissingNumber(String[] order, int wordCount) {

		// Formula : n * (n + 1) / 2 - s.
		// where n = wordCount and
		// s = sum of the order[] values
		int sum = 0;
		for (String sumParts : order) {
			sum += Integer.valueOf(sumParts);
		}

		return wordCount * (wordCount + 1) / 2 - sum;
	}

	private static void printSortedWords(Map<Integer, String> wordMap) {
		TreeMap<Integer, String> sortedMap = new TreeMap<>();
		sortedMap.putAll(wordMap);
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		// iterate the map to add to a treemap, effectively sorting
		// the words which are the values by their index which is the key
		for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
			sb.append(entry.getValue());
			if (counter < sortedMap.size()) {
				sb.append(DELIM);
			}
			counter++;
		}
		System.out.println(sb);

	}
}
