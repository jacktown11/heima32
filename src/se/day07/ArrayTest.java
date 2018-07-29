package se.day07;

public class ArrayTest {
	public static void main(String[] args) {
		int[] arr = {23, 34, 45, 37};
		printArr(arr);

		reverseArr(arr);
		printArr(arr);

		// selectSort(arr);
		bubbleSort(arr);
		printArr(arr);
		
		System.out.println(binarySearch(arr, 37));
		System.out.println(binarySearch(arr, 0));

	}
	public static void printArr(int[] arr) {
		System.out.print("[");
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i]);
			if (i < len - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
	public static void reverseArr(int[] arr) {
		int tmp;
		int len = arr.length;
		for (int i = 0; i < len / 2; i++) {
			tmp = arr[i];
			arr[i] = arr[len - 1 - i];
			arr[len - 1 - i] = tmp;
		}
	}
	public static void selectSort(int[] arr) {
		int len = arr.length;
		int tmp;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	public static void bubbleSort(int[] arr) {
		int len = arr.length;
		int tmp;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
	public static int binarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length-1;
		int mid = (low+high)/2;
		while(low <= high) {
			if(target > arr[mid]) {
				low = mid + 1;
			}else if(target < arr[mid]) {
				high = mid - 1;
			}else {
				return mid;
			}
			mid = (low + high)/2;
		}
		return -1;
	}
}
