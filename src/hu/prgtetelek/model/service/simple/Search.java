package hu.prgtetelek.model.service.simple;

public class Search implements SimpleStrategy<Integer> {

	private final int[] x;
	
	public Search(final int[] x) {
		this.x = x;
	}

	@Override
	public Integer getResult(int denominator) {
		int i = 0;
		while (isNotDivisible(i, denominator)) {
			i++;
		}
		return i < x.length ? i : -1;
	}
	
	private boolean isNotDivisible(int i, int denominator) {
		return i < x.length && !(x[i] % denominator == 0);
	}

}
