package model;

public class Pet {

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
	
}//Final de la clase pe