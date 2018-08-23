package hu.prgtetelek.model.service.sort;

public class SimpleSort implements SortStrategy {

	private final int[] x;

	public SimpleSort(int[] x) {
		this.x = x.clone();
	}

	@Override
	public int[] sort() {
		for (int i = 0; i < x.length - 1; i++) {
			for (int j = i + 1; j < x.length; j++) {
				swap(i, j);
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
