package ud.cps.project1;

import ud.cps.math.mult;

public class animal {
	int age=5;
	String name="kitty";
	float weight=1.0f;
	static mult xasx=new mult();
	void getname()
	{
		System.out.println("My name is "+name);
	}
	void getage()
	{
		System.out.println("My age is "+age);
	}
	void getweight()
	{
		System.out.println("My weight is "+weight);
	}
}

class cat extends animal{
	void getage()
	{
		
	}
	void getname()
	{
		
	}
	
}


