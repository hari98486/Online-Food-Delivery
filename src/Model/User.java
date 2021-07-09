package Model;

public class User {
	static int Choice;
	static String Name,Email,PhoneNumber,CityName,StreetName,UserName,DoorNo,Password;
	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public String getDoorNo() {
		return DoorNo;
	}

	public void setDoorNo(String doorNo) {
		DoorNo = doorNo;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public static int getChoice() {
		return Choice;
	}

	public static void setChoice(int choice) {
		Choice = choice;
	}
		
	}
