package br.com.dio.lambda;

public class FuncaoAltaOrdem {

	public static void main(String[] args) {
		Calculo soma = (a, b) -> a+b;
		Calculo sub = (a, b) -> a-b;
		Calculo multi = (a, b) -> a*b;
		Calculo div = (a, b) -> a/b;
		
		System.out.println(executarOperacao(soma, 10, 20));
		System.out.println(executarOperacao(sub, 10, 20));
		System.out.println(executarOperacao(multi, 10, 20));
		System.out.println(executarOperacao(div, 10, 20));
	}
	public static int executarOperacao(Calculo calc, int a, int b) {
		return calc.calcular(a, b);
	}
}

interface Calculo {
	public int calcular(int a, int b);
}