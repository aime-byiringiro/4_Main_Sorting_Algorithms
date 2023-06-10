public class HeapSort<K extends Comparable<K>> {

	int counter = 0;
	String algorithmName = "Heapsort        |  ";
	String numComaparison;
	String time;
	long runtime;
	String result_Table;
	K[] arrayWords;

	public HeapSort(K[] arrayWords) {
		// TODO Auto-generated constructor stub
		this.arrayWords = arrayWords;
	}

	/**
	 * The calling method of the class This method also calcutates the run time
	 */
	public void sortList() {
		long startTime = System.currentTimeMillis();
		sort(arrayWords);
		long endTime = System.currentTimeMillis();
		runtime = endTime - startTime;
		printing();

	}

	public void sort(K[] arrayWords) {
		int n = arrayWords.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			// rearranging in a heap order
			heapify(arrayWords, n, i);
		}
		for (int i = n - 1; i >= 0; i--) {

			// extrating from the root and swaping
			K temp = arrayWords[0];
			arrayWords[0] = arrayWords[i];
			arrayWords[i] = temp;
			heapify(arrayWords, i, 0);
		}
	}

	/**
	 * 
	 * @param arrayWords
	 * @param n          // the lenth/size of the array
	 * @param i          // index of the word
	 */
	private void heapify(K[] arrayWords, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (left < n) {
			counter++;
			if (arrayWords[left].compareTo(arrayWords[largest]) > 0) {
				largest = left;
			}
		}
		if (right < n) {
			counter++;
			if (arrayWords[right].compareTo(arrayWords[largest]) > 0) {
				largest = right;
			}
		}
		if (largest != i) {
			K swap = arrayWords[i];
			arrayWords[i] = arrayWords[largest];
			arrayWords[largest] = swap;
			heapify(arrayWords, n, largest);
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
