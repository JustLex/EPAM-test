package devices;

public class DesktopComputer extends Computer {
	private int hardDrive;

	public DesktopComputer(int cost, int weight, int processorFrequency,
			int hardDrive) {
		super(cost, weight, processorFrequency);
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
