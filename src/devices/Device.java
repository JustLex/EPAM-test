package devices;

public abstract class Device{
	protected int cost;
	protected int weight;
	
	public Device(int cost, int weight) {
		super();
		this.cost = cost;
		this.weight = weight;
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
}
