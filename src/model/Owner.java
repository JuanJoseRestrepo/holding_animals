package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Owner {

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
	
public ArrayList<Pet> loadOwner(){
		
		ArrayList<Pet> ownersitos = new ArrayList<Pet>();
		File fl = new File("");
		
		try {
		FileReader fi = new FileReader(fl);
		BufferedReader br = new BufferedReader(fi);
		
		
		while(br.readLine() != null) {
			
			String br1 = br.readLine();
			
			String[] b = br1.split(",");
			ownersitos.add(new Pet(b[0],b[1],b[2],b[3],b[4]));
			
		}
		br.close();
		
		} catch (FileNotFoundException e) {
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return ownersitos;
		
		
		
	}

public void readPetInTheText() {
	
	File fl = new File("");
	
	try {
		FileReader fr = new FileReader(fl);
		BufferedReader br = new BufferedReader(fr);
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
	
	
}