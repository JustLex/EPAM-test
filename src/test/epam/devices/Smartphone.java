package test.epam.devices;

public class Smartphone extends Device{
	private String model;

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public Smartphone() {
		super();
	}
	public Smartphone(int cost, int weight, String name, String model) {
		super(cost, weight, name);
		this.model = model;
	}
}
