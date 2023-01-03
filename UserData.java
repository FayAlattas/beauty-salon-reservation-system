package beauty.land.system;

public class UserData {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String dataOfBirth;
	private String addToMailList;
	private String notes;
	private String date;
	private String service;
	
	
	public UserData() {
		
	}

	public UserData(String firstName, String lastName, String phoneNumber, String email, String dataOfBirth,
			String addToMailList, String notes, String date, String service) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dataOfBirth = dataOfBirth;
		this.addToMailList = addToMailList;
		this.notes = notes;
		this.date = date;
		this.service = service;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(String dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}

	public String getAddToMailList() {
		return addToMailList;
	}

	public void setAddToMailList(String addToMailList) {
		this.addToMailList = addToMailList;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
		
}
