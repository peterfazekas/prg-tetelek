package hu.prgtetelek.model.service.simple;

import java.util.List;
import java.util.function.Predicate;

public class Count implements SimpleStrategy<Long> {

	private final List<Integer> x;
	
	public Count(final List<Integer> x) {
		this.x = x;
	}

	@Override
	public Long getResult(int denominator) {
		return x.stream().filter(isDivisible(denominator)).count();
	}

	private Predicate<Integer> isDivisible(int denominator) {
		return i -> i % denominator == 0;
	}

}
