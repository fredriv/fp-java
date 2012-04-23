package no.knowit.javafpworkshop;

import static fj.data.List.iterableList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

/**
 * Hint: The imports below are useful for solving the exercises
 */

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.filter;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.collection.LambdaCollections.with;
import static org.funcito.FuncitoFJ.callsTo;
import static org.funcito.FuncitoFJ.fFor;
import static org.hamcrest.Matchers.lessThan;

import fj.F;
import org.hamcrest.Matcher;

public class Exercise_3_Transform_Test {

	/**
	 * Using LambdaJ: Extract the first names of the people in the list.
	 */
	@Test
	public void first_names_lambdaj() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		List<String> firstNames = extract(people, on(Person.class)
				.getFirstName());
		firstNames = with(people).extract(on(Person.class).getFirstName());

		assertThat(firstNames, hasItems("Luke", "Leia", "Han"));
		assertThat(firstNames.size(), is(equalTo(3)));
	}

	/**
	 * Using FunctionalJava: Transform (map) the list of people to a list
	 * containing their first names.
	 * 
	 * Hint: User Funcito (fFor & callsTo) to extract first name from person
	 */
	@Test
	public void first_names_functionaljava() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		F<Person, String> toFirstName = fFor(callsTo(Person.class)
				.getFirstName());

		fj.data.List<String> firstNames = iterableList(people).map(toFirstName);

		assertThat(firstNames, hasItems("Luke", "Leia", "Han"));
		assertThat(firstNames.length(), is(equalTo(3)));
	}

	/**
	 * Using LambdaJ: Find the first names of the teens in the list.
	 */
	@Test
	public void first_names_of_teens_lambdaj() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		Matcher<Person> isTeen = having(on(Person.class).getAge(), lessThan(20));

		List<String> firstNames = extract(filter(isTeen, people),
				on(Person.class).getFirstName());

		firstNames = with(people).retain(isTeen).extract(
				on(Person.class).getFirstName());

		assertThat(firstNames, hasItems("Luke", "Leia"));
		assertThat(firstNames, not(hasItem("Han")));
		assertThat(firstNames.size(), is(equalTo(2)));
	}

	/**
	 * Using FunctionalJava: Find the first names of the teens in the list.
	 */
	@Test
	public void first_names_of_teens_functionaljava() {
		Person luke = new Person("Luke", "Skywalker", 19);
		Person leia = new Person("Leia", "Organa", 19);
		Person han = new Person("Han", "Solo", 29);
		final List<Person> people = ImmutableList.of(luke, leia, han);

		F<Person, Boolean> isTeen = new F<Person, Boolean>() {
			@Override
			public Boolean f(Person p) {
				return p.getAge() < 20;
			}
		};
		F<Person, String> toFirstName = fFor(callsTo(Person.class)
				.getFirstName());

		fj.data.List<String> firstNames = iterableList(people).filter(isTeen)
				.map(toFirstName);

		assertThat(firstNames, hasItems("Luke", "Leia"));
		assertThat(firstNames, not(hasItem("Han")));
		assertThat(firstNames.length(), is(equalTo(2)));
	}

}
