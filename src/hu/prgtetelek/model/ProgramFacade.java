package hu.prgtetelek.model;

import java.util.Arrays;

import hu.prgtetelek.model.service.simple.Choose;
import hu.prgtetelek.model.service.simple.Count;
import hu.prgtetelek.model.service.simple.Max;
import hu.prgtetelek.model.service.simple.Search;
import hu.prgtetelek.model.service.simple.Select;
import hu.prgtetelek.model.service.simple.SimpleStrategy;
import hu.prgtetelek.model.service.simple.Summarize;
import hu.prgtetelek.model.service.sort.BubbleSort;
import hu.prgtetelek.model.service.sort.SimpleSort;
import hu.prgtetelek.model.service.sort.SortStrategy;

public class ProgramFacade {

	private final int[] x;

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
		SimpleStrategy<Integer> search = new Search(x);
		return search.getResult(denominator) == -1
				? String.format("A sorozatban nem található %d-vel ostzható elem.", denominator)
				: String.format("A sorozat %d. eleme osztható %d-vel", search.getResult(denominator), denominator);		
	}
	
	public String count(final int denominator) {
		SimpleStrategy<Integer> count = new Count(x);
		return String.format("A sorozatban %d db %d-vel osztható szám van", count.getResult(denominator), denominator);
	}
	
	public String max() {
		SimpleStrategy<Integer> max = new Max(x);
		int maxIndex = max.getResult(0);
		return String.format("A sorozat %d. eleme a legnagyobb(%d)", maxIndex, x[maxIndex]);
	}
	
	public String sort() {
		return String.format("A rendezendõ tömb:%n%s%nKözvetlen kiválasztással:%n%s%nBuborékrendezéssel:%n%s", 
						     this, simpleSort(), bubbleSort());
	}
	
	private String simpleSort() {
		SortStrategy simple = new SimpleSort(x);
		return Arrays.toString(simple.sort());	
	}
	
	private String bubbleSort() {
		SortStrategy bubble = new BubbleSort(x);
		return Arrays.toString(bubble.sort());	
	}
	
	@Override
	public String toString() {
		return "App [x=" + Arrays.toString(x) + "]";
	}	
	
}
