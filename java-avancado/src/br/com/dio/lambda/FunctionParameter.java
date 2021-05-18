package br.com.dio.lambda;

import java.util.function.Function;

public class FunctionParameter {

	public static void main(String[] args) {
		Function<String, String> getReversedString = str -> new StringBuilder(str).reverse().toString();
		
		Function<Double, Double> computeSquareRoot = Math::sqrt;
		
		
		
		System.out.println(getReversedString.apply("String original"));
		System.out.println(computeSquareRoot.apply(225.0));

	}

}
