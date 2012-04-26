package no.knowit.javafpworkshop;

import static fj.data.List.iterableList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Hint: The imports below are useful for solving the exercises
 */

import static ch.lambdaj.Lambda.filter;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import ch.lambdaj.function.matcher.LambdaJMatcher;
import fj.F;
import org.hamcrest.Matcher;

public class Exercise_2_Filter_Test {

	/**
	 * Using LambdaJ: Filter the list of numbers, returning the numbers greater
	 * than 100.
	 */
	@Test
	@Ignore
	public void numbers_below_100_lambdaj() {
		final List<Integer> numbers = ImmutableList.of(17, 314, 123, 42);

		List<Integer> below_100 = numbers;

		assertThat(below_100, hasItems(17, 42));
		assertThat(below_100.size(), is(equalTo(2)));
	}

	/**
	 * Using FunctionalJava: Filter the list of numbers, returning the numbers
	 * greater than 100.
	 */
	@Test
	@Ignore
	public void numbers_below_100_functionaljava() {
		final List<Integer> numbers = ImmutableList.of(17, 314, 123, 42);

		fj.data.List<Integer> below_100 = iterableList(numbers);

		assertThat(below_100, hasItems(17, 42));
		assertThat(below_100.length(), is(equalTo(2)));
	}

	/**
	 * Using LambdaJ: Filter the list of people, returning the people who are
	 * teens.
	 * 
	 * For this exercise, we define "teen" as "less than 20 years old", i.e. no
	 * need to check lower age limit.
	 */
	@Test
	@Ignore
	public void find_teens_lambdaj() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		List<Person> teens = people;

		assertThat(teens, hasItems(luke, leia));
		assertThat(teens.size(), is(equalTo(2)));
	}

	/**
	 * Using FunctionalJava: Filter the list of people, returning the people who
	 * are teens.
	 * 
	 * For this exercise, we define "teen" as "less than 20 years old", i.e. no
	 * need to check lower age limit.
	 */
	@Test
	@Ignore
	public void find_teens_functionaljava() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		fj.data.List<Person> teens = iterableList(people);

		assertThat(teens, hasItems(luke, leia));
		assertThat(teens.length(), is(equalTo(2)));
	}

	/**
	 * Using LambdaJ: Filter the list of people, returning those whose last name
	 * starts with a letter from M to R.
	 * 
	 * Hint: You may need to create a LambdaJMatcher for part of this exercise.
	 */
	@Test
	@Ignore
	public void people_with_lastname_starting_with_M_to_R_lambdaj() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		List<Person> people_M_to_R = people;

		assertThat(people_M_to_R, hasItem(leia));
		assertThat(people_M_to_R.size(), is(equalTo(1)));
	}

	/**
	 * Using FunctionalJava: Filter the list of people, returning those whose
	 * last name starts with a letter from M to R.
	 * 
	 * Hint: You may need to create a LambdaJMatcher for part of this exercise.
	 */
	@Test
	@Ignore
	public void people_with_lastname_starting_with_M_to_R_functionaljava() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		fj.data.List<Person> people_M_to_R = iterableList(people);

		assertThat(people_M_to_R, hasItem(leia));
		assertThat(people_M_to_R.length(), is(equalTo(1)));
	}
}
