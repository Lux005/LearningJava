package application;

public class PrimeChecker  implements Runnable{

	private int number;
	
	PrimeChecker(int n)
	{
		number = n;
	}
	public void run()
	{
		isPrime();
	}
	public void isPrime()
	{
		boolean result = true;
		for(int i=2; i<number; i++){
	           
			if(number % i == 0){
	        
				result = false;
				break;
			}
	     }
		if(result)
			System.out.println(" "+number + " is a prime number!");
			
	     
		
	}
}
