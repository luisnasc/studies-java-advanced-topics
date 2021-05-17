package br.com.dio.lambda;

import java.util.function.Consumer;

public class Consumidores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer<String> printHello = System.out::println;
		printHello.accept("Heloooo!!!");
		
		Consumer<String> printWord = word -> System.out.println(word);
		printWord.accept("Hello World!!!");
	}

}
