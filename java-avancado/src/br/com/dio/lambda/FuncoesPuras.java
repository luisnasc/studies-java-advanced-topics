package br.com.dio.lambda;

import java.util.function.BiPredicate;

public class FuncoesPuras {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> verificaIgual = 
				(parametro, valorComparado) -> parametro == valorComparado;
		
		System.out.println(verificaIgual.test(2, 2));
		System.out.println(verificaIgual.test(20, 2));

	}

}
