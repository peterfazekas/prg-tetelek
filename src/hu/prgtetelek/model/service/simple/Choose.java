package hu.prgtetelek.model.service.simple;

public class Choose implements SimpleStrategy<Boolean> {

	private final int[] x;
	
	public Choose(final int[] x) {
		this.x = x;
	}

	@Override
	public Boolean getResult(int denominator) {
		int i = 0;
		while (isNotDivisible(i, denominator)) {
			i++;
		}
		return i < x.length;
	}
	
	private boolean isNotDivisible(int i, int denominator) {
		return i < x.length && !(x[i] % denominator == 0);
	}

}
