package test.epam.devices.service;

import java.util.ArrayList;

import test.epam.devices.model.Device;

public class Department {
	private int staff;
	private ArrayList<Device> equip;
	
	public Department(int staff, ArrayList<Device> equip) {
		super();
		this.staff = staff;
		this.equip = equip;
	}

	public int getStaff() {
		return staff;
	}

	public ArrayList<Device> getEquip() {
		return equip;
	}
}
