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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Club implements Serializable, Comparable<Club>,Comparator<Club> {

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
	private ordenarPorFecha fechas;
	
	/**
	 * 
	 */
	public Club(String idClub,String nameClub,String creationDate,String typeOfAnimals) {
		this.idClub = idClub;
		this.nameClub = nameClub;
		this.creationDate = creationDate;
		this.typeOfAnimals = typeOfAnimals;
		owners = loadObjectsOwnerAndPets();
	
	}
	
	/**
	 * 
	 */
	public String getIdClub() {
		return idClub;
	}
	
	/**
	 * 
	 */
	public void setIdClub(String idClub) {
		this.idClub = idClub;
	}
	
	/**
	 * 
	 */
	public String getNameClub() {
		return nameClub;
	}
	
	/**
	 * 
	 */
	public void setNameClub(String nameClub) {
		this.nameClub = nameClub;
	}
	
	/**
	 * 
	 */
	public String getCreationDate() {
		return creationDate;
	}
	
	/**
	 * 
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	 * 
	 */
	public String getTypeOfAnimals() {
		return typeOfAnimals;
	}
	
	/**
	 * 
	 */
	public void setTypeOfAnimals(String typeOfAnimals) {
		this.typeOfAnimals = typeOfAnimals;
	}
	
	/**
	 * 
	 */
	public ArrayList<Owner> getOwners(){
		return owners;
	}
	
	/**
	 * 
	 */
	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}
	
	/**
	 * 
	 */
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
	
	/**
	 * 
	 */
	public void saveObjectsInFileOwners() {
		File fl = new File("Owners.txt");
		
		try {
			FileOutputStream file = new FileOutputStream(fl.getAbsoluteFile());
			ObjectOutputStream ob = new ObjectOutputStream(file);
			
			for (int i = 0; i < owners.size(); i++) {
				
				ob.writeObject(owners);
			
			}
			ob.close();
		}catch(IOException e) {
			System.out.println("No se pudo leer");
		}
	}
	
	/**
	 * 
	 */
	public ArrayList<Owner> loadObjectsOwnerAndPets() {
		File fl = new File("OwnerList.txt");
		
		if(!fl.isFile()) {
			owners = new ArrayList<Owner>();
		}else {
			try {
				FileInputStream fr = new FileInputStream(fl.getAbsoluteFile());
				ObjectInputStream ob = new ObjectInputStream(fr);
				owners = (ArrayList<Owner>) ob.readObject();
				ob.close(); 
			}catch(IOException e) {
				
				e.getCause();
				
			}catch(ClassNotFoundException e) {
				
				e.getCause();
				
			}
		}
		return owners;
}
	
	/**
	 * 
	 */
	public void searchForTheOwner(String idClient, String idPet,String petName, String gender,String typeOfPet,String bornPetDay) {
		
		for (int i = 0; i < owners.size(); i++) {
			if(idClient == owners.get(i).getIdOwner()) {
				owners.get(i).addAnimals(idPet, petName, gender, typeOfPet, bornPetDay);
				saveObjectsInFileOwners();
			}
			
		}
		
	}
	
	/**
	 * 
	 */
	public void delatedOwner(String nombredelMka,String apellidoOwner) {
		
		for(int i = 0; i < owners.size();i++) {
			
			if((owners.get(i).getOwnerNames().equals(nombredelMka)) && (owners.get(i).getOwnerSecondNames().equals(apellidoOwner))){
				owners.remove(i);
			}
			
		}
		
	}
	
	/**
	 * 
	 */
	public void delatedOwnerNumber(String idDelMka) {
		
		for(int i = 0; i < owners.size();i++) {
			
			if(owners.get(i).getIdOwner().equals(idDelMka)){
				owners.remove(i);
			}
			
		}
		
	}
	
	/** 
	 * 
	 */
	public void delatedPetWithName(String idOwner,String namePet){
		
		for(int i = 0; i < owners.size();i++) {
			
			if(owners.get(i).getIdOwner().equals(idOwner)) {
				
			}
			
		}
		
	}
	
	/**
	 * 
	 */
	public String toString() {
		String msj = "";
		
		msj+= "El id es: " + " " + idClub + " ";
		msj+= "El nombre del club es: " + " " + nameClub+ " ";
		msj+= "La fecha de creacion es: " + " " + creationDate+ " ";
		msj+= "El tipo de animal preferido es: " + " " + typeOfAnimals+ " ";
		
	
		return msj;
	}

	
	/**
	 * 
	 */
	@Override
	public int compareTo(Club club) {
		
		return idClub.compareTo(club.getIdClub());
		
	}

	@Override
	public int compare(Club o1, Club o2) {
		
		return o1.getNameClub().compareTo(o2.getNameClub());
	}
	
	public int compareOrdenarPorFecha(Club o1) {
		
		return formatTheDateOfThis(creationDate).compareTo(formatTheDateOfThis(o1.getCreationDate()));
		
	}
	
	public int compareTypeOfAnimals(Club o1) {
		
		return typeOfAnimals.compareTo(o1.getTypeOfAnimals());
	}
	
	public Date formatTheDateOfThis(String dateOfThis) {
		Date inicialDate = null;
		SimpleDateFormat dateOfThis1 = new SimpleDateFormat("yyyy-mm-dd");
		
		try {
			inicialDate = dateOfThis1.parse(dateOfThis);
		}catch(ParseException e) {
			e.getCause();
		}
		
		
		return inicialDate;
	}
	
			
}//finalDeLaClase
