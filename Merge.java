import java.util.*;

public class Merge {

	private static void swap(int[]ary, int f, int l) {
		int temp = ary[f];
		ary[f] = ary[l];
		ary[l] = temp;
	}

	public static void insertionSort(int [] data, int lo, int hi) {
		if (data.length != 0) {
			for (int i = lo + 1; i < hi+1; i++) {
				int temp = data[i];
      			int j = i - 1;
      			while (j + 1 > lo && temp < data[j]){
        			data[j+1] = data[j];
        			j--;
      			}
      			data[j+1] = temp;
			}
		}
	}


	public static void mergesort(int[]data) {
		int[] temp = Arrays.copyOf(data, data.length);
		mergeH(data,temp,0,data.length-1);

	}
	public static void mergeH(int[]data, int[]temp, int lo, int hi) {
		if (lo < hi) {
			if (hi - lo <= 47) {
				insertionSort(data, lo, hi);
			}
			else {
				int piv = lo + (hi - lo) / 2;
				mergeH(temp, data, lo, piv);
				mergeH(temp, data, piv + 1, hi);
				merge(data, temp, lo, piv, hi);
			}
		}
	}

	private static void cleanUp(int[]data, int[]temp, int iOne, int iTwo, int lo, int piv, int hi) {
		while (iOne <= piv-lo) {
			data[lo+iOne+iTwo] = temp[lo+iOne];
			iOne++;
		}
		while (iTwo < hi-piv) {
			data[lo+iOne+iTwo] = temp[piv+iTwo+1];
			iTwo++;
		}
	}
	public static void merge(int[]data,int[]temp, int lo, int piv, int hi) {
		int iOne = 0;
		int iTwo = 0;
		while (iOne <= piv-lo && iTwo < hi-piv) {
			if (temp[lo+iOne] >= temp[piv+(iTwo+1)]) {
				data[lo+iOne+iTwo] = temp[piv+(iTwo+1)];
				iTwo++;
			}
			else {
				data[lo+iOne+iTwo] = temp[lo+iOne];
				iOne++;
			}
		}
		if (iOne <= piv-lo || iTwo < hi-piv) {
			cleanUp(data, temp, iOne, iTwo, lo, piv, hi);
		}
	}
}
