import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CSYE 6200 Vehicle Registry
 * 
 * @author Zihan Zhang
 * ID: 001280965
 *
 */

public class VehicleRegistry implements Serializable{
	private ArrayList vehiclelist=new ArrayList();
	private HashMap<String,Vehicle>VcM= new HashMap<String,Vehicle>();
	Vehicle minivan = new Vehicle("minivan","Volkswagen","Routan",2009,7,80,8.14,"SUN226");
	Vehicle sportscar = new Vehicle("sportscar","Bugatti","Veyron",2013,2,100,3.40,"SUN111");
	VehicleRegistry(){
		vehiclelist.add(minivan);
		vehiclelist.add(sportscar);
		VcM.put("SUN226", minivan);
		VcM.put("SUN111", sportscar);
	}
	public void vehicleadd(Vehicle carname,String category,String make,String model,int modelYear,int passengers,int fuelCap,double kpl,String licenseplate){
		carname=new Vehicle(category,make,model,modelYear,passengers,fuelCap,kpl,licenseplate);
		vehiclelist.add(carname);
		VcM.put(licenseplate, carname);
	}
	public Vehicle vehicleget(int i){
		return (Vehicle) vehiclelist.get(i);
	}
	public void vehicleremove(Vehicle vc){
		vehiclelist.remove(vc);
		VcM.remove(vc.licenseplate);
	}
	public void display(){
		System.out.println("************************************");
		for(Object ob:vehiclelist){
			Vehicle vc=(Vehicle)ob;
			System.out.println("This is:"+vc.category);
			vc.display();
		}
		System.out.println("************************************");
	}
	public Vehicle vehicleretrieve(String lp){
		return VcM.get(lp);
	}
	public ArrayList getarraylist(){
		return vehiclelist;
	}
}