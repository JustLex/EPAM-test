package test.epam.devices;

import test.epam.devices.service.Equip;

public class Run {
	/**
	 * @param args first argument is a path to input xml
	 */
	public static void main(String[] args) {
		new Equip(args[0]).equip();
	}
}
