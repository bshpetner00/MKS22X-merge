public class Merge {

	private static void swap(int[]data, int i0,int v0, int i1, int v1) {
		data[i0] = v1;
		data[i1] = v0;
	}

	public static void mergesort(int[]data) {
		mergeH(data,0,data.length-1);
	}
	public static void mergeH(int[]data, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int piv = (hi - lo) / 2 + lo;
		mergeH(data, lo, piv);
		mergeH(data, piv+1, hi);
		merge(data,lo,piv+1,hi);
	}
	public static void merge(int[]data,int lo, int secondHalf, int hi) {
		if (lo + 1 == hi) {
			if (data[lo] > data[hi]) {
				swap(data, lo, data[lo], hi, data[hi]);
			}
		}
		else {
			int[] temp = data;
			int iOne = 0;
			int iTwo = 0;

		}
	}
}