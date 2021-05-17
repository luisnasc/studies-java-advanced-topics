package br.com.dio.lambda;

public class LambdaFunctionalInterface {

	public static void main(String[] args) {
		Funcao colocarPrefixo = nome -> "Sr. "+nome;
		
		System.out.println(colocarPrefixo.gerar("Luis"));

	}

}

@FunctionalInterface
interface Funcao {
	String gerar(String nome);
}