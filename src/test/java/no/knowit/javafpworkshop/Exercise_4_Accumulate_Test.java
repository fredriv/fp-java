package no.knowit.javafpworkshop;

import static fj.data.List.iterableList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

/**
 * Hint: The imports below are useful for solving the exercises
 */

import static ch.lambdaj.Lambda.aggregate;
import static ch.lambdaj.Lambda.sumFrom;
import static fj.function.Integers.multiply;
import static fj.function.Integers.add;
import static org.funcito.FuncitoFJ.callsTo;
import static org.funcito.FuncitoFJ.fFor;

import ch.lambdaj.function.aggregate.PairAggregator;
import fj.F;

public class Exercise_4_Accumulate_Test {

	/**
	 * Using LambdaJ: Find the sum of ages of the people.
	 */
	@Test
	public void total_age_lambdaj() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		int totalAge = sumFrom(people).getAge();

		assertThat(totalAge, is(equalTo(19 + 19 + 29)));
	}

	/**
	 * Using FunctionalJava: Find the sum of ages of the people.
	 * 
	 * Hint: Use Funcito (fFor & callsTo) to extract age from person Hint: Use
	 * foldLeft and built-in function
	 */
	@Test
	public void total_age_functionaljava() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		F<Person, Integer> toAge = fFor(callsTo(Person.class).getAge());

		int totalAge = iterableList(people).map(toAge).foldLeft(add, 0);

		assertThat(totalAge, is(equalTo(19 + 19 + 29)));
	}

	/**
	 * Using LambdaJ: Find the product of the numbers, i.e. multiply them
	 * together.
	 * 
	 * Hint: Create a PairAggregator.
	 */
	@Test
	public void product_of_numbers_lambdaj() {
		List<Integer> numbers = ImmutableList.of(1, 2, 3, 4, 5, 6);

		PairAggregator<Integer> multiplier = new PairAggregator<Integer>() {

			@Override
			protected Integer aggregate(Integer a, Integer b) {
				return a * b;
			}

			@Override
			protected Integer emptyItem() {
				return 1;
			}
		};
		int product = aggregate(numbers, multiplier);

		assertThat(product, is(equalTo(720)));
	}

	/**
	 * Using FunctionalJava: Find the product of the numbers, i.e. multiply them
	 * together.
	 * 
	 * Hint: Use foldLeft and built-in function
	 */
	@Test
	public void product_of_numbers_functionaljava() {
		List<Integer> numbers = ImmutableList.of(1, 2, 3, 4, 5, 6);

		int product = iterableList(numbers).foldLeft(multiply, 1);

		assertThat(product, is(equalTo(720)));
	}
}
