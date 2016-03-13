package application;

import java.util.Scanner;

public class test {
	public static void main(String[] args)
	{
		System.out.println("Java try-catch test");
		Scanner scanner =new Scanner(System.in);
		int a=5;
		int b;
		System.out.println("Enter a number");
		try{
		b=scanner.nextInt();
		int c= a+b;
		System.out.println("the value of c is:"+c);
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
		int d=100;
		System.out.println("The value of d is:"+d);
		scanner.close();
		
	}
}
