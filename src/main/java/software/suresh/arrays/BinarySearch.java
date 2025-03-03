package software.suresh.arrays;
//Feb 28, 2025
public class BinarySearch {

	public static void main(String[] args) {
		
		int arr[] = { 2, 3, 4, 10, 40 };
		System.err.println(binarySearchExample(arr, 450));
	}

	public static int binarySearchExample(int[] arr, int find) {
		int lower = 0, higher = arr.length - 1;

		while (lower <= higher) {

			int mid = lower + (higher - lower) / 2;

			if (arr[mid] == find)
				return mid;

			if (arr[mid] < find)
				lower = mid + 1;

			else
				higher = mid - 1;
		}
		return -1;

	}

}
