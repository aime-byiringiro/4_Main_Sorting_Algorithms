
import java.util.Scanner;

/**
 * Data Structure __ Lab6
 * 
 * @author Aime Byiringiro This Lab/Program uses 5 sorting algorithm --
 *         Selection sort, Insertion sort, Heap sort, Merge sort, and quick sort
 *         -- to compare their run time and countings. Each sorting algorithm
 *         has its own class named after its name.
 * 
 *
 */

public class Project6 {

	// Class instances of the sorting algorithms
	HeapSort<String> myHeapSort;
	InsertionSort<String> myInsertionSort;
	SelectionSort<String> mySelectionSort;
	MergeSort<String> myMergeSort;
	QuickSort<String> myQuickSort;

	// Arrays to store unsorted words
	String[] arraySelection;
	String[] arrayInsertion;
	String[] arrayHeap;
	String[] arrayMerge;
	String[] arrayQuick;

	/**
	 * This is the main method. It is the entry of the progra
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Project6 myProject = new Project6();
		myProject.myList();
	}

	/**
	 * This class handles inputs from the user.
	 */
	public void myList() {
		Scanner scanner = new Scanner(System.in);
		String na = scanner.next();
		int n = Integer.parseInt(na);
		arraySelection = new String[n];
		arrayInsertion = new String[n];
		arrayHeap = new String[n];
		arrayMerge = new String[n];
		arrayQuick = new String[n];
		for (int i = 0; i < n; i++) {
			String line = scanner.next();
			arraySelection[i] = line;
			arrayQuick[i] = line;
			arrayHeap[i] = line;
			arrayMerge[i] = line;
			arrayInsertion[i] = line;
		}
		mySelectionSort = new SelectionSort<String>(arraySelection);
		myInsertionSort = new InsertionSort<String>(arrayInsertion);
		myHeapSort = new HeapSort<String>(arrayHeap);
		myMergeSort = new MergeSort<String>(arrayMerge);
		myQuickSort = new QuickSort<String>(arrayQuick);
		callingMethods();
		scanner.close();
	}

	/**
	 * This method mainly calls the sorting algorithms accordings.
	 */
	private void callingMethods() {
		String strA = "ALGORITHM       |" + "Comparisons       |" + "Time (Milliseconds)   |";
		String strB = "================+" + "==================+" + "======================+";
		String strC = "----------------+" + "------------------+" + "----------------------+";

		System.out.println(strA);
		System.out.print(strB);

		mySelectionSort.sortList();
		System.out.println(strC);

		myInsertionSort.sortList();
		System.out.println(strC);

		myHeapSort.sortList();
		System.out.println(strC);

		myMergeSort.sortList();
		System.out.println(strC);

		myQuickSort.sortList();
		System.out.println(strC);

	}
}
