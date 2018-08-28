package hu.prgtetelek.model.service.simple;

import java.util.List;
import java.util.function.Predicate;

public class Select implements SimpleStrategy<Integer> {

	private final List<Integer> x;
	
	public Select(final List<Integer> x) {
		this.x = x;
	}

	@Override
	public Integer getResult(int denominator) {
		return x.stream().filter(isDivisible(denominator)).findFirst().get();
	}

	private Predicate<Integer> isDivisible(int denominator) {
		return i -> i % denominator == 0;
	}
	

}
