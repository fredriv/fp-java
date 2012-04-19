package no.knowit.javafpworkshop;

import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class Exercise_1_Pure_Java_Functional_Test {

	/**
	 * Exercise: Filter the list of numbers, returning the numbers greater than 100.
	 *
	 * Use only immutable collections, final variables, etc.
	 *
	 * Hint: Use the provided _cons_ method to create new immutable lists out of
	 * an existing (immutable) list and a new element.
	 */
	@Test
	@Ignore
	public void numbers_above_100() {
		final List<Integer> numbers = ImmutableList.of(17, 314, 123, 42);

		final List<Integer> above_100 = emptyList();

		assertThat(above_100, hasItems(314, 123));
		assertThat(above_100.size(), is(equalTo(2)));
	}

	private List<Integer> cons(final Integer num, final List<Integer> nums) {
		return ImmutableList.<Integer> builder().addAll(nums).add(num).build();
	}

}
