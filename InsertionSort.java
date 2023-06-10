import java.util.Comparator;

/**
 * @author Aime Byiringiro
 *
 * @param <K>
 * 
 *            This class sorts words by insertion sort.
 */
public class InsertionSort<K> {

	K[] arrayWords; 
	Comparator<K> myComparator = (s1, s2) -> ((String) s1).compareToIgnoreCase((String) s2);
	int counter = 0; // the counter of comparions 
	String algorithmName = "Insertion Sort  |  ";
	String numComaparison; // number of comparisons in string
	String time; // the runtime in string form
	long runtime; // the run time
	String result_Table; // final resuts

	/**
	 * Class constructor
	 * 
	 * @param arrayWords
	 */
	InsertionSort(K[] arrayWords) {

		this.arrayWords = arrayWords;

	}

	/**
	 * This is the calling method of the class.
	 */
	void sortList() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		insertionSort(arrayWords);
		long endTime = System.currentTimeMillis();
		runtime = endTime - startTime;
		printing();

	}

	/**
	 * This methods sorts the parameter array by insertion
	 * 
	 * @param arr
	 */
	void insertionSort(K arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			K key = arr[i];
			int j = i - 1;
			while (j >= 0) {
				if (((String) arr[j]).compareTo((String) key) > 0) {
					counter++;
					arr[j + 1] = arr[j];
					j = j - 1;
				} else {
					counter++;
					break;
				}
			}
			arr[j + 1] = key;
		}
	}

	/**
	 * This method method is not used. It's only for checking purpose.
	 * 
	 * @param S
	 */
	private void print(K[] S) {
		for (K i : S) {
			System.out.print(i + " ");
		}

	}

	/**
	 * This method prints the resuts ( number of counts and run time) of the sorting
	 * algorithm NOTE: This method makes some assumption on how long (horizontal
	 * wise) the results can be in regards to the testing file htat was given. If
	 * the input is like 10 billion words, this methods might need to be adjsted.
	 */
	private void printing() {
		numComaparison = String.valueOf(counter);
		time = String.valueOf(runtime);
		if (numComaparison.length() < 16) {
			int j = 16 - numComaparison.length();
			for (int i = 0; i < j; i++) {
				numComaparison = numComaparison + " ";
			}
			numComaparison = numComaparison + "|  ";
		}
		if (time.length() < 20) {
			int j = 20 - time.length();
			for (int i = 0; i < j; i++) {
				time = time + " ";
			}
			time = time + "|";
		}
		result_Table = algorithmName + numComaparison + time;
		System.out.println(result_Table);
	}

}
