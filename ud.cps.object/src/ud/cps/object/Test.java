package ud.cps.object;


interface Vehicle
{
	void display();
}
class Car implements Vehicle
{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("I am a car");
	}
	
}
public class Test {
	static void showInfo(Vehicle v)
	{
		v.display();
	}
	static void main(String[] args)
	{
		Car car=new Car();
		car.display();
		showInfo(car);
		showInfo(new Vehicle(){

			@Override
			public void display() {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
