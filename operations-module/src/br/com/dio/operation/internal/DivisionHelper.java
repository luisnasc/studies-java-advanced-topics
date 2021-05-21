package br.com.dio.operation.internal;

public class DivisionHelper implements Operation{

	@Override
	public int compute(int a, int b) {		
		return (b!=0)?(a/b):0;
	}

}
