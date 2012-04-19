package no.knowit.javafpworkshop;

public class Person {

	private final String firstName;

	private final String lastName;

	private final int age;

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return firstName + " " + lastName + "(" + age + ")";
	}
	
	public boolean equals(Object o) {
		if (o == null || !getClass().equals(o.getClass()))
			return false;

		Person other = (Person) o;
		return firstName.equals(other.firstName)
				&& lastName.equals(other.lastName) && age == other.age;
	}
}