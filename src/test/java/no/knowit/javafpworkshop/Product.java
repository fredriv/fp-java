package no.knowit.javafpworkshop;

import org.joda.time.LocalDate;

public class Product {

	private final String name;

	private final LocalDate from, to;

	public Product(String name, LocalDate from, LocalDate to) {
		this.name = name;
		this.from = from;
		this.to = to;
	}

	public boolean isAvailable(LocalDate date) {
		return date != null && !date.isBefore(from)
				&& (to == null || !date.isAfter(to));
	}

	public String toString() {
		return name;
	}

}
