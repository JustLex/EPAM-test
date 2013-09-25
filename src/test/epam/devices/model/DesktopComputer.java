package test.epam.devices.model;

public class DesktopComputer extends Computer {
	private int hardDrive;

	public DesktopComputer(int cost, int weight, String name, int processorFrequency,
			int hardDrive) {
		super(cost, weight, name, processorFrequency);
		this.hardDrive = hardDrive;
	}
	
	public DesktopComputer() {
		super();
	}

	public int getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(int hardDrive) {
		this.hardDrive = hardDrive;
	}
}
