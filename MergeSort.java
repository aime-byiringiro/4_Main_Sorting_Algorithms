import java.util.Arrays;
import java.util.Comparator;
/**
 * 
 * @author Aime Byiringiro
 *
 * @param <K>
 * This class sorts the array of words by merge sort. 
 */

public class MergeSort<K> {

	K[] arrayWords; // unsorted array.
	Comparator<K> myComparator = (s1, s2) -> ((String) s1).compareToIgnoreCase((String) s2);
	int counter =0; // the counter  of the number of comparsios 
	String algorithmName =  "Merge Sort      |  ";    
	String numComaparison; // number of comparsions in string
	String time;
	long runtime ;
	String result_Table; 

	
	/**
	 * Class contructor 
	 * @param arrayWords
	 */
	MergeSort(K[] arrayWords) {
		this.arrayWords = arrayWords;
	}
	
	/**
	 * This is the calling method of the class. 
	 */
	public void sortList() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		mergeSort(arrayWords, myComparator);
		long endTime = System.currentTimeMillis();
		runtime = endTime - startTime;
		printing() ;
		
 
	}
	/**
	 * This method sorts the array
	 * @param S // the unsorted array
	 * @param comp // the comparator 
	 */
	private void mergeSort(K[] S, Comparator<K> comp) {
		int n = S.length;
		if (n < 2)
			return;
		int mid = n / 2;
		K[] S1 = Arrays.copyOfRange(S, 0, mid);
		K[] S2 = Arrays.copyOfRange(S, mid, n);
		mergeSort(S1, comp);
		mergeSort(S2, comp);
		merge(S1, S2, S, comp);
		

	}
	/**
	 * This method merges the arrays
	 * @param S1 // The first array
	 * @param S2 // The second array
	 * @param S // The merged array
	 * @param comp // The comparator 
	 */
	private void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
	    int i = 0;
	    int j = 0;
	    while (i + j < S.length) {
	        if (j == S2.length) {
	            S[i + j] = S1[i++];
	        } else {
	            if (i < S1.length) {
	            	counter++;
	                if (comp.compare(S1[i], S2[j]) < 0) {
	                    S[i + j] = S1[i++];
	                } else {
	                    S[i + j] = S2[j++];
	                }
	            } else {
	                S[i + j] = S2[j++];
	            }
	        }
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
