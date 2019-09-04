package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;


public class Holding implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Club> clubs;
	private String archives;
	public Holding(String archives) {
		this.archives = archives;
		clubs = loadFileMocaForClub();
		loadOwner();
		loadPet();
	}
	
	public void findClubWithClubAndOwnerAndPet(String idClubs,String idClien,String idPet,String petName, String gender,String typeOfPet,String bornPetDay){
		for(int i = 0; i < clubs.size();i++) {
			if(idClubs == clubs.get(i).getIdClub()) {
				clubs.get(i).searchForTheOwner(idClubs,idPet, petName, gender, typeOfPet, bornPetDay);
			}
		}
	}
	
	public String findClubForOwner(String idClub, String idOwner,String ownerNames, String ownerSecondNames,String typeOfAnimalsPrefer,String bornDay) {
		String msj = "";
		
		for (int i = 0; i < clubs.size(); i++) {
			if(idClub == clubs.get(i).getIdClub()) {
				msj += "Se encontro el club y se agrego";
				clubs.get(i).addOwners(idOwner,ownerNames,ownerSecondNames,typeOfAnimalsPrefer,bornDay);
				clubs.get(i).saveObjectsInFileOwners();
			}	
		}
		
		return msj;
	}
	
	public void registerClubInTheSystem(String idClub,String nameClub,String creationDate,String typeOfAnimals) {
		
		clubs.add(new Club(idClub,nameClub,creationDate,typeOfAnimals));
	
}
		
	public void saveClub() {
		File fl = new File(archives);
		
		try {
			FileWriter fw = new FileWriter(fl.getAbsoluteFile());
			BufferedWriter bfw = new BufferedWriter(fw);
			
			for(int i = 0; i < clubs.size();i++) {
	
				bfw.write(clubs.get(i).getIdClub() + "," + clubs.get(i).getNameClub()
				+ "," + clubs.get(i).getCreationDate() + "," + clubs.get(i).getTypeOfAnimals());
				bfw.newLine();	
			}
			bfw.close();
			
			
		}catch(IOException e) {
			System.out.println("Problema de esritura en el archivo");
		}
		
		
	}
	
	public void delatedClubWithNumber(String id) {
		
		boolean t = false;
		
		for(int i = 0; i < clubs.size() && !t;i++) {
			if(clubs.get(i).getIdClub().equals(id)) {
				clubs.remove(i);
				t = true;
			}	
		}	
	}
	
	
	public void delatedClubWithName(String name) {
		
		boolean t = false;
		
		for(int i = 0; i < clubs.size() && !t;i++) {
			if(clubs.get(i).getNameClub().equals(name)) {
				clubs.remove(i);
				t = true;
			}	
		}	
	}
	
	public void delatedWithClubOwner(String idClubsi, String nombreOwner,String apellidoParaco) {
		
		for(int i = 0; i < clubs.size();i++) {
			if(clubs.get(i).getIdClub().equals(idClubsi)) {
				clubs.get(i).delatedOwner(nombreOwner,apellidoParaco);
			}	
		}		
	}
	
	public void delatedWithClubOwnerNumber(String idClubsi, String idOwner) {
		
		for(int i = 0; i < clubs.size();i++) {
			if(clubs.get(i).getIdClub().equals(idClubsi)) {
				clubs.get(i).delatedOwnerNumber(idOwner);
			}	
		}		
	}
	
	public void delatedWithClubWithOwner(String idClubsi, String idOwner,String namePet) {
		
		for(int i = 0; i < clubs.size();i++) {
			if(clubs.get(i).getIdClub().equals(idClubsi)) {
				
			}
		}
		
	}
	
	public ArrayList<Club> loadFileMocaForClub() {
		
		ArrayList<Club> clubsitos = new ArrayList<Club>();
		File fl = new File(archives);
		
		try {
		FileReader fr = new FileReader(fl);
		BufferedReader br = new BufferedReader(fr);
		
		String a;
		while((a =br.readLine()) != null){
			String[] b = a.split(",");
			clubsitos.add(new Club(b[0], b[1], b[2], b[3]));
			
		}
		br.close();
		
		}catch(IOException e) {
			e.getCause();
		}
		
		return clubsitos;
		
	}
	
		
	public String toString() {
		String msj = "";
		
		return msj;
	}
		
	
	
	public void ordenarClubesPorId() {
		
		
		for(int i = 1; i < clubs.size();i++) {
			
			for(int j = i; j > 0 && clubs.get(j-1).compareTo(clubs.get(j)) > 0; j--) {
				Club temp = clubs.get(j);
				clubs.set(j,clubs.get(j-1));
				clubs.set(j-1,temp);
			}
				
		}
		
	}
	
	public void ordenarClubesPorNombre() {
		
		for (int i = 0; i < clubs.size(); i++) {
			Club menor = clubs.get(i);
			int posicion = i;
			
			for(int j = i + 1; j < clubs.size();j++) {
				
				if(clubs.get(j).compare(menor,clubs.get(j)) > 0) {
					
					menor = clubs.get(j);
					posicion = j;
					
				}
				
				
			}
			
			Club temp = clubs.get(i);
			clubs.set(i,menor);
			clubs.set(posicion,temp);
			
		}
		
		
	}
	
	public String mostrarInfoOrdenado() {
		String msj = "";
		
		for(int i = 0; i < clubs.size();i++) {
			msj+= "\n " + clubs.get(i).toString();
		}
		
		return msj;
	}
	
	public void ordenarFechas() {
		
		for(int i = 0; i < clubs.size();i++) {
			
			for(int j = 0; j < clubs.size() -1;j++) {
				
				if(clubs.get(j).compareOrdenarPorFecha(clubs.get(j+1)) > 0) {
					Club temp = clubs.get(j);
					clubs.set(j, clubs.get(j+1));
					clubs.set(j+1, temp);	
				}
			}
			
		}
		
	}
	
