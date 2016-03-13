package ud.cps.project1;
import java.util.Scanner;
import ud.cps.math.*;
public class test {
	private static Scanner s;
	static mult mul= new mult();
	static animal ani=new animal();
	public static  void  main( String[] argv)
	{
		s = new Scanner(System.in);
		System.out.println("Please enter number:");
		int a=s.nextInt();
		int b;
		switch(a)
		{
		case 1:
			b=2;
			break;
		case 2:
			b=4;
			break;
		case 3:
			b=6;
			break;
		default:
			b=0;
			break;
		}
		
		showinfo();
		System.out.println("Your number is "+b+" !");
	}
	static void showinfo()
	{
		ani.getname();
		ani.getage();
		ani.getweight();
	}
}

abstract class vechicle{
	void display()
	{
		
	}
	abstract void run();
}


class car extends vechicle
{
	void run()
	{
		
	}
	void display()
	{
		
	}
	void display(int x)
	{
		
	}
}
