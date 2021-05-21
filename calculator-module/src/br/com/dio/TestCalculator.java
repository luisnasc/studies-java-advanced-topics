package br.com.dio;

import br.com.dio.operation.Calculator;

public class TestCalculator {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		System.out.println(calc.sum(2, 54));		
		System.out.println(calc.multi(5, 5));
		System.out.println(calc.div(5, 0));
		System.out.println(calc.div(5, 2));
		System.out.println(calc.sub(2021, 1980));

	}

}
