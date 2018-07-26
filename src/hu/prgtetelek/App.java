package hu.prgtetelek;

import java.util.Arrays;
import java.util.Random;

public class App {

	private static final int BOUND = 100;
	private static final int N = 100;

	private int[] x;

	public App() {
		x = new int[N];
		x = init();
	}

	public static void main(String[] args) {
		App app = new App();
		app.runApp();
	}

	private void runApp() {
		System.out.println(this);
		System.out.println("Összege: " + summarize());
		System.out.println(search(99));
		long divider = 97L;
		if (search(divider) > -1) {
			System.out.println(search(divider));
		} else {
			System.out.println("nincs!");
		}
		System.out.println(count(3) + " db 3-al osztható szám van a sorozatban.");
		System.out.println("A legnagyobb értékû elem a sorozatban: " + x[max()]);
		System.out.println("Egyszerû kíválasztásos rendezés");
		System.out.println(this);
		System.out.println(Arrays.toString(simplesort()));
		System.out.println(this);
		System.out.println(Arrays.toString(bubblesort()));
	}

	private int summarize() {
		int s = 0;
		for (int i : x) {
			s += i; // s = s + i
		}
		return s;
	}

	private boolean choose(int divider) {
		int i = 0;
		while (isNotDivisible(i, divider)) {// i<n és nem T(x(i))
			i++;
		}
		return i < N;
	}

	private int select(int divider) {
		int i = 0;
		while (isNotDivisible(i, divider)) {
			i++;
		}
		return i;
	}

	private int search(long divider) {
		int i = 0;
		while (isNotDivisible(i, (int) divider)) {
			i++;
		}
		return i < N ? i : -1; //
	}

	private String search(int divider) {
		String text;
		if (choose(divider)) {
			text = String.format("A sorozat elemei között van %d-vel osztható szám, a sorban a %d.", divider,
					select(divider));
		} else {
			text = String.format("A sorozat elemei között nincs %d-vel osztható szám.", divider);
		}
		return text;
	}

	private int count(int divider) {
		int db = 0;
		for (int i : x) {
			if (i % divider == 0) {
				db++;
			}
		}
		return db;
	}

	private int max() {
		int max = 0;
		for (int i = 1; i < x.length; i++) {
			if (x[max] < x[i]) {
				max = i;
			}
		}
		return max;
	}

	private int[] simplesort() {
		int[] sortable = x.clone();
		for (int i = 0; i < sortable.length - 1; i++) {
			for (int j = i + 1; j < sortable.length; j++) {
				if (sortable[i] > sortable[j]) {
					int p = sortable[i];
					sortable[i] = sortable[j];
					sortable[j] = p;
				}
			}
		}
		return sortable;
	}

	private int[] bubblesort() {
		int[] sortable = x.clone();
		for (int i = sortable.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (sortable[j] > sortable[j + 1]) {
					int p = sortable[j];
					sortable[j] = sortable[j + 1];
					sortable[j + 1] = p;
				}
			}
		}
		return sortable;
	}

	private boolean isNotDivisible(int i, int divider) {
		return i < N && !(x[i] % divider == 0);
	}

	private int[] init() {
		int[] tomb = new int[N];
		Random random = new Random();
		for (int i = 0; i < tomb.length; i++) {
			tomb[i] = random.nextInt(BOUND - 1) + 1;
		}
		return tomb;
	}

	@Override
	public String toString() {
		return "App [x=" + Arrays.toString(x) + "]";
	}
}
