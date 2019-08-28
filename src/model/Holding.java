package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
		File fl = new File("clubesList.txt");
		
		try {
			FileWriter fw = new FileWriter(fl);
			BufferedWriter bfw = new BufferedWriter(fw);
			
			for(int i = 0; i < clubs.size();i++) {
				bfw.write(clubs.get(i).getIdClub() + "  " + clubs.get(i).getNameClub()
				+ " " + clubs.get(i).getCreationDate() + " " + clubs.get(i).getTypeOfAnimals());
				
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
	
	public ArrayList<Club> loadFileMocaForClub() {
		
		ArrayList<Club> clubsitos = new ArrayList<Club>();
		File fl = new File(archives);
		
		try {
		FileReader fr = new FileReader(fl);
		BufferedReader br = new BufferedReader(fr);
		String a = br.readLine();
		
		while(a  != null){
			
			String[] b = a.split(",");
			clubsitos.add(new Club(b[0], b[1], b[2], b[3]));
			
		}
		br.close();
		
		}catch(IOException e) {
			
		}
		
		return clubsitos;
		
	}
	
		
		
		
		
		
	}
	

	

