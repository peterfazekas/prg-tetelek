package hu.prgtetelek.model;

import java.util.Random;

public class Initialization {

	private final int n;
	private final int bound;
	
	public Initialization(final int n, final int bound) {
		this.n = n;
		this.bound = bound;
	}

	public int[] init() {
		int[] tomb = new int[n];
		Random random = new Random();
		for (int i = 0; i < tomb.length; i++) {
			tomb[i] = random.nextInt(bound - 1) + 1;
		}
		return tomb;
	}
}
