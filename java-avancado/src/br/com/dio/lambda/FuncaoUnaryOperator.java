package br.com.dio.lambda;

import java.util.function.UnaryOperator;

public class FuncaoUnaryOperator {

	public static void main(String[] args) {
		UnaryOperator<Integer> calculaValorVezesTres = valor -> valor*3;
		
			
		System.out.println("O triplo é: "+ calculaValorVezesTres.apply(100));

	}

}
