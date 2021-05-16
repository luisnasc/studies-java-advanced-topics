package br.com.dio.lambda;

import java.util.Arrays;
import java.util.Iterator;

public class ExemploFucional {

	public static void main(String[] args) {
		int[] valores = {1,2,3,4,5,6};
		
		// Paradigma Funcional
		Arrays.stream(valores)
			.filter(numero -> numero % 2==0)
			.map(numero -> numero * 2)
			.forEach(numero -> System.out.print(numero + " "));
		
		System.out.println("");
		//Paradigma imperativo
		for (int i = 0; i < valores.length; i++) {
			if(valores[i] % 2 == 0) {
				System.out.print(valores[i]*2 + " ");
			}
		}
		

	}

}
