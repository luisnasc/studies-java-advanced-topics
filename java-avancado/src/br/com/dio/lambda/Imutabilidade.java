package br.com.dio.lambda;

import java.util.function.UnaryOperator;

public class Imutabilidade {

	public static void main(String[] args) {
		int valor = 10;
		UnaryOperator<Integer> calculaPotencia2 = v -> v^2;
		
		System.out.println(calculaPotencia2.apply(valor));
		System.out.println(valor);

	}

}
