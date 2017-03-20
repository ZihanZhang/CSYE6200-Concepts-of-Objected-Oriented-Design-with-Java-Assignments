import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * CSYE 6200 Vehicle Registry
 * 
 * @author Zihan Zhang
 * ID: 001280965
 *
 */

public class VehicleRegistry implements Serializable{
	
	static Logger log=Logger.getLogger(VehicleRegistry.class.getName());
	private ArrayList vehiclelist=new ArrayList();
	private HashMap<String,Vehicle>VcM= new HashMap<String,Vehicle>();
	private static VehicleRegistry instance=null;
	
	private VehicleRegistry(){
		vehiclelist.add(minivan);
		vehiclelist.add(sportscar);
		vehiclelist.add(businesspurposecar);
		vehiclelist.add(SUV);
		vehiclelist.add(truck);
		vehiclelist.add(antiquecar);
		vehiclelist.add(musclecar);
		vehiclelist.add(motorcycle);
		vehiclelist.add(jet);
		vehiclelist.add(limousine);
		VcM.put("SUN226", minivan);
		VcM.put("SUN111", sportscar);
	}
	
	public static VehicleRegistry getInstance(){
		if(instance==null){
			instance=new VehicleRegistry();
		}
		return instance;
	}
	
	public static void setLogingProperties(Logger logger,Level level){
		FileHandler fh;
		try{
			fh=new FileHandler("VehicleRegistryLog.log",true);
			logger.addHandler(fh);
			fh.setFormatter(new SimpleFormatter());
		}catch(SecurityException s){
			logger.log(Level.SEVERE,"SecurityException",s);
		}catch(IOException e){
			logger.log(Level.SEVERE, "IOException", e);
		}
	}
	
	Vehicle minivan = new Vehicle("minivan","Volkswagen","Routan",2009,7,80,8.14,"SUN226");
	Vehicle sportscar = new Vehicle("sportscar","Bugatti","Veyron",2013,2,100,3.40,"SUN111");
	Vehicle businesspurposecar=new Vehicle("business purpose car","Volkswagen", "A4", 2017, 5, 90, 13.16, "SUN222");
	Vehicle SUV=new Vehicle("SUV","Dodge", "JOURNEY", 2013, 7, 78, 9.32, "SUN233");
	Vehicle truck=new Vehicle("truck","Toyota","Tacoma",2017,2,80,7.6,"SUN666");
	Vehicle antiquecar=new Vehicle("antiquecar","FORD","FAIRLANE VICTORIA",1956,4,70,8,"SUN123");
	Vehicle musclecar=new Vehicle("musclecar","Dodge","Charger",1973,5,75,8,"SUN678");
	Vehicle motorcycle=new Vehicle("motorcycle","Harley","FLHTKL",2017,2,17,10,"SUN333");
	Vehicle jet=new Vehicle("jet","Amjet","Gulfstream G650",2016,20,10000,0.2,"SUN777");
	Vehicle limousine=new Vehicle("limousine","Cadillac","Escalade",2016,8,85,11,"SUN902");
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