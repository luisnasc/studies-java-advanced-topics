package br.com.dio.string;

import java.util.stream.Collectors;

public class StringJava11 {

	public static void main(String[] args) {
		// Exemplo string vazia
		String str = " ";		
		// Antes Java 11
		System.out.println(stringVazia(str));
		// Java 11
		System.out.println(str.isBlank());
		
		
		// Exmplo lines
		String nomes = "Tiririca Filho do Coronel...\nPedro Thiago João no Barquinho\nAna Maria Braga\nJosé da Silva Xavier\nAna Paula Padrão\nJoão Pessoa";
		//Pegar nomes iniciados com 'Ana'
		System.out.println(nomes.lines().filter(s -> s.contains("Ana")).collect(Collectors.toList()));
		
		//Repetindo strings
		System.out.println("ha".repeat(6)+'!');
	}
	
	// string vazia - ANTES
	private static boolean stringVazia(String str) {
		return str == null || str.length()==0 || str.chars().allMatch(c->c==' ');
	}

}
