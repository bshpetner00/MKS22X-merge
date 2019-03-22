import java.util.*;

public class Merge {

	private static void swap(int[]data, int i0,int v0, int i1, int v1) {
		data[i0] = v1;
		data[i1] = v0;
	}

	private static int medianI(int[]data, int start, int end) {
		int mid = (end+start)/2;
		if ((start - end) * (mid - start) >= 0) { // a >= b and a <= c OR a <= b and a >= c
			return start;
		}
		else if ((end - start) * (mid - end) >= 0) {// b >= a and b <= c OR b <= a and b >= c
			return end;
		}
		else {
			return mid;
		}
	}

	private static void insertionSort(int[]data, int lo, int hi) {
		return;
	}

	public static void mergesort(int[]data) {
		int[] temp = Arrays.copyOf(data, data.length);
		mergeH(data,temp,0,data.length-1);

	}
	public static void mergeH(int[]data, int[]temp, int lo, int hi) {
		if (hi - lo <= 47) {
			insertionSort(data,lo,hi);
		}
		else if (lo >= hi) {
			return;
		}
		else {
			int piv = medianI(data,lo,hi);
			mergeH(data, temp, lo, piv);
			mergeH(data, temp, piv+1, hi);
			merge(data,temp,lo,piv,hi);
		}
	}

	private static void cleanUp(int[]data, int iOne, int iTwo, int lo, int piv, int hi) {
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
		while (iOne <= piv-low && iTwo < hi-piv) {
			if (temp[lo+iOne] >= temp[mid+(iTwo+1)]) {
				data[lo+iOne+iTwo] = temp[mid+(iTwo+1)];
				iTwo++;
			}
			else {
				data[lo+iOne+iTwo] = temp[lo+iOne];
				iOne++;
			}
		}
		if (iOne <= piv-low || iTwo < hi-piv) {
			cleanUp(data, iOne, iTwo, lo, piv, hi);
		}
	}
}
