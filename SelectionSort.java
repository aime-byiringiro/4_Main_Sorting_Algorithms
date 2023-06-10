
/**
 * 
 * @author Aime Byiringiro
 *
 * @param <K>
 * 
 * This class sorts the array of words by selection sort
 */
public class SelectionSort<K extends Comparable<K>> {
	K[] arrayWords;
	int counter = 0;
	String algorithmName = "Selection Sort  |  ";
	String numComaparison;
	String time;
	long runtime;
	String result_Table;
/**
 * Class constructor 
 * @param arrayWords // array to be sorted. 
 */
	SelectionSort(K[] arrayWords) {
		this.arrayWords = arrayWords;
	}
/**
 * This is the calling method of the class
 * It also calculats the run time. 
 */
	public void sortList() {
		long startTime = System.currentTimeMillis();
		selectionSort(arrayWords);
		long endTime = System.currentTimeMillis();
		runtime = endTime - startTime;
		System.out.println();
		printing();
	}
/**
 * This methods sorts the array of words by selection sort. 
 * @param arr // the array to be sorted. 
 */
	private void selectionSort(K arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				counter++;
				if (arr[j].compareTo(arr[min_idx]) < 0) {
					min_idx = j;
				}
			}
			K temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	/**
	 * This method method is not used. It's only for checking  purpose. 
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
