package edu.neu.csye6200.registry;
/**
 * CSYE 6200 RegistryIO class
 * 
 * @author Zihan Zhang
 * ID: 001280965
 *
 */
 import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//updated 10/15 using OutputStreamWriter instead of filewriter
/*updated 10/16:
Cannot use OutputStreamWriter!!! Writer and Reader is used to convert 
between char stream and byte stream, not for this!!!!!
Object Serialization is based on bytes, DO NOT TRY TO USE WRITER and READER!!!!
*/



//import edu.neu.csye6200.registry.Vehicle;

public class RegistryIO implements Serializable{
	static Logger rlog=Logger.getLogger(VehicleRegistry.class.getName());
	public RegistryIO(){
		setLogingProperties(rlog,Level.SEVERE);
		rlog.info("RegistryIO Constructor Called");
	}
	
	public static void setLogingProperties(Logger logger,Level level){
		FileHandler fh;
		try{
			fh=new FileHandler("RegistryIOLog.log",true);
			logger.addHandler(fh);
			fh.setFormatter(new SimpleFormatter());
		}catch(SecurityException s){
			logger.log(Level.SEVERE,"SecurityException",s);
		}catch(IOException e){
			logger.log(Level.SEVERE, "IOException", e);
		}
	}
	
	public void load(VehicleRegistry VR,String filename){
		rlog.info("load method called");
		try{
			FileInputStream fileIn=new FileInputStream(filename);
			ObjectInputStream in=new ObjectInputStream(fileIn);
			VR=(VehicleRegistry) in.readObject();
			//vr.display();                      //input Vehicle problem test
			//String s=vr.toString();            // input Vehicle problem test
			//System.out.println(s);             // input Vehicle problem test
			/*ArrayList AL=VR.getarraylist();
			for(Object ob:AL){
				Vehicle VC=(Vehicle)ob;
				VC.display();
			}*/
			//VR.display();                   Don't need to display in Assignment4
			in.close();
			fileIn.close();
		}catch(IOException e){
			Logger.getLogger(RegistryIO.class.getName()).log(Level.SEVERE, "load IOException", e);
		}catch(ClassNotFoundException c){
			Logger.getLogger(RegistryIO.class.getName()).log(Level.SEVERE, "Class Not Found Exception", c);
		}
		//File f=new File(filename);
		/*try{
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			try{
				String l=br.readLine();
					while(l!=null){
						System.out.println(l);
						l=br.readLine();
					}
			}catch(IOException e){
				e.printStackTrace();
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		*/	
	}
	public void save(VehicleRegistry VR,String filename){
		rlog.info("save method called");
		
		try{
			//OutputStreamWriter pw=null;
			FileOutputStream fileOut=new FileOutputStream(filename);
			//pw=new OutputStreamWriter(fileOut);
			ObjectOutputStream outStream=new ObjectOutputStream(fileOut);
			outStream.writeObject(VR);
			/*ArrayList AL=VR.getarraylist();
			for(Object ob:AL){
				Vehicle VC=(Vehicle)ob;
				//savevehicle(VC,filename);
				outStream.writeObject(VC);
			}*/
			//pw.close();
			fileOut.close();
			outStream.close();
		}catch(IOException e){
			Logger.getLogger(RegistryIO.class.getName()).log(Level.SEVERE, "save IOException", e);
		}
	}
	private void savevehicle(Vehicle VC,String filename) throws FileNotFoundException{
		OutputStreamWriter pw=null;
		//FileWriter fw;
		try{
			//fw=new FileWriter(filename,true);
			//fw.write("********************************\n");
			//fw.write("Car manufacturer:"+VC.make+"\n");
			//fw.write("Model:"+VC.model+"\n");
			//fw.write("Passengers:"+VC.passengers+"person"+"\n");
			//fw.write("Fuel Cap:"+VC.fuelCap+"L"+"\n");
			//fw.write("Kpl:"+VC.kpl+"km"+"\n");
			//fw.write("License Plate:"+VC.licenseplate+"\n");
			//fw.write("Range:"+VC.range()+"km"+"\n");
			//fw.write("********************************\n");
			//fw.close();
			FileOutputStream fileOut=new FileOutputStream(filename,true);
			pw=new OutputStreamWriter(fileOut);
			ObjectOutputStream outStream=new ObjectOutputStream(fileOut);
			outStream.writeObject(VC);
			pw.write("********************************\n");
			pw.write("Car manufacturer:"+VC.make+"\n");
			pw.write("Model:"+VC.model+"\n");
			pw.write("Passengers:"+VC.passengers+"person"+"\n");
			pw.write("Fuel Cap:"+VC.fuelCap+"L"+"\n");
			pw.write("Kpl:"+VC.kpl+"km"+"\n");
			pw.write("License Plate:"+VC.licenseplate+"\n");
			pw.write("Range:"+VC.range()+"km"+"\n");
			pw.write("********************************\n");
			pw.close();
			fileOut.close();
			outStream.close();
		}catch(IOException ex){
			Logger.getLogger(RegistryIO.class.getName()).log(Level.SEVERE, "savevehicle IOException", ex);
		}
	}
	/*public static void main(String[] args) throws IOException{
		VehicleRegistry VR=new VehicleRegistry();
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
	}*/                                               //main method should not be uesd here in Assignment4
}
