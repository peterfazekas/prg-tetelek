package hu.prgtetelek.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Initialization {

	private final int n;
	private final int bound;
	
	public Initialization(final int n, final int bound) {
		this.n = n;
		this.bound = bound;
	}

	public List<Integer> init() {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			list.add(random.nextInt(bound - 1) + 1);
		}
		return list;
	}
}
