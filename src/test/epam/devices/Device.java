package test.epam.devices;

public abstract class Device{
	protected int cost;
	protected int weight;
	protected String name;
	
	public Device(int cost, int weight, String name) {
		super();
		this.cost = cost;
		this.weight = weight;
		this.name = name;
	}
	public Device() {
		super();
	}
	public int getCost() {
		return cost;
	}
	public int getWeight() {
		return weight;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
