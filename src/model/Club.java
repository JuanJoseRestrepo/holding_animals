package model;
import java.util.*;

public class Club {

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
	
	
}//finalDeLaClase
