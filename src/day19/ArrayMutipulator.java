package day19;

public class ArrayMutipulator {
	public static void main(String[] args) {
		int[]  iArr = {1, 3, 4, 2, 3, 8};
		String[] sArr = {"a", "bd", "fd", "str", "sd", "k"};
		
		printArr(sArr);
		swap(sArr, 2, 4);
		printArr(sArr);
	}

	public static <T> void swap(T[] iArr, int i, int j) {
		T tmp = iArr[i];
		iArr[i] = iArr[j];
		iArr[j] = tmp;
	}
	
	public static <T> void printArr(T[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
}
