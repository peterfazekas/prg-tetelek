package hu.prgtetelek.model;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import hu.prgtetelek.model.service.simple.Choose;
import hu.prgtetelek.model.service.simple.Count;
import hu.prgtetelek.model.service.simple.Max;
import hu.prgtetelek.model.service.simple.Search;
import hu.prgtetelek.model.service.simple.Select;
import hu.prgtetelek.model.service.simple.SimpleStrategy;
import hu.prgtetelek.model.service.simple.Summarize;

public class ProgramFacade {

	private final List<Integer> x;

	public ProgramFacade() {
		Initialization initialization = new Initialization(100, 100);
		x = initialization.init();
	}
	
	public String getSum() {
		SimpleStrategy<Integer> summarize = new Summarize(x);
		return String.format("Összege: %d", summarize.getResult(0));
	}
	
	public String hasValue(final int denominator) {
		SimpleStrategy<Boolean> hasValue = new Choose(x);
		String result = hasValue.getResult(denominator) ? "van" : "nincs";
		return String.format("A sorozatban %s %d-vel osztható szám.", result, denominator);
	}
	
	public String select(final int denominator) {
		SimpleStrategy<Integer> select = new Select(x);
		return String.format("A sorozat %d. eleme osztható %d-vel", select.getResult(denominator), denominator);
	}
	
	public String search(final int denominator) {
		SimpleStrategy<Optional<Integer>> search = new Search(x);
		return search.getResult(denominator).isPresent()
				? String.format("A sorozat %d. eleme osztható %d-vel", search.getResult(denominator).get(), denominator)		
				: String.format("A sorozatban nem található %d-vel ostzható elem.", denominator);
	}
	
	public String count(final int denominator) {
		SimpleStrategy<Long> count = new Count(x);
		return String.format("A sorozatban %d db %d-vel osztható szám van", count.getResult(denominator), denominator);
	}
	
	public String max() {
		SimpleStrategy<Integer> max = new Max(x);
		return String.format("A sorozat legnagyobb értékû eleme a(z) %d", max.getResult(0));
	}
	
	public String sort() {
		String text = String.format("A rendezendõ tömb:%n%s", this);
		x.sort(Comparator.reverseOrder());
		text += String.format("Rendezve:%n%s", this);
		return text;
	}
	
	@Override
	public String toString() {
		return "App [x=" + x.toString() + "]";
	}	
	
}
