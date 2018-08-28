package hu.prgtetelek.model.service.simple;

import java.util.List;

public class Summarize implements SimpleStrategy<Integer> {

	private final List<Integer> x;
	
	public Summarize(final List<Integer> x) {
		this.x = x;
	}

	@Override
	public Integer getResult(int denominator) {
		return x.stream().mapToInt(Integer::intValue).sum();
	}

}
