package hu.prgtetelek.model.service.simple;

import java.util.List;
import java.util.Optional;

public class Search implements SimpleStrategy<Optional<Integer>> {

	private final List<Integer> x;
	
	public Search(final List<Integer> x) {
		this.x = x;
	}

	@Override
	public Optional<Integer> getResult(int denominator) {
		return x.stream().filter(i -> i % denominator == 0).findFirst();
	}
	
}
