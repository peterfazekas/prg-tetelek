package hu.prgtetelek.model.service.simple;

public class Count implements SimpleStrategy<Integer> {

	private final int[] x;
	
	public Count(final int[] x) {
		this.x = x;
	}

	@Override
	public Integer getResult(int denominator) {
		int db = 0;
		for (int i : x) {
			if (i % denominator == 0) {
				db++;
			}
		}
		return db;
	}

}
