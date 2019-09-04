package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Pet implements Comparable<Pet>,Comparator<Pet>  {

	private String idPet;
	private String petName;
	private String gender;
	private String typeOfPet;
	private String bornPetDay;
	
	public Pet(String idPet,String petName,String gender,String typeOfPet,String bornPetDay) {
		
		this.idPet = idPet;
		this.petName = petName;
		this.gender = gender;
		this.typeOfPet = typeOfPet;
		this.bornPetDay = bornPetDay;
		
	}
	
	public String getIdPet() {
		return idPet;
	}
	
	public void setIdPet(String idPet) {
		this.idPet = idPet;
	}
	
	public String getPetName() {
		return petName;
	}
	
	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getTypeOfPet() {
		return typeOfPet;
	}
	
	public void setTypeOfPet(String typeOfPet) {
		this.typeOfPet = typeOfPet;
	}
	
	public String getBornPetDay() {
		return bornPetDay;
	}
	
	public void setBornPetDay(String bornPetDay) {
		this.bornPetDay = bornPetDay;
	}
	
	public String toString() {
		String msj = "";
		
		return msj;
	}

	@Override
	public int compare(Pet o1, Pet o2) {
	
		
		return o1.getIdPet().compareTo(o2.getIdPet());
	}

	@Override
	public int compareTo(Pet o) {
		
		return petName.compareTo(o.getPetName());
	}
	
	public int compareGender(Pet o1, Pet o2) {
		
		return o1.getGender().compareTo(o2.getGender());
		
	}
	
	public int compareTypeOfPet(Pet o1) {
		
		return typeOfPet.compareTo(o1.getTypeOfPet());
		
	}
	
	public int compareBornDayPet(Pet o1) {
		
		return formatTheDateOfThis(bornPetDay).compareTo(formatTheDateOfThis(o1.getBornPetDay()));
		
	}
	
	public Date formatTheDateOfThis(String dateOfThis) {
		Date inicialDate = null;
		SimpleDateFormat dateOfThis1 = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			inicialDate = dateOfThis1.parse(dateOfThis);
		}catch(ParseException e) {
			e.getCause();
		}
		
		
		return inicialDate;
	}
	
}//Final de la clase pe
