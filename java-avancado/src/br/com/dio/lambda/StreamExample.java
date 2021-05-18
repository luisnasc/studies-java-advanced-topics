package br.com.dio.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		String[] months = {
				"January", "February", "March", "April", 
				"May", "June", "July", "August", "September",
				"Octuber", "November", "December"};
		
		// Months name started with 'J' 
		String meses = Stream.of(months)
				.filter(month -> month.contains("J"))
				.collect(Collectors. joining());
		System.out.println(meses);
		
		
		// Print all months
		Stream.of(months).forEach(mes -> System.out.print(mes+" "));
		System.out.println("");
		Stream.of(months).forEach(System.out::println);
		
		
		// Upper case all months
		Stream.of(months)
			.map(mes -> mes.toUpperCase())
			.forEach(mes -> System.out.println(mes));
		
		System.out.println("---------Cleaner------");
		// This is amazing!!! :D
		Stream.of(months)
			.map(String::toUpperCase)
			.forEach(System.out::println);
		
		System.out.println("---------Using List------");
		List.of(months).forEach(System.out::println);
		
		
	}

}
