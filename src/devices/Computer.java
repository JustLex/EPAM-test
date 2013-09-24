package devices;

public abstract class Computer extends Device {
	protected int processorFrequency;

	public Computer(int cost, int weight, int processorFrequency) {
		super(cost, weight);
		this.processorFrequency = processorFrequency;
	}

	public Computer() {
		super();
	}

	public int getProcessorFrequency() {
		return processorFrequency;
	}
	
	public void setProcessorFrequency(int processorFrequency) {
		this.processorFrequency = processorFrequency;
	}
}
