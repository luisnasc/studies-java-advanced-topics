package br.com.dio.lambda;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<String> validateEmpty = valor -> valor.isEmpty();
		System.out.println(validateEmpty.test(""));
		System.out.println(validateEmpty.test("oi"));
		
		Predicate<String> validateEmpty2 = String::isEmpty;
		System.out.println(validateEmpty2.test(""));
		System.out.println(validateEmpty2.test("oi"));
		
		
		Predicate<String> validateEmpty3 = valor -> {
			return valor.isEmpty();
		};
		System.out.println(validateEmpty3.test(""));
		System.out.println(validateEmpty3.test("oi"));		
	}

}
