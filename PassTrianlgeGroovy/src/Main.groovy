
class Main {
	public static void main(String[] args) {
		def triangle = getClass().getResource('/input.txt').text.split('\\n').collect { 
					line ->
					line.split().collect { it as int }
				}

		println "${findLargestWeightBottomUp(triangle)}"
	}

	def static findLargestWeightBottomUp(List triangle) {
		def weights = triangle[triangle.size() - 1].clone()
		for (int row = triangle.size() - 2; row >= 0; row--) {
			def nextRow = triangle[row]
			for (int col = 0; col < nextRow.size(); col++) {
				def largest = Math.max(weights[col], weights[col + 1])
				weights[col] = nextRow[col] + largest
			}
			weights.remove(weights.size() - 1)
		}
		return weights[0]
	}
}

