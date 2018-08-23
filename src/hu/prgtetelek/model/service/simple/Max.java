package hu.prgtetelek.model.service.simple;

public class Max implements SimpleStrategy<Integer> {

	private final int[] x;
	
	public Max(final int[] x) {
		this.x = x;
	}

	@Override
	public Integer getResult(int denominator) {
		int max = 0;
		for (int i = 1; i < x.length; i++) {
			if (x[max] < x[i]) {
				max = i;
			}
		}
		return max;
	}

}
