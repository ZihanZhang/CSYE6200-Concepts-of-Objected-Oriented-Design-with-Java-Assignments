/**
 * CSYE 6200 Vehicle starter class
 * 
 * @author Zihan Zhang
 * ID: 001280965
 *
 */

package edu.neu.csye6200.registry;

import java.io.Serializable;

public class Vehicle implements Serializable{
   String category;
   int passengers;
   int fuelCap;
   String make;
   String model;
   int modelYear;
   String licenseplate;
   public Vehicle(String category,String make,String model,int modelYear,int passengers,int fuelCap,double kpl,String licenseplate){
	   this.category=category;
	   this.make=make;
	   this.model=model;
	   this.passengers=passengers;
	   this.fuelCap=fuelCap;
	   this.kpl=kpl;
	   this.licenseplate=licenseplate;
   }
   double range(){
	  return fuelCap*kpl; 
   }
   void display(){
	   System.out.println("Car manufacturer:"+make);
	   System.out.println("Model:"+model);
	   System.out.println("Passengers:"+passengers+"person");
	   System.out.println("Fuel Cap:"+fuelCap+"L");
	   System.out.println("Kpl:"+kpl+"km");
	   System.out.println("License Plate:"+licenseplate);
	   System.out.println("Range:"+range()+"km");
   }
   double kpl; 
   }