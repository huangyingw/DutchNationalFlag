public class DutchNationalFlag {
	public static void dutchFlagSort(int[] arr, int p, int k) {
		int p_index = 0;
		int k_index = arr.length - 1;
		for (int i = 0; i <= k_index;) {
			if (arr[i] < p) {
				swap(arr, i, p_index);
				p_index++;
				i++;
			} else if (arr[i] >= k) {
				swap(arr, i, k_index);
				k_index--;
			} else {
				i++;
			}
		}
	}

	static void quicksort(int a[], int l, int r) {
		int i = l - 1, j = r, p = l - 1, q = r;
		int v = a[r];
		if (r <= l)
			return;
		for (;;) {
			while (a[++i] < v)
				;
			while (v < a[--j])
				if (j == l)
					break;
			if (i >= j)
				break;
			swap(a, a[i], a[j]);
			if (a[i] == v) {
				p++;
				swap(a, a[p], a[i]);
			}
			if (v == a[j]) {
				q--;
				swap(a, a[j], a[q]);
			}
		}
		swap(a, a[i], a[r]);
		j = i - 1;
		i = i + 1;
		for (int k = l; k < p; k++, j--)
			swap(a, a[k], a[j]);
		for (int k = r - 1; k > q; k--, i++)
			swap(a, a[i], a[k]);
		quicksort(a, l, j);
		quicksort(a, i, r);
	}

	public static void main(String[] args) {
		int[] data = { 5, 9, 3, 2, 1 };
		DutchNationalFlag dnf = new DutchNationalFlag();
		DutchNationalFlag.quicksort(data, 0, data.length - 1);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
		}
		System.out.println();
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
