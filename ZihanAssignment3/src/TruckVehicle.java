/**
 * CSYE 6200 TruckVehicle class
 * 
 * @author Zihan Zhang
 * ID: 001280965
 *
 */

public class TruckVehicle extends Vehicle{
	private double height,width,length;//The unit of measure is meter
	TruckVehicle(String category, String make, String model, int modelYear, int passengers, int fuelCap, double kpl,
			String licenseplate,double height,double width,double length) {
		super(category, make, model, modelYear, passengers, fuelCap, kpl, licenseplate);
		this.height=height;
		this.width=width;
		this.length=length;
	}
	public double calcargoarea(){
		return height*width*length;
	}
	public void display(){
		super.display();
		System.out.println("height:"+height+"m");
		System.out.println("Width:"+width+"m");
		System.out.println("length:"+length+"m");
		System.out.println("Cargo Area:"+calcargoarea()+"m*m*m");
		System.out.println("");
	}
}
