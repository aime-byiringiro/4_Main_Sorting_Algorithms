
public class testing {

	// HashMap<String, Integer> hah = new HashMap<String, Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String output1 = "ALGORITHM       |"; // 16
		String output2 = "================+";// 16

		String output2a = "Comparisons     |"; // 16
		String output3 = "================+";// 16

		String output3a = "Time (Milliseconds)  |"; // 16
		String output4 = "=====================+";// 21s
		
		
	String strA =  "ALGORITHM       |" + "Comparisons     |" + "Time (Milliseconds)  |";
	String strB = "================+" + "================+" + "=====================+";

		String str1 = output1 + output2a + output3a;
		String str2 = output2 + output3 + output4;

		String algorithmName = "Selection Sort |";
		String chek = "----------------";

		System.out.println(str1);

		System.out.println(str2);
	}
	
//	void upheap(K[] heap2, int index, int n) {
//		int parentIndex = (index - 1) / 2;
//
//		while (index > 0 && heap2[index].compareTo(heap2[parentIndex]) < 0) {
//			swap(heap2, index, parentIndex);
//			index = parentIndex;
//			parentIndex = (index - 1) / 2;
//		}
//	}

}
