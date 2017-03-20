package edu.neu.csye6200.registry;

import java.io.IOException;
import java.util.Collections;

public class VehicleTest {
	public static void main(String[] args) throws IOException{
		VehicleRegistry VR=VehicleRegistry.getInstance();
		RegistryIO RIO=new RegistryIO();
		System.out.println("save Vehicle class:");
		RIO.save(VR, "Vehicle_Registry.txt");
		System.out.println("load Vehicle class:");
		RIO.load(VR, "Vehicle_Registry.txt");
		System.out.println("Before Sorting:");
		VR.display();
		VR.sort();
		System.out.println("After Sorting:");
		VR.display();
	}
}
