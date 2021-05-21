package br.com.dio.operation;

import br.com.dio.operation.internal.DivisionHelper;
import br.com.dio.operation.internal.MultiplicationHelper;
import br.com.dio.operation.internal.SubtractionHelper;
import br.com.dio.operation.internal.SumHelper;

public class Calculator {
	
	private SumHelper sumHelper;
	private SubtractionHelper subHelper;
	private MultiplicationHelper multHelper;
	private DivisionHelper divHelper;
	
	public Calculator() {
		sumHelper = new SumHelper();
		subHelper = new SubtractionHelper();
		multHelper = new MultiplicationHelper();
		divHelper = new DivisionHelper();
	}
	
	public int sum(int a, int b) {
		return sumHelper.compute(a, b);
	}
	
	public int sub(int a, int b) {
		return subHelper.compute(a, b);
	}	
	
	public int multi(int a, int b) {
		return multHelper.compute(a, b);
	}	

	public int div(int a, int b) {
		return divHelper.compute(a, b);
	}	
}
