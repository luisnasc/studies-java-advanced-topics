package br.com.dio.parallel;

import java.util.stream.IntStream;

public class ParallelStreamExample {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		IntStream.range(1,100000)
			.forEach(num -> fatorial(num)); // Serial
		long end = System.currentTimeMillis();
		System.out.println("Execution time: "+(end-start));
		
		// Parallel Streams
		start = System.currentTimeMillis();
		IntStream.range(1,1000000)
			.parallel()
			.forEach(num -> fatorial(num)); // Serial
		end = System.currentTimeMillis();
		System.out.println("Execution time: "+(end-start));		

	}
	
	public static long fatorial(long num) {
		long fat = 1;
		for (int i = 2; i<= num; i++) {
			fat*=i;
		}
		return fat;
	}

}
