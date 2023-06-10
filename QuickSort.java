import java.util.Comparator;
/**
 * 
 * @author aime
 *
 * @param <K>
 * 
 * This class sort an array of words by quick sort algorithm
 */
public class QuickSort<K> {
	K[] arrayWords;
	Comparator<K> myComparator = (s1, s2) -> ((String) s1).compareToIgnoreCase((String) s2);
	int counter = 0;
	String algorithmName = "Quicksort       |  ";
	String numComaparison;
	String time;
	long runtime;
	String result_Table;
/**
 * Class Constructor 
 * @param arrayWords
 */
	QuickSort(K[] arrayWords) {
		this.arrayWords = arrayWords;
	}
/**
 * This is the calling method of the program
 * It also calculates the run time of the quick sort algorithm 
 */
	public void sortList() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		quickSortInPlace(arrayWords, myComparator, 0, arrayWords.length - 1);
		long endTime = System.currentTimeMillis();
		runtime = endTime - startTime;
		printing();

	}
/**
 * 
 * @param S // array to srot
 * @param comp // the comparator 
 * @param a // the left 
 * @param b // b-1 is the right
 */
	private void quickSortInPlace(K[] S, Comparator<K> comp, int a, int b) {
		if (a >= b)
			return; // subarray is trivally sorted
		int left = a;
		int right = b - 1;
		K pivot = S[b];
		K temp; // temp Object used for swapping
		while (left <= right) {
			while (left <= right) {
				counter++;
				if (comp.compare(S[left], pivot) < 0) {
					left++;
				} else {
					break;
				}
			}
			while (left <= right) {
				counter++;
				if (comp.compare(S[right], pivot) > 0) {
					right--;
				} else {
					break;
				}
			}
			if (left <= right) {
				temp = S[left];
				S[left] = S[right];
				S[right] = temp;
				left++;
				right--;
			}
		}
		// put pivot into its final place (currently marked by left index)
		temp = S[left];
		S[left] = S[b];
		S[b] = temp;
		// make recursive call
		quickSortInPlace(S, comp, a, left - 1);
		quickSortInPlace(S, comp, left + 1, b);

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
