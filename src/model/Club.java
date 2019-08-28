package model;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
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
	
	public ArrayList<Owner> loadOwnerWithPets(){
		
		ArrayList<Owner> ownersitos = new ArrayList<Owner>();
		File fl = new File("");
		
		try {
		FileReader fi = new FileReader(fl);
		BufferedReader br = new BufferedReader(fi);
		String br1 = br.readLine();
		
		while(br1 != null) {
			
			String[] b = br1.split(",");
			
			boolean salir = false;
			
			for(int i = 0; i < b.length && !salir;i++) {
				
				if(b[0] != owners.get(i).getIdOwner()) {
					
					if(b[7] != owners.get(i).getPets().get(i).getPetName()) {
						
						ownersitos.add(new Owner(b[0],b[1],b[2],b[3],b[4]));
						
						salir = true;
						
					}
					
				}
				
			}
		}
		br.close();
		
		} catch (FileNotFoundException e) {
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return ownersitos;
		
		
		
	}
	
	public void delatedOwner(String nombredelMka,String apellidoOwner) {
		
		for(int i = 0; i < owners.size();i++) {
			
			if((owners.get(i).getOwnerNames().equals(nombredelMka)) && (owners.get(i).getOwnerSecondNames().equals(apellidoOwner))){
				owners.remove(i);
			}
			
		}
		
	}
	
	public void delatedOwnerNumber(String idDelMka) {
		
		for(int i = 0; i < owners.size();i++) {
			
			if(owners.get(i).getIdOwner().equals(idDelMka)){
				owners.remove(i);
			}
			
		}
		
	}
	
	public void delatedPetWithName(String idOwner,String namePet){
		
		for(int i = 0; i < owners.size();i++) {
			
			if(owners.get(i).getIdOwner().equals(idOwner)) {
				
			}
			
		}
		
	}
	
	
}//finalDeLaClase
