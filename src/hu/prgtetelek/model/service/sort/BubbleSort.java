package hu.prgtetelek.model.service.sort;

public class BubbleSort implements SortStrategy {

	private final int[] x;

	public BubbleSort(int[] x) {
		this.x = x.clone();
	}

	@Override
	public int[] sort() {
		for (int i = x.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				swap(j, j + 1);
			}
		}
		return x;
	}

	private void swap(int i, int j) {
		if (x[i] > x[j]) {
			int p = x[i];
			x[i] = x[j];
			x[j] = p;
		}
	}

}
