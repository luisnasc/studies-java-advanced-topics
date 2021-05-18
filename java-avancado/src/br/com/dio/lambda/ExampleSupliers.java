package br.com.dio.lambda;

import java.util.function.Supplier;

public class ExampleSupliers {

	public static void main(String[] args) {
		Supplier<Person> instance = () -> new Person();
		System.out.println(instance.get());
		
		Supplier<Person> instancePerson = Person::new;
		System.out.println(instance.get());
	}

}

class Person {
	private String name;
	private int age;
	
	public Person() {
		this.name = "Luis";
		this.age = 29;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Age: %d", this.name, this.age);
	}
}