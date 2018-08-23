package hu.prgtetelek.model.service.simple;

public class Select implements SimpleStrategy<Integer> {

	private final int[] x;
	
	public Select(final int[] x) {
		this.x = x;
	}

	@Override
	public Integer getResult(int denominator) {
		int i = 0;
		while (isNotDivisible(i, denominator)) {
			i++;
		}
		return i;
	}
	
	private boolean isNotDivisible(int i, int denominator) {
		return i < x.length && !(x[i] % denominator == 0);
	}

}
