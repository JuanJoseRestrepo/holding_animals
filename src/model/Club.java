package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Club implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//relaciones
	private ArrayList<Owner> owners;
	
	//Atributos
	private String idClub;
	private String nameClub;
	private String creationDate;
	private String typeOfAnimals;
	
	public Club(String idClub,String nameClub,String creationDate,String typeOfAnimals) {
		this.idClub = idClub;
		this.nameClub = nameClub;
		this.creationDate = creationDate;
		this.typeOfAnimals = typeOfAnimals;
		
		owners = loadObjectsOwnerAndPets();
	}
	
	public String getIdClub() {
		return idClub;
	}
	
	public void setIdClub(String idClub) {
		this.idClub = idClub;
	}
	
	public String getNameClub() {
		return nameClub;
	}
	
	public void setNameClub(String nameClub) {
		this.nameClub = nameClub;
	}
	
	public String getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getTypeOfAnimals() {
		return typeOfAnimals;
	}
	
	public void setTypeOfAnimals(String typeOfAnimals) {
		this.typeOfAnimals = typeOfAnimals;
	}
	
	public ArrayList<Owner> getOwners(){
		return owners;
	}
	
	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}
	
	public String addOwners(String idOwner, String ownerNames, String ownerSecondNames,String typeOfAnimalsPrefer,String bornDay) {
		String msj = " ";
		
		boolean t = false;
		
		for(int i = 0; i < owners.size() && !t;i++) {
			if(idOwner != owners.get(i).getIdOwner()) {
			msj += "Se agrego el cliente";
			owners.add(new Owner(idOwner,ownerNames,ownerSecondNames,typeOfAnimalsPrefer,bornDay));
			t = true;
			}else {
				msj += "No se encontro ninguno distinto";
			}
		}
		return msj;
	}
	
	public void saveObjectsInFileOwners() {
		File fl = new File("Documents\\holding_animals\\archivos\\Owners.txt");
		
		try {
			FileOutputStream file = new FileOutputStream(fl);
			ObjectOutputStream ob = new ObjectOutputStream(file);
			
			for (int i = 0; i < owners.size(); i++) {
				
				ob.writeObject(owners);
			
			}
			ob.close();
		}catch(IOException e) {
			System.out.println("No se pudo leer");
		}
	}
	
	public ArrayList<Owner> loadObjectsOwnerAndPets() {
		File fl = new File("OwnerList.txt");
		ArrayList<Owner> ownersitos = new ArrayList<Owner>();
		
		if(fl.isFile()) {
		try {
			FileInputStream fr = new FileInputStream(fl);
			ObjectInputStream ob = new ObjectInputStream(fr);
			
			Owner owner = (Owner) ob.readObject();
			ownersitos.add(owner);
			ob.close();
		}catch(IOException e) {
			
			e.getCause();
			
		}catch(ClassNotFoundException e) {
			
			e.getCause();
			
		}
	}
		return ownersitos;
}
	
	public void searchForTheOwner(String idClient, String idPet,String petName, String gender,String typeOfPet,String bornPetDay) {
		
		for (int i = 0; i < owners.size(); i++) {
			if(idClient == owners.get(i).getIdOwner()) {
				owners.get(i).addAnimals(idPet, petName, gender, typeOfPet, bornPetDay);
				saveObjectsInFileOwners();
			}
			
		}
		
	}
	
	
}//finalDeLaClase
