package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Owner implements Comparable<Owner>,Comparator<Owner>  {

	private ArrayList<Pet> pets;
	
	private String idOwner;
	private String ownerNames;
	private String ownerSecondNames;
	private String typeOfAnimalsPrefer;
	private String bornDay;
	
	public Owner(String idOwner,String ownerNames,String ownerSecondNames,String typeOfAnimalsPrefer,String bornDay) {
		this.idOwner = idOwner;
		this.ownerNames = ownerNames;
		this.ownerSecondNames = ownerSecondNames;
		this.typeOfAnimalsPrefer = typeOfAnimalsPrefer;
		this.bornDay = bornDay;
		
		pets = new ArrayList<Pet>();
		
	}
	
	public String getIdOwner() {
		return idOwner;
	}
	
	public void setIdOwner(String idOwner) {
		this.idOwner = idOwner;
	}
	
	public String getOwnerNames() {
		return ownerNames;
	}
	
	public void setOwnerNames(String ownerNames) {
		this.ownerNames = ownerNames;
	}
	
	public String getBornDay() {
		return bornDay;
	}
	
	public void setBornDay(String bornDay) {
		this.bornDay = bornDay;
	}
	
	public String getOwnerSecondNames() {
		return ownerSecondNames;
	}
	
	public void setOwnerSecondNames(String ownerSecondNames) {
		this.ownerSecondNames = ownerSecondNames;
	}
	
	public String getTypeOfAnimalsPrefer() {
		return typeOfAnimalsPrefer;
	}
	
	public void getTypeOfAnimalsPrefer(String typeOfAnimalsPrefer) {
		this.typeOfAnimalsPrefer = typeOfAnimalsPrefer;
	}
	
	public ArrayList<Pet> getPets(){
		return pets;
	}
	
	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
	
	public void addAnimals(String idPet,String petName, String gender,String typeOfPet,String bornPetDay) {
		
		for(int i = 0; i < pets.size();i++) {
			if(petName != pets.get(i).getPetName()) {
				pets.add(new Pet(idPet,petName,gender,typeOfPet,bornPetDay));
			}
		}
	}
	

	public String toString() {
	String msj = "";
	
	return msj;
	}

	@Override
	public int compare(Owner o1, Owner o2) {
		// TODO Auto-generated method stub
		return o1.getOwnerNames().compareTo(o2.getOwnerNames());
	}

	@Override
	public int compareTo(Owner o1) {
		// TODO Auto-generated method stub
		return idOwner.compareTo(o1.getIdOwner()) ;
	}
	
	public int compareToSecondNames(Owner o1, Owner o2) {
		
		return o1.getOwnerSecondNames().compareTo(o2.getOwnerSecondNames());
		
	}
	
	public int compareToTypeOfAnimalsPrefer(Owner o1) {
		
		return typeOfAnimalsPrefer.compareTo(o1.getTypeOfAnimalsPrefer());
		
	}
	
	public int compareToBornDay(Owner o1) {
		
		return 0;
		
	}

	
	
}