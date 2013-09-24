package test.epam.devices;

public class TabletComputer extends Computer {
	protected String resolution;
	
	public TabletComputer(int cost, int weight, String name, int processorFrequency,
			String resolution) {
		super(cost, weight, name, processorFrequency);
		this.resolution = resolution;
	}
	
	public TabletComputer() {
		super();
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
}
