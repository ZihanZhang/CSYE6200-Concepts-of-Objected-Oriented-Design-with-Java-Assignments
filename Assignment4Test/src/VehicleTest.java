import java.io.IOException;

public class VehicleTest {
	public static void main(String[] args) throws IOException{
		VehicleRegistry VR=VehicleRegistry.getInstance();
		RegistryIO RIO=new RegistryIO();
		//TruckVehicle TVC=new TruckVehicle("Truck","Toyota","Tacoma",2017,2,80,7.6,"SUN666",1.8,1.9,5.6);
		//System.out.println("Display of TruckVehicle:\n");
		//TVC.display();
		//RIO.save(VR,"Vehicle_Registry.txt");
		//System.out.println("\nLoading file and print:\n");
		//RIO.load(VR, "Vehicle_Registry.txt");
		//savevehicle(VR.vehicleget(0),"Vehicle_Registry.txt");           test outputstream
		RIO.save(VR,"Vehicle_Registry.txt");
		RIO.load("Vehicle_Registry.txt");
	}
}
