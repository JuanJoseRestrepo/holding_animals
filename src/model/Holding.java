package model;

import java.io.BufferedWriter;
import java.io.File;
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
	
	public Holding() {
		clubs = new ArrayList<Club>();
	}
	
	public String findClubForOwner(long idClub, long idOwner,String ownerNames, String ownerSecondNames,String typeOfAnimalsPrefer,String bornDay) {
		String msj = "";
		
		for (int i = 0; i < clubs.size(); i++) {
			if(idClub == clubs.get(i).getIdClub()) {
				msj = "Se encontro el club y se agrego";
				clubs.get(i).addOwners(idOwner,ownerNames,ownerSecondNames,typeOfAnimalsPrefer,bornDay);
				clubs.get(i).saveObjectsInFile();
			}	
		}
		
		return msj;
	}
	
	public void registerClubInTheSystem(long idClub,String nameClub,String creationDate,String typeOfAnimals) {
		
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
	

	
}//Final de la clase
