package no.knowit.javafpworkshop;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Hint: The imports below are useful for solving the exercises
 */

import static ch.lambdaj.Lambda.avgFrom;
import static ch.lambdaj.Lambda.joinFrom;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sort;

public class LambdaJ_Test {

	/**
	 * Find the average age of the people.
	 */
	@Test
	@Ignore
	public void average_age() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		int averageAge = 0;

		assertThat(averageAge, is(equalTo((29 + 19 + 19) / 3)));
	}

	/**
	 * Join the first names of the people into a comma separated list of names.
	 */
	@Test
	@Ignore
	public void first_names_comma_separated() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		String firstNames = null;

		assertThat(firstNames, is(equalTo("Luke, Leia, Han")));
	}

	/**
	 * Sort the people by last name.
	 */
	@Test
	@Ignore
	public void sorted_by_last_name() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		List<Person> sorted = people;

		assertThat(sorted, is(equalTo(asList(leia, luke, han))));
	}

}