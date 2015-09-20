public class Author {

	//attributes of Author class
	String  name;
	String  phone;
	String  street, city, state;
	Integer zipCode;

	// constructor
	Author(String _name, String _city, String _state, String _street, Integer _zipCode, String _phone) {
		name = _name;
		city = _city;
		state = _state;
		street = _street;
		zipCode = _zipCode;
		phone = _phone;
	}

	// override the toString method
	@Override
	public String toString() {
		String author = name + ":" + street + ":" + city + ":" + state + ":" + zipCode + ":" + phone + "\n";
		return author;
	}
}