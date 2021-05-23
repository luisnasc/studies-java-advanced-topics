package br.com.dio.inference;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;


public class InferenceExample {

	public static void main(String[] args) throws IOException {
		System.out.println(somar(5, 5));
		System.out.println(somar(5,6,4));
		System.out.println(somar(5,6,4, 10, 15, 3, 5));
		
	}

	
	private static int somar(int... numeros) {
		var soma = 0;
		for (var i : numeros) {
			soma+=i;
		}
		return soma;
	}
	
	
	// Pegar o html de uma página
	// variáveis usando var
	private static void getHTML() throws MalformedURLException, IOException {
		var url = new URL("https://portal.ifrn.edu.br/");
		var urlConnection = url.openConnection();
		var bufferedReader = new BufferedReader(
				new InputStreamReader(urlConnection.getInputStream()));

		System.out.println(
				bufferedReader.lines().collect(Collectors.joining())
				.replaceAll(">", "\n")
				);
	}

}
