package application;

public class test {


	
	public static void main(String[] args)
	{ 
	
		for(int i = 100000000; i < 100001000; i++)
		{
			
			Thread t=new Thread(new PrimeChecker(i));
			t.start();
		}
		
	}
}
