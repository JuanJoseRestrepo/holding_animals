package model;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
	private long idClub;
	private String nameClub;
	private String creationDate;
	private String typeOfAnimals;
	
	public Club(long idClub,String nameClub,String creationDate,String typeOfAnimals) {
		this.idClub = idClub;
		this.nameClub = nameClub;
		this.creationDate = creationDate;
		this.typeOfAnimals = typeOfAnimals;
		
		owners = new ArrayList<Owner>();
	}
	
	public long getIdClub() {
		return idClub;
	}
	
	public void setIdClub(long idClub) {
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
	
	public String addOwners(long idOwner, String ownerNames, String ownerSecondNames,String typeOfAnimalsPrefer,String bornDay) {
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
		File fl = new File("Owners.txt");
		
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
	
	public void searchForTheOwner(long idClient, long idPet,String petName, String gender,String typeOfPet,String bornPetDay) {
		
		for (int i = 0; i < owners.size(); i++) {
			if(idClient == owners.get(i).getIdOwner()) {
				owners.get(i).addAnimals(idPet, petName, gender, typeOfPet, bornPetDay);
				owners.get(i).saveObjectsInFilePets();
			}
			
		}
		
	}
	
	
}//finalDeLaClase
