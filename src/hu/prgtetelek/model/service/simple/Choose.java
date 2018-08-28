package hu.prgtetelek.model.service.simple;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Choose implements SimpleStrategy<Boolean> {

	private final List<Integer> x;
	
	public Choose(final List<Integer> x) {
		this.x = x;
	}

	@Override
	public Boolean getResult(int denominator) {
		List<Integer> collect = x.stream()
				.filter(isDivisible(denominator))
				.collect(Collectors.toList());
		return collect.size() > 0;
	}

	private Predicate<Integer> isDivisible(int denominator) {
		return i -> i % denominator == 0;
	}
	

}