public void loadPet(){
		int x = (int) ((Math.random() *9) + 1);
		ArrayList<Pet> pets = new ArrayList<Pet>();
		File fl = new File("");
		
		try {
		FileReader fi = new FileReader(fl.getAbsoluteFile());
		BufferedReader br = new BufferedReader(fi);
		while(br.readLine() != null) {
			String br1 = br.readLine();
			String[] b = br1.split(",");
			pets.add(new Pet(b[0],b[1],b[2],b[3],b[4]));
		}
		br.close();
		
		} catch (FileNotFoundException e) {
			
			e.getCause();
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int j = 0;
		
		for(Club miClub:clubs){
			for(Owner owner: miClub.getOwners()) {
				for(int i = 0; i < x;i++) {
					owner.addAnimals(pets.get(j).getIdPet(),pets.get(j).getPetName(),pets.get(j).getGender(),pets.get(j).getTypeOfPet(),pets.get(j).getBornPetDay());
					j++;
				}
				
			}
		}
			
	}

public void loadOwner(){
	
	
	ArrayList<Owner> ownersitos = new ArrayList<Owner>();
	File fl = new File("Ownersitos.csv");
	
	try {
	FileReader fi = new FileReader(fl.getAbsoluteFile());
	BufferedReader br = new BufferedReader(fi);
	while(br.readLine() != null) {	
		String br1 = br.readLine();
		String[] b = br1.split(",");
		ownersitos.add(new Owner(b[0],b[1],b[2],b[3],b[4]));
	}
	br.close();
	
	} catch (FileNotFoundException e) {

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int j = 0;
	for(Club miClub:clubs){
		for(int k = 0; k < 10000;k++) {
			miClub.addOwners(ownersitos.get(j).getIdOwner(),ownersitos.get(j).getOwnerNames(),ownersitos.get(j).getOwnerSecondNames(),ownersitos.get(j).getTypeOfAnimalsPrefer(),ownersitos.get(j).getBornDay());
			j++;
		}	
	}
}

public void ordenateTypeOfAnimals() {
	for(int i = 0; i < clubs.size();i++) {
		for(int j = 0; j < clubs.size()-1-i;j++){
			if(clubs.get(j).compareTypeOfAnimals(clubs.get(j+1))> 0) {
				Club temp = clubs.get(j);
				clubs.set(j,clubs.get(j+1));
				clubs.set(j+1,temp);
			}	
		}	
	}	
}

public void getMethodsSortWithTypeOfAnimals(String idClub) {
	
	for (int i = 0; i < clubs.size(); i++) {
		if(clubs.get(i).getIdClub().equals(idClub)) {
			ordenateTypeOfAnimals();
		}
	}
	
}

public String getMethodsSortWithCode(String idClub) {
	String msj = "";
	for (int i = 0; i < clubs.size(); i++) {
		try{
		if(clubs.get(i).getIdClub().equals(idClub)) {
			msj = "Se encontro";
			ordenarClubesPorId();
		}else {
			throw new errorIdClubNotFound("No valido el id");
		}
	}catch(errorIdClubNotFound e) {
		System.out.println("No valido el id");
	}
}
	
	return msj;
}


public void getMethodsSortWithName(String idClub) {
	
	for (int i = 0; i < clubs.size(); i++) {
		if(clubs.get(i).getIdClub().equals(idClub)) {
			ordenarClubesPorNombre();
		}
	}
}

public void getMethodsSortWithDates(String idClub) {
	
	for (int i = 0; i < clubs.size(); i++) {
		if(clubs.get(i).getIdClub().equals(idClub)) {
			ordenarFechas();
		}
	}
}
		
		
}//Final
	

	

