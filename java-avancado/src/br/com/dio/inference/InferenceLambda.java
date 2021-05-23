package br.com.dio.inference;

import java.util.function.Function;

public class InferenceLambda {

	public static void main(String[] args) {
		Function<Integer, Integer> dobro = (var num) -> num*2;
		
		System.out.println(dobro.apply(5));

	}

}
