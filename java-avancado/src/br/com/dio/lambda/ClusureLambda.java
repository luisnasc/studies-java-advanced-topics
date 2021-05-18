package br.com.dio.lambda;

public class ClusureLambda {

	public static void main(String[] args) {
		// Example: Get month by number
		MonthByNumber obj = new MonthByNumber() {
			
			String[] months = {
					"January", "February", "March", "April", 
					"May", "June", "July", "August", "September",
					"Octuber", "November", "December"};
			
			@Override
			public String getMonth(int num) {
				// TODO Auto-generated method stub
				return (num>0 && num<=12)? months[num-1] : null;
			}
		};
		
		System.out.println(obj.getMonth(1));
	}

}

interface MonthByNumber {
	public String getMonth(int num);
}
