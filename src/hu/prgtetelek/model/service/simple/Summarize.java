package hu.prgtetelek.model.service.simple;

public class Summarize implements SimpleStrategy<Integer> {

	private final int[] x;
	
	public Summarize(final int[] x) {
		this.x = x;
	}

	@Override
	public Integer getResult(int denominator) {
		int s = 0;
		for (int i : x) {
			s += i; 
		}
		return s;
	}

}
