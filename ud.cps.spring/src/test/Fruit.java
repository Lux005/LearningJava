package test;

public class Fruit {
	private String type;
	private float weight;
	public Fruit()
	{
		
	}
	public Fruit(String _type, float _weight)
	{
		type=_type;
		weight=_weight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}


}
